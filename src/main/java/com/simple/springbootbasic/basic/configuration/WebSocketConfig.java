package com.simple.springbootbasic.basic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Description 开启websocket 会出现 java.lang.IllegalStateException: Failed to register @ServerEndpoint class:
 * @Author Simple
 * @Date 2018/9/20 9:40
 * @Version 1.0
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
