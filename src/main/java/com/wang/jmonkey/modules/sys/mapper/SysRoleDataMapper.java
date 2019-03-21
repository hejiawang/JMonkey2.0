package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.entity.SysRoleData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 角色数据规则表 Mapper 接口
 * </p>
 *
 * @author heJiawang
 * @since 2019-03-20
 */
public interface SysRoleDataMapper extends BaseMapper<SysRoleData> {

    /**
     * 删除角色授权的数据规则信息
     * @param scopeId 数据规则id
     * @return num
     */
    int deleteByScopeId(@Param("scopeId") Serializable scopeId);
}
