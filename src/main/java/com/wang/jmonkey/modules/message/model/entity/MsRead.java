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
 * 消息阅读情况
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsRead extends BaseEntity<MsRead> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 阅读人ID
     */
    private String userId;
    /**
     * 消息ID
     */
    private String messageId;
    /**
     * 阅读状态 Yes已读 No未读
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private YesOrNoEnum state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
