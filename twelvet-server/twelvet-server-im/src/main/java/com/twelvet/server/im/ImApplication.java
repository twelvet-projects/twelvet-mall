package com.twelvet.server.im;

import cn.twelvet.websocket.netty.domain.WebSocketEndpointServer;
import cn.twelvet.websocket.netty.standard.WebSocketEndpointExporter;
import cn.twelvet.websocket.netty.standard.WebsocketServer;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.twelvet.framework.core.annotation.EnableTWTFeignClients;
import com.twelvet.framework.core.annotation.EnableTwelveTConfig;
import com.twelvet.framework.core.constants.ServiceNameConstants;
import com.twelvet.framework.security.annotation.EnableTWTResourceServer;
import com.twelvet.framework.swagger.annotation.EnableTwelveTSwagger2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 启动程序
 */
@EnableTwelveTSwagger2
@EnableTWTResourceServer
@MapperScan("com.twelvet.**.mapper")
@EnableTwelveTConfig
@EnableTWTFeignClients
@SpringBootApplication
public class ImApplication implements CommandLineRunner {

    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;

    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosDiscoveryProperties.getServerAddr());
        properties.setProperty(PropertyKeyConst.USERNAME, nacosDiscoveryProperties.getUsername());
        properties.setProperty(PropertyKeyConst.PASSWORD, nacosDiscoveryProperties.getPassword());
        properties.setProperty(PropertyKeyConst.NAMESPACE, nacosDiscoveryProperties.getNamespace());
        InetAddress address = InetAddress.getLocalHost();

        Map<InetSocketAddress, WebsocketServer> addressWebsocketServerMap = WebSocketEndpointExporter.getAddressWebsocketServerMap();
        for (Map.Entry<InetSocketAddress, WebsocketServer> inetSocketAddressWebsocketServerEntry : addressWebsocketServerMap.entrySet()) {
            NamingService namingService = NamingFactory.createNamingService(properties);
            WebsocketServer websocketServer = inetSocketAddressWebsocketServerEntry.getValue();
            WebSocketEndpointServer endpointServer = websocketServer.getEndpointServer();
            namingService.registerInstance(ServiceNameConstants.WEB_SOCKET_SERVICE, address.getHostAddress(), endpointServer.getPort());
        }
    }
}
