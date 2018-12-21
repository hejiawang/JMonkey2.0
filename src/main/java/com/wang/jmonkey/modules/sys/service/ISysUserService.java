package com.wang.jmonkey.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.sys.model.dto.SysUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.sys.model.param.SysUserParam;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-07
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 获取用户分页信息
     * @param page
     * @param param
     * @return
     */
    Page<SysUserDto> selectPage(Page<SysUserDto> page, SysUserParam param );

    /**
     * 保存用户信息
     * @param userParam 用户param
     * @return 是否保存成功
     */
    Boolean save(SysUserParam userParam);

    /**
     * 修改用户信息
     * @param userParam 用户param
     * @return 是否修改成功
     */
    Boolean modify(SysUserParam userParam);

    /**
     * 获取用户dto信息
     * @param id 用户id
     * @return
     */
    SysUserDto selectDtoById(Serializable id);
}
