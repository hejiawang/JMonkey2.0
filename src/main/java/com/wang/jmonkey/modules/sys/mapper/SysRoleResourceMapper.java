package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.entity.SysRole;
import com.wang.jmonkey.modules.sys.model.entity.SysRoleResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色资源表 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-04
 */
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    /**
     * 获取角色以授权的资源id
     * @param roleId 角色id
     * @return
     */
    List<String> findRidByRole(@Param("roleId") String roleId);

    /**
     * 删除角色授权资源
     * @param roleId 角色id
     * @return
     */
    int deleteByRole(@Param("roleId") String roleId);

    /**
     * 删除角色的授权资源
     * @param rId 资源id
     * @return
     */
    int deleteByRid(@Param("rId") String rId);

    /**
     * 获取角色的权限标识
     * @param roleList 角色list
     * @return 权限标识
     */
    List<String> selectPermissionByRoles(@Param("roleList") List<SysRole> roleList);
}
