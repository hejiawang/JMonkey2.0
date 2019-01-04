package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.entity.SysRoleResource;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-04
 */
public interface ISysRoleResourceService extends IService<SysRoleResource> {

    /**
     * 获取角色以授权的资源id
     * @param roleId 角色id
     * @return
     */
    List<String> findRidByRole(String roleId);

    /**
     * 为角色授权
     * @param roleId 角色id
     * @param rIds 资源id集合
     * @return
     */
    Boolean auth(String roleId, List<String> rIds);

    /**
     * 删除角色的授权资源
     * @param roleId 角色id
     * @return
     */
    boolean deleteByRole(String roleId);

    /**
     * 删除角色的授权资源
     * @param rId 资源id
     * @return
     */
    boolean deleteByRid(String rId);
}
