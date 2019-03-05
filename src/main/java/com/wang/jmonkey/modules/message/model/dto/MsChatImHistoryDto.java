package com.wang.jmonkey.modules.message.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *     聊天历史记录
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-05
 */
@Data
@Accessors(chain = true)
public class MsChatImHistoryDto {

    private String imType;
    private String senderId;
    private String senderName;
    private String senderPhoto;
    private String receiverId;
    private String receiverName;
    private String receiverImg;
    private String senderDate;
    private String msg;
}
