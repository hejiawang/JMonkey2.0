package com.wang.jmonkey.common.oauth.service.impl;

import com.wang.jmonkey.common.oauth.service.PermissionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 权限 service实现
 * @Auther: HeJiawang
 * @Date: 2018/6/24
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Value("${jmonkey.baseUrl}")
    private String BASE_URL;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 判断登录者是否拥有访问路径的权限
     * @param request HttpServletRequest 请求路径信息
     * @param authentication 认证信息
     * @return true/false
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        boolean hasPermission = false;

        if (principal != null) {
            if (CollectionUtils.isEmpty(grantedAuthorityList)) return hasPermission;

            System.out.println(request.getRequestURI());
            if( antPathMatcher.match(BASE_URL + "/test/list", request.getRequestURI()) ){
                hasPermission = true;
            }
        }

        return true;
    }

}
