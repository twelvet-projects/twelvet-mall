package com.twelvet.server.im.websocket;

import cn.twelvet.websocket.netty.annotation.*;
import cn.twelvet.websocket.netty.domain.NettySession;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@WebSocketEndpoint(path = "/", port = 80)
public class MyWebSocket {

	@BeforeHandshake
	public void handshake(NettySession nettySession, HttpHeaders headers, @RequestParam String req,
			@RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
		nettySession.setSubprotocols("stomp");
		if (!"ok".equals(req)) {
			System.out.println("Authentication failed!");
			// nettySession.close();
		}
	}

	@OnOpen
	public void onOpen(NettySession nettySession, HttpHeaders headers, @RequestParam String req,
			@RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap) {
		System.out.println("new connection");
		System.out.println(req);
	}

	@OnClose
	public void onClose(NettySession nettySession) {
		System.out.println("one connection closed");
	}

	@OnError
	public void onError(NettySession nettySession, Throwable throwable) {
		throwable.printStackTrace();
	}

	@OnMessage
	public void onMessage(NettySession nettySession, String message) {
		System.out.println(message);
		nettySession.sendText("Hello Netty!");
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
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			switch (idleStateEvent.state()) {
				case READER_IDLE:
					System.out.println("read idle");
					break;
				case WRITER_IDLE:
					System.out.println("write idle");
					break;
				case ALL_IDLE:
					System.out.println("all idle");
					break;
				default:
					break;
			}
		}
	}

}