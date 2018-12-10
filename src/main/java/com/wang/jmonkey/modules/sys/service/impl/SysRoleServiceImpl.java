package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.sys.model.entity.SysRole;
import com.wang.jmonkey.modules.sys.mapper.SysRoleMapper;
import com.wang.jmonkey.modules.sys.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  角色 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-10
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private SysRoleMapper mapper;

    /**
     * 获取角色分页数据
     * @param page 分页信息
     * @param sysRole 查询条件
     * @return 角色分页数据
     */
    @Override
    public Page<SysRole> selectPage(Page<SysRole> page, SysRole sysRole) {
        EntityWrapper<SysRole> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysRole());
        wrapper.like("name", sysRole.getName(), SqlLike.DEFAULT);
        wrapper.like("code", sysRole.getCode(), SqlLike.DEFAULT);
        wrapper.orderBy( "create_date", false );

        return this.selectPage(page, wrapper);
    }

    /**
     * 校验角色code是否存在
     * @param sysRole 角色信息
     * @return true 存在
     */
    @Override
    public Boolean checkCode(SysRole sysRole) {
        return mapper.checkCode(sysRole) > 0;
    }

    /**
     * 校验角色名称是否存在
     * @param sysRole 角色信息
     * @return true 存在
     */
    @Override
    public Boolean checkName(SysRole sysRole) {
        return mapper.checkName(sysRole) > 0;
    }
}
