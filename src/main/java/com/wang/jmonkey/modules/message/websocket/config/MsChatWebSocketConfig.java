package com.wang.jmonkey.modules.message.websocket.config;

import com.wang.jmonkey.modules.message.websocket.service.MsChatIMSocketHandshakeInterceptor;
import com.wang.jmonkey.modules.message.websocket.service.MsChatImSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @Description: 即时通讯 web socket
 * @Auther: HeJiawang
 * @Date: 2019-03-01
 */
@Configuration
@EnableWebMvc
@EnableWebSocket
public class MsChatWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    /**
     * Override registerWebSocketHandlers
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(msChatImSocketHandler(),"/ms/chat/im/socket")
                .addInterceptors(new MsChatIMSocketHandshakeInterceptor());

        registry.addHandler(msChatImSocketHandler(), "/sockjs/ms/chat/im/socket")
                .addInterceptors(new MsChatIMSocketHandshakeInterceptor())
                .withSockJS();
    }

    /**
     * register ms chat im WebSocketHandler
     * @return
     */
    @Bean
    public WebSocketHandler msChatImSocketHandler(){
        return new MsChatImSocketHandler();
    }
}
