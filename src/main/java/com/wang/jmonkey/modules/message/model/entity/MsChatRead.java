package com.wang.jmonkey.modules.message.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.common.model.BaseEntity;

import com.wang.jmonkey.modules.message.model.enums.MsChatHistoryTypeEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天记录读取情况
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsChatRead extends BaseEntity<MsChatRead> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息发送者
     */
    @TableId(type = IdType.INPUT)
    private String sender;
    /**
     * 消息接收者
     */
    @TableId(type = IdType.INPUT)
    private String receiver;
    /**
     * 聊天类型 Single私聊 group群聊
     */
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private MsChatHistoryTypeEnums type;

    @Override
    protected Serializable pkVal() {
        return this.sender + this.receiver;
    }

}
