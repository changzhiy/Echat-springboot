package com.czy.echat.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.ServletContext;

/**
 * Spring websocket配置类
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 定义接收/websocket时采用wensocket连接，添加HttpSessionHandshakeInterceptor是为了websocket握手前将httpsession中的属性
     * 添加到websocket session中，withSockJS添加对sockJS的支持
     *
     * @param stompEndpointRegistry
     */
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/websocket").addInterceptors(new HttpSessionHandshakeInterceptor()).withSockJS();
    }

    /**
     * 配置消息代理，以/app为头的url将会先经过MessageMapping
     * /topic直接进入消息代理
     *
     * @param registry
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
