package com.wang.jmonkey.modules.message.model.entity;

import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 消息附件
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsFile extends BaseEntity<MsFile> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 消息ID
     */
    private String messageId;
    /**
     * 消息附件名称
     */
    private String name;
    /**
     * 消息附件存储路径
     */
    private String path;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
