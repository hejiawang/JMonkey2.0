package com.wang.jmonkey.modules.message.websocket.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Description: MsChatImSocketHandler
 * @Auther: HeJiawang
 * @Date: 2019-03-01
 */
@Slf4j
public class MsChatImSocketHandler implements WebSocketHandler {

    /**
     * 用户上线后触发
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        log.debug("afterConnectionEstablished");
    }

    /**
     * 接收到消息时触发
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        log.debug("handleMessage");
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.debug("handleTransportError");
    }

    /**
     * 关闭连接时触发
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        log.debug("afterConnectionClosed");
    }

    @Override
    public boolean supportsPartialMessages() {
        log.debug("supportsPartialMessages");
        return false;
    }
}
