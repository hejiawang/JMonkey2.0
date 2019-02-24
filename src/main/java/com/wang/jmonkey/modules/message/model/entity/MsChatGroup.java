package com.wang.jmonkey.modules.message.model.entity;

import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天群组信息
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MsChatGroup extends BaseEntity<MsChatGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 群组名称
     */
    private String name;
    /**
     * 群组信息头像
     */
    private String img;
    /**
     * 群组创始人
     */
    private String creator;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
