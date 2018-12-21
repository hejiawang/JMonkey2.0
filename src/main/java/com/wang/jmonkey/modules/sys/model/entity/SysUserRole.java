package com.wang.jmonkey.modules.sys.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.wang.jmonkey.common.model.BaseEntity;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 用户角色表
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUserRole extends BaseEntity<SysUserRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId + this.roleId;
    }

}
