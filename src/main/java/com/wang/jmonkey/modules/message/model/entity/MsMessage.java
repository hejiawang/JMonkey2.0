package com.wang.jmonkey.modules.message.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.common.model.BaseEntity;


import com.wang.jmonkey.common.model.enums.YesOrNoEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 消息
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsMessage extends BaseEntity<MsMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 消息头
     */
    private String title;
    /**
     * 消息信息
     */
    private String content;
    /**
     * 审核状态 Yes审核通过 No审核未通过 Temp正在审核
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private YesOrNoEnum state;
    /**
     * 消息重要程度
     */
    private String rate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
