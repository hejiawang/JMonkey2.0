package com.wang.jmonkey.modules.message.websocket.config;

import com.wang.jmonkey.modules.message.websocket.service.MsChatIMSocketHandshakeInterceptor;
import com.wang.jmonkey.modules.message.websocket.service.MsChatImSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * TODO 目前没有进行token验证, 有安全问题
 * @Description: 即时通讯 web socket
 * @Auther: HeJiawang
 * @Date: 2019-03-01
 */
@Configuration
@EnableWebSocket
public class MsChatWebSocketConfig implements WebSocketConfigurer {

    /**
     * Override registerWebSocketHandlers
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(msChatImSocketHandler(),"/socket/ms/chat/im")
                .addInterceptors(new MsChatIMSocketHandshakeInterceptor());
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
