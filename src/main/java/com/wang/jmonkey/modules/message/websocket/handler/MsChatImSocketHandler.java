package com.wang.jmonkey.modules.message.websocket.handler;

import com.wang.jmonkey.modules.message.service.IMsChatGroupMemberService;
import com.xiaoleilu.hutool.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 已登录用户的webnsocket session
     */
    private List<WebSocketSession> userList = new ArrayList<>();

    /**
     * 以登录用户的id
     */
    // private List<String> userIdList = new ArrayList<>();

    /**
     * groupMemberService
     */
    @Autowired
    private IMsChatGroupMemberService groupMemberService;

    /**
     * 用户上线后触发
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        userList.add(webSocketSession);
        // userIdList.add(webSocketSession.getAttributes().get("userId").toString());
    }

    /**
     * 接收到消息时触发
     * @param webSocketSession
     * @param webSocketMessage
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        String message = webSocketMessage.getPayload().toString();
        String[] arr = message.split( "_msg_" );
        if (arr.length != 3) return;

        String imType = arr[0]; // 聊天类型 Single私聊 Group群聊
        String receiverId = arr[1]; // 消息接收者id
        String msg = arr[2];        // 消息内容
        String senderId = webSocketSession.getAttributes().get("userId").toString(); // 消息发送者id
        String senderName = webSocketSession.getAttributes().get("realName").toString(); // 消息发送者姓名
        String senderPhoto = webSocketSession.getAttributes().get("userPhoto").toString(); // 消息发送者头像

        if (imType.equals("Single")) {
            sendSingle(senderId, senderName, senderPhoto, receiverId, msg);
        } else { // Group
            sendGroup(senderId, senderName, senderPhoto, receiverId, msg);
        }
    }

    /**
     * 发送私聊消息
     * @param senderId senderId
     * @param senderName senderName
     * @param senderPhoto senderPhoto
     * @param receiverId receiverId
     * @param msg msg
     */
    private void sendSingle(String senderId, String senderName, String senderPhoto, String receiverId, String msg ) {
        userList.forEach( user -> {
            String userSId = user.getAttributes().get("userId").toString();
            if (userSId.equals(senderId) || userSId.equals(receiverId)) {
                try {
                    user.sendMessage( this.renderImMessage("Single", senderId, senderName, senderPhoto, receiverId, msg) );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 发送群聊消息
     * @param senderId senderId
     * @param senderName senderName
     * @param senderPhoto senderPhoto
     * @param receiverId receiverId
     * @param msg msg
     */
    private void sendGroup(String senderId, String senderName, String senderPhoto, String receiverId, String msg ) {
        List<String> groupMemberList = groupMemberService.selectMemberIdByGroupId(receiverId);
        userList.forEach( user -> {
            String userSId = user.getAttributes().get("userId").toString();
            if (groupMemberList.contains(userSId)) {
                try {
                    user.sendMessage( this.renderImMessage("Group", senderId, senderName, senderPhoto, receiverId, msg) );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 构建发送的消息体
     * @param imType
     * @param senderId
     * @param senderName
     * @param senderPhoto
     * @param receiverId
     * @param msg
     * @return
     */
    private TextMessage renderImMessage(String imType, String senderId, String senderName, String senderPhoto, String receiverId, String msg ) {
        String jsonMessage = "" +
                "{" +
                "\"imType\": \"" + imType + "\", " +
                "\"senderId\": \"" + senderId + "\", " +
                "\"senderName\": \"" + senderName + "\", " +
                "\"senderPhoto\": \"" + senderPhoto + "\", " +
                "\"receiverId\": \"" + receiverId + "\", " +
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
