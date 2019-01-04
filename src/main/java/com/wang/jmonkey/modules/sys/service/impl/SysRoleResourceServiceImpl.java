package com.wang.jmonkey.modules.sys.service.impl;

import com.wang.jmonkey.modules.sys.model.entity.SysRoleResource;
import com.wang.jmonkey.modules.sys.mapper.SysRoleResourceMapper;
import com.wang.jmonkey.modules.sys.service.ISysRoleResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-04
 */
@Service
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements ISysRoleResourceService {

    @Autowired
    private SysRoleResourceMapper mapper;

    /**
     * 获取角色以授权的资源id
     * @param roleId 角色id
     * @return
     */
    @Override
    public List<String> findRidByRole(String roleId) {
        return mapper.findRidByRole(roleId);
    }

    /**
     * 为角色授权
     * @param roleId 角色id
     * @param rIds 资源id集合
     * @return
     */
    @Transactional
    @Override
    public Boolean auth(String roleId, List<String> rIds) {
        mapper.deleteByRole(roleId);

        if(CollectionUtil.isNotEmpty(rIds)){
            rIds.forEach( rId ->
                super.insert(
                        new SysRoleResource().setRoleId(roleId).setResourceId(rId)
                )
            );
        }
        return true;
    }

    /**
     * 删除角色的授权资源
     * @param roleId 角色id
     * @return
     */
    @Override
    public boolean deleteByRole(String roleId) {
        return mapper.deleteByRole(roleId) >= 0;
    }

    /**
     * 删除角色的授权资源
     * @param rId 资源id
     * @return
     */
    @Override
    public boolean deleteByRid(String rId) {
        return mapper.deleteByRid(rId) >= 0;
    }
}
