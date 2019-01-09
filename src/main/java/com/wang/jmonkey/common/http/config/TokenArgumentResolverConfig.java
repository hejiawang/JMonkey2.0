package com.wang.jmonkey.common.http.config;

import com.wang.jmonkey.common.model.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@Configuration
public class TokenArgumentResolverConfig implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        log.info("TokenArgumentResolverConfig supportsParameter: " + methodParameter.getParameterType());
        return methodParameter.getParameterType().equals(UserVo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        log.info("TokenArgumentResolverConfig resolveArgument");
        return null;
    }
}
