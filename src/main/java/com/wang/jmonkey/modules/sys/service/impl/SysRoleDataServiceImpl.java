package com.wang.jmonkey.modules.sys.service.impl;

import com.wang.jmonkey.modules.sys.model.entity.SysRoleData;
import com.wang.jmonkey.modules.sys.mapper.SysRoleDataMapper;
import com.wang.jmonkey.modules.sys.service.ISysRoleDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 角色数据规则表 服务实现类
 * </p>
 *
 * @author heJiawang
 * @since 2019-03-20
 */
@Service
public class SysRoleDataServiceImpl extends ServiceImpl<SysRoleDataMapper, SysRoleData> implements ISysRoleDataService {

    /**
     * mapper
     */
    @Autowired
    private SysRoleDataMapper mapper;

    /**
     * 删除角色授权的数据规则信息
     * @param id 数据规则id
     * @return true
     */
    @Override
    public boolean deleteByScopeId(Serializable id) {
        return mapper.deleteByScopeId(id) >= 0;
    }
}
