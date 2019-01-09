package com.wang.jmonkey.common.http.aop;

import com.wang.jmonkey.common.constant.SecurityConstants;
import com.wang.jmonkey.common.model.vo.UserVo;
import com.wang.jmonkey.common.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description: 对api接口层拦截
 * @Auther: HeJiawang
 * @Date: 2019/1/29
 */
@Slf4j
@Aspect
@Component
public class ApiAop {

    @Autowired
    private CacheManager cacheManager;

    /**
     * 拦截规则
     */
    @Pointcut("execution(public com.wang.jmonkey.common.http.result.* *(..))")
    public void pointCutR() { }

    /**
     * 拦截器具体实现
     *
     * @param pjp 切点 所有返回对象R
     * @return R  结果包装
     */
    @Around("pointCutR()")
    public Object methodRHandler(ProceedingJoinPoint pjp) {
        return methodHandler(pjp);
    }

    /**
     * 拦截方法
     * @param pjp
     * @return
     */
    private Object methodHandler(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String token = UserUtils.getToken(request);
        UserVo userVo = null;
        if (StringUtils.isNotEmpty(token))
            userVo = cacheManager.getCache(SecurityConstants.TOKEN_USER_DETAIL).get(token, UserVo.class);

        String username;
        if (userVo == null) {
            username = UserUtils.getUserName(request);
            if (StringUtils.isNotEmpty(username)) UserUtils.setUser(username);
        } else {
            username = userVo.getUsername();
            UserUtils.setUser(username);
        }

        log.info("———— api start ————————————————————————————————————————");
        log.info("login username:{}", username);
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("Remote IP : " + request.getRemoteAddr());
        log.info("Real IP : " + request.getHeader("X-Real-IP"));
        log.info("CLASS_METHOD : " + pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(pjp.getArgs()));


        Object result;
        try {
            result = pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            log.error("异常信息：", e);
            throw new RuntimeException(e);
        } finally {
            if (StringUtils.isNotEmpty(username)) UserUtils.clearAllUserInfo();
        }
        log.info("———— api end —————————————————————————————————————————");

        return result;
    }
}
