package com.wang.jmonkey.modules.message.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.common.model.BaseEntity;

import com.wang.jmonkey.modules.message.model.enums.MsChatHistoryTypeEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天记录
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsChatHistory extends BaseEntity<MsChatHistory> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 消息发送者
     */
    private String sender;
    /**
     * 消息接收者
     */
    private String receiver;
    /**
     * 聊天信息
     */
    private String msg;
    /**
     * 聊天类型 Single私聊 group群聊
     */
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private MsChatHistoryTypeEnums type;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
