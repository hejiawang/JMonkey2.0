package com.wang.jmonkey.modules.sys.service.impl;

import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.wang.jmonkey.modules.sys.mapper.SysUserMapper;
import com.wang.jmonkey.modules.sys.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
