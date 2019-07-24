package com.wang.jmonkey.common.oauth.listener;

import com.wang.jmonkey.common.constant.SecurityConstants;
import com.wang.jmonkey.common.oauth.service.impl.UserDetailsImpl;
import com.wang.jmonkey.common.utils.RedisUtil;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.util.Base64;

/**
 * @Description: 登录成功监听事件
 * @Auther: HeJiawang
 * @Date: 2019/3/1
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    /**
     * redis util
     */
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 登录成功后清空登录错误次数
     * @param e AuthenticationSuccessEvent
     */
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        if (e.getAuthentication().getPrincipal() instanceof UserDetailsImpl) {
            UserDetailsImpl u = (UserDetailsImpl)e.getAuthentication().getPrincipal();
            String userName = u.getUsername();

            redisUtil.del(SecurityConstants.LOIN_CODE_PREFIX + userName);

            // this.onlyOneUser(userName);
        }
    }

    /**
     * 一个用户只能在一个浏览器登录
     * 后登陆的踢掉之前登录的
     * @param userName userName
     */
    private void onlyOneUser(String userName) {
        String prefix = SecurityConstants.JMONKEY_PREFIX + "access:*";
        redisUtil.keys(prefix).forEach(str -> {
            String token = redisUtil.get(str).toString();
            String key = Base64.getEncoder().encodeToString(SecurityConstants.JWT_KEY.getBytes());

            String username = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
                    .get("user_name").toString();
            if (userName.equals(username)) {
                redisUtil.del(
                        SecurityConstants.JMONKEY_PREFIX + "access:" + token,
                        SecurityConstants.JMONKEY_PREFIX + "auth:" + token,
                        SecurityConstants.JMONKEY_PREFIX + "access_to_refresh:" + token
                );
            }
        });
    }
}
