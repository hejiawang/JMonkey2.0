package com.wang.jmonkey.modules.message.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
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
public class MsChatGroupMember extends BaseEntity<MsChatGroupMember> {

    private static final long serialVersionUID = 1L;

    /**
     * 群组id
     */
    @TableId(type = IdType.INPUT)
    private String groupId;
    /**
     * 群组成员id
     */
    @TableId(type = IdType.INPUT)
    private String userId;

    @Override
    protected Serializable pkVal() {
        return this.groupId + this.userId;
    }

}
