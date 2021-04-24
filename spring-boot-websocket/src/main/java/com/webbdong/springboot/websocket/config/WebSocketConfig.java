package com.webbdong.springboot.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author Webb Dong
 * @date 2021-04-24 12:21 PM
 */
@Configuration
public class WebSocketConfig {

    /**
     * 注入一个 ServerEndpointExporter,该 Bean 会自动注册使用 @ServerEndpoint 注解申明的 websocket endpoint
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
