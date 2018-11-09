package com.wang.jmonkey.common.oauth.service.impl;

import com.wang.jmonkey.common.model.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * @Description: 授权服务UserDetailService
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo userVo = new UserVo().setUsername("admin").setPassword(new BCryptPasswordEncoder().encode("123456"));
        return new UserDetailsImpl( userVo );
    }
}
