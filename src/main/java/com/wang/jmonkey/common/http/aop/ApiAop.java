package com.wang.jmonkey.common.http.aop;

import com.wang.jmonkey.common.constant.MqQueueConstant;
import com.wang.jmonkey.common.constant.SecurityConstants;
import com.wang.jmonkey.common.model.vo.UserVo;
import com.wang.jmonkey.common.utils.UserUtils;
import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.core.AmqpTemplate;
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
@Slf4j(topic="jmonkey.log")
@Aspect
@Component
public class ApiAop {

    /**
     * cacheManager
     */
    @Autowired
    private CacheManager cacheManager;

    /**
     * rabbitTemplate
     */
    @Autowired
    private AmqpTemplate rabbitTemplate;

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
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            log.error("异常信息：", e);
            throw new RuntimeException(e);
        } finally {
            if (StringUtils.isNotEmpty(username)) UserUtils.clearAllUserInfo();

            SysLog sysLog = new SysLog().setUserName(username).setIp(request.getHeader("X-Real-IP"))
                    .setUrl(request.getRequestURL().toString()).setHttpMethod(request.getMethod())
                    .setClassMethod(pjp.getSignature().getDeclaringTypeName() + "." + pjp.getSignature().getName())
                    .setParam(Arrays.toString(pjp.getArgs())).setHandleLength(String.valueOf(System.currentTimeMillis() - startTime));
            rabbitTemplate.convertAndSend(MqQueueConstant.LOG_QUEUE, sysLog);
        }
        log.info("———— api end —————————————————————————————————————————");

        return result;
    }
}
