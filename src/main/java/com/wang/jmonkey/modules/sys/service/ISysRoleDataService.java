package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.entity.SysRoleData;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 角色数据规则表 服务类
 * </p>
 *
 * @author heJiawang
 * @since 2019-03-20
 */
public interface ISysRoleDataService extends IService<SysRoleData> {

    /**
     * 删除角色授权的数据规则信息
     * @param id 数据规则id
     * @return true
     */
    boolean deleteByScopeId(Serializable id);
}
