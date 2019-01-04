package com.wang.jmonkey.modules.sys.model.entity;

import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 角色资源表
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRoleResource extends BaseEntity<SysRoleResource> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 资源ID
     */
    private String resourceId;


    @Override
    protected Serializable pkVal() {
        return this.roleId + this.resourceId;
    }

}
