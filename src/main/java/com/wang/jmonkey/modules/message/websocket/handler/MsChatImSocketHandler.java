package com.wang.jmonkey.modules.message.websocket.handler;

import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.wang.jmonkey.modules.message.model.entity.MsChatRead;
import com.wang.jmonkey.modules.message.model.enums.MsChatHistoryTypeEnums;
import com.wang.jmonkey.modules.message.service.IMsChatGroupMemberService;
import com.wang.jmonkey.modules.message.service.IMsChatHistoryService;
import com.wang.jmonkey.modules.message.service.IMsChatReadService;
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
     * TODO 可以根据这个信息在前台显示那些用户在线，那些用户不在线，
     * TODO 还可以根据这个信息处理给不在线的人发消息的友好提示
     * TODO Redis？？？
     */
    private List<WebSocketSession> userList = new ArrayList<>();

    /**
     * 已登录用户的id
     */
    private List<String> userIdList = new ArrayList<>();

    /**
     * groupMemberService
     */
    @Autowired
    private IMsChatGroupMemberService groupMemberService;

    /**
     * IMsChatHistoryService
     */
    @Autowired
    private IMsChatHistoryService historyService;

    /**
     * readService
     */
    @Autowired
    private IMsChatReadService readService;

    /**
     * 用户上线后触发
     * @param webSocketSession
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        userList.add(webSocketSession);
        userIdList.add(webSocketSession.getAttributes().get("userId").toString());

        // 将消息未读的情况发送给这个刚登陆的用户




    }

    /**
     * 接收到消息时触发
     * TODO _msg_字符分割存在bug, 消息中有_msg_字符就bug了
     * TODO 参数太多，需要处理
     * @param webSocketSession
     * @param webSocketMessage
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        String message = webSocketMessage.getPayload().toString();
        String[] arr = message.split( "_msg_" );
        if (arr.length != 5) return;

        // 构建参数
        String imType = arr[0], // 聊天类型 Single私聊 Group群聊
            receiverId = arr[1], // 消息接收者id
            receiverName = arr[2],  // 消息接收者名称
            receiverImg = arr[3], // 消息接收者头像
            msg = arr[4],        // 消息内容
            senderId = webSocketSession.getAttributes().get("userId").toString(), // 消息发送者id
            senderName = webSocketSession.getAttributes().get("realName").toString(), // 消息发送者姓名
            senderPhoto = webSocketSession.getAttributes().get("userPhoto").toString(); // 消息发送者头像

        // 发送消息
        if (imType.equals("Single")) sendSingle(senderId, senderName, senderPhoto, receiverId, receiverName, receiverImg, msg);
        else sendGroup(senderId, senderName, senderPhoto, receiverId, receiverName, receiverImg, msg);

        // 记录未读消息情况
        if (!userIdList.contains(receiverId)) {
            MsChatRead read = new MsChatRead()
                    .setSender(senderId).setReceiver(receiverId).setType(imType.equals("Single") ? MsChatHistoryTypeEnums.Single : MsChatHistoryTypeEnums.Group);
            readService.save(read);
        }

        // 保存聊天记录
        MsChatHistory msChatHistory = new MsChatHistory()
                .setMsg(message).setReceiver(receiverId).setSender(senderId)
                .setType(imType.equals("Single") ? MsChatHistoryTypeEnums.Single : MsChatHistoryTypeEnums.Group);
        historyService.insert(msChatHistory);
    }

    /**
     * 发送私聊消息
     * @param senderId senderId
     * @param senderName senderName
     * @param senderPhoto senderPhoto
     * @param receiverId receiverId
     * @param msg msg
     */
    private void sendSingle(String senderId, String senderName, String senderPhoto,
                            String receiverId, String receiverName, String  receiverImg, String msg ) {
        userList.forEach( user -> {
            String userSId = user.getAttributes().get("userId").toString();
            if (userSId.equals(senderId) || userSId.equals(receiverId)) {
                try {
                    user.sendMessage(
                        this.renderImMessage("Single", senderId, senderName, senderPhoto, receiverId, receiverName, receiverImg, msg)
                    );
                } catch (IOException e) {
                    log.error("chat im send single exception : ", e);
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
    private void sendGroup(String senderId, String senderName, String senderPhoto,
                           String receiverId, String  receiverName, String  receiverImg, String msg ) {
        List<String> groupMemberList = groupMemberService.selectMemberIdByGroupId(receiverId);
        userList.forEach( user -> {
            String userSId = user.getAttributes().get("userId").toString();
            if (groupMemberList.contains(userSId)) {
                try {
                    user.sendMessage(
                        this.renderImMessage("Group", senderId, senderName, senderPhoto, receiverId, receiverName, receiverImg, msg)
                    );
                } catch (IOException e) {
                    log.error("chat im send group exception : ", e);
                }
            }
        });
    }

    /**
     * 构建发送的消息体
     * TODO 前台发送的消息有特殊格式影响json转换, 存在bug, 需要改进
     * @param imType
     * @param senderId
     * @param senderName
     * @param senderPhoto
     * @param receiverId
     * @param msg
     * @return
     */
    private TextMessage renderImMessage(String imType, String senderId, String senderName,
                                        String senderPhoto, String receiverId, String receiverName, String  receiverImg, String msg ) {
        String jsonMessage = "" +
                "{" +
                "\"imType\": \"" + imType + "\", " +
                "\"senderId\": \"" + senderId + "\", " +
                "\"senderName\": \"" + senderName + "\", " +
                "\"senderPhoto\": \"" + senderPhoto + "\", " +
                "\"receiverId\": \"" + receiverId + "\", " +
                "\"receiverName\": \"" + receiverName + "\", " +
                "\"receiverImg\": \"" + receiverImg + "\", " +
                "\"senderDate\": \"" + DateUtil.now() + "\", " +
                "\"msg\": \"" + msg + "\" " +
                "}";

        return new TextMessage(jsonMessage);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if(webSocketSession.isOpen()) webSocketSession.close();

        userList.remove(webSocketSession);
        userIdList.remove(webSocketSession.getAttributes().get("userId").toString());
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
        userIdList.remove(webSocketSession.getAttributes().get("userId").toString());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
