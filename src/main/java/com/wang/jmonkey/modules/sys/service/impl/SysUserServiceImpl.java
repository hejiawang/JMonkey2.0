package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.sys.model.dto.SysUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.wang.jmonkey.modules.sys.mapper.SysUserMapper;
import com.wang.jmonkey.modules.sys.model.param.SysUserParam;
import com.wang.jmonkey.modules.sys.service.ISysUserDeptService;
import com.wang.jmonkey.modules.sys.service.ISysUserRoleService;
import com.wang.jmonkey.modules.sys.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    /**
     * 用户信息密码加密规则
     */
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 用户部门信息 service
     */
    @Autowired
    private ISysUserDeptService userDeptService;

    /**
     * 用户角色信息 service
     */
    @Autowired
    private ISysUserRoleService userRoleService;

    /**
     * 用户mapper
     */
    @Autowired
    private SysUserMapper mapper;

    /**
     * 获取用户分页信息
     * @param page
     * @param param
     * @return
     */
    @Override
    public Page<SysUserDto> selectPage(Page<SysUserDto> page, SysUserParam param) {
        param.setLimitStart();
        page.setRecords(mapper.selectDtoPage(param)).setTotal(mapper.selectTotal(param));
        return page;
    }

    /**
     * 保存用户信息
     * @param userParam 用户param
     * @return 是否保存成功
     */
    @Transactional
    @Override
    public Boolean save(SysUserParam userParam) {
        SysUser sysUser = userParam.converToEntity();
        // 加密用户密码
        sysUser.setPassword(ENCODER.encode(userParam.getPassword()));

        return super.insert(sysUser)
                && userDeptService.mergeDepts(sysUser.getId(), userParam.getDeptIds())
                && userRoleService.mergeRoles(sysUser.getId(), userParam.getRoleIds());
    }

    /**
     * 修改用户信息
     * @param userParam 用户param
     * @return 是否修改成功
     */
    @Transactional
    @Override
    public Boolean modify(SysUserParam userParam) {
        SysUser sysUser = userParam.converToEntity();
        return super.updateById(sysUser)
                && userDeptService.mergeDepts(sysUser.getId(), userParam.getDeptIds())
                && userRoleService.mergeRoles(sysUser.getId(), userParam.getRoleIds());
    }

    /**
     * 获取用户dto信息
     * @param id 用户id
     * @return
     */
    @Override
    public SysUserDto selectDtoById(Serializable id) {
        return mapper.selectDtoById(id);
    }

    /**
     * 删除用户信息
     * @param id 用户id
     * @return 是否删除成功
     */
    @Transactional
    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id)
                && userDeptService.deleteByUserId(id)
                && userRoleService.deleteByUserId(id);
    }
}
