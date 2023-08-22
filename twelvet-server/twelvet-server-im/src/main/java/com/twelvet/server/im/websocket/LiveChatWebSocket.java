package com.twelvet.server.im.websocket;

import cn.twelvet.websocket.netty.annotation.*;
import cn.twelvet.websocket.netty.domain.NettySession;
import com.twelvet.api.im.domain.dto.IMDTO;
import com.twelvet.api.im.domain.vo.IMVO;
import com.twelvet.framework.utils.JacksonUtils;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@WebSocketEndpoint(path = "/live", port = "88")
public class LiveChatWebSocket {

    private static final Logger log = LoggerFactory.getLogger(LiveChatWebSocket.class);

    /**
     * 链接的NettySession，需要进行心跳检测 在分布式下，记录NettySession在哪个机器上
     * 在需要发送的时候通过机器IP，或者其他唯一特征进行发送即可完成分布式
     */
    private final static Map<ChannelId, NettySession> SESSIONS = new HashMap<>();

    @BeforeHandshake
    public void handshake(NettySession nettySession, HttpHeaders headers, @RequestParam String req,
                          @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        nettySession.setSubprotocols("stomp");
        // TODO 登录认证
    }

    /**
     * 记录链接
     *
     * @param nettySession
     * @param headers
     * @param req
     * @param reqMap
     * @param arg
     * @param pathMap
     */
    @OnOpen
    public void onOpen(NettySession nettySession, HttpHeaders headers, @RequestParam String req,
                       @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
        log.info("one connection open");
        ChannelId channelId = nettySession.id();
        SESSIONS.put(nettySession.id(), nettySession);

        IMVO imvo = new IMVO();
        imvo.setSelf(false);
        imvo.setInfo("有新用户加入直播间");
        imvo.setUsername("系统");
        String message = JacksonUtils.toJson(imvo);

        for (Map.Entry<ChannelId, NettySession> channelIdNettySessionEntry : SESSIONS.entrySet()) {
            ChannelId channelIdTemp = channelIdNettySessionEntry.getKey();
            NettySession session = channelIdNettySessionEntry.getValue();
            if (!channelIdTemp.equals(channelId)) {
                session.sendText(message);
            } else {
                IMVO imVOSelf = new IMVO();
                imVOSelf.setSelf(true);
                imVOSelf.setInfo("成功加入直播间");
                imVOSelf.setUsername("系统");
                String messageSelf = JacksonUtils.toJson(imVOSelf);
                session.sendText(messageSelf);
            }
        }

    }

    @OnClose
    public void onClose(NettySession nettySession) {
        log.info("one connection closed");
        SESSIONS.remove(nettySession.id());
    }

    @OnError
    public void onError(NettySession nettySession, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(NettySession nettySession, String message) {
        ChannelId channelId = nettySession.id();

        IMDTO imDTO = JacksonUtils.readValue(message, IMDTO.class);
        assert imDTO != null;
        imDTO.setSelf(false);
        for (Map.Entry<ChannelId, NettySession> channelIdNettySessionEntry : SESSIONS.entrySet()) {
            ChannelId channelIdTemp = channelIdNettySessionEntry.getKey();
            if (!channelIdTemp.equals(channelId)) {
                NettySession session = channelIdNettySessionEntry.getValue();
                session.sendText(JacksonUtils.toJson(imDTO));
            }
        }
    }

    @OnBinary
    public void onBinary(NettySession nettySession, byte[] bytes) {
        for (byte b : bytes) {
            System.out.println(b);
        }
        nettySession.sendBinary(bytes);
    }

    @OnEvent
    public void onEvent(NettySession nettySession, Object evt) {
        if (evt instanceof IdleStateEvent idleStateEvent) {
            switch (idleStateEvent.state()) {
                case READER_IDLE -> log.info("read idle");
                case WRITER_IDLE -> log.info("write idle");
                case ALL_IDLE -> log.info("all idle");
                default -> {
                }
            }
        }
    }

}
