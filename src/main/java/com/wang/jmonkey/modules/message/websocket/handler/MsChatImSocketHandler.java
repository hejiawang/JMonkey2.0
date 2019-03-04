package com.wang.jmonkey.modules.message.websocket.handler;

import com.xiaoleilu.hutool.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: MsChatImSocketHandler
 * @Auther: HeJiawang
 * @Date: 2019-03-01
 */
@Slf4j
public class MsChatImSocketHandler implements WebSocketHandler {

    /**
     *
     */
    private List<WebSocketSession> userList = new ArrayList<>();

    /**
     * 用户上线后触发
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        userList.add(webSocketSession);

    }

    /**
     * 接收到消息时触发
     * @param webSocketSession
     * @param webSocketMessage
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        String message = webSocketMessage.getPayload().toString();
        String[] arr = message.split( "_msg_" );
        if (arr.length != 2) return;

        String receiverId = arr[0]; // 消息接收者id
        String msg = arr[1];        // 消息内容
        String senderId = webSocketSession.getAttributes().get("userId").toString(); // 消息发送者id
        String senderName = webSocketSession.getAttributes().get("realName").toString(); // 消息发送者姓名
        String senderPhoto = webSocketSession.getAttributes().get("userPhoto").toString(); // 消息发送者头像

        userList.forEach( user -> {
            String userSId = user.getAttributes().get("userId").toString();
            if (userSId.equals(senderId) || userSId.equals(receiverId)) {
                try {
                    user.sendMessage( this.renderImMessage(senderId, senderName, senderPhoto, msg) );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private TextMessage renderImMessage(String senderId, String senderName, String senderPhoto, String msg ) {
        String jsonMessage = "" +
                "{" +
                "\"senderId\": \"" + senderId + "\", " +
                "\"senderName\": \"" + senderName + "\", " +
                "\"senderPhoto\": \"" + senderPhoto + "\", " +
                "\"senderDate\": \"" + DateUtil.now() + "\", " +
                "\"msg\": \"" + msg + "\" " +
                "}";

        return new TextMessage(jsonMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()) webSocketSession.close();

        userList.remove(webSocketSession);
    }

    /**
     * 关闭连接时触发
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        userList.remove(webSocketSession);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
