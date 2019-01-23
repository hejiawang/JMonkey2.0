package com.wang.jmonkey.modules.sys.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-22
 */
@Slf4j(topic="jmonkey.log")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysLog extends BaseEntity<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 用户登录名称
     */
    private String userName;
    /**
     * 操作ip
     */
    private String ip;
    /**
     * 请求路径
     */
    private String url;
    /**
     * 请求方式
     */
    private String httpMethod;
    /**
     * 请求方法
     */
    private String classMethod;
    /**
     * 请求参数
     */
    private String param;
    /**
     * 操作时长
     */
    private String handleLength;

    public SysLog setUserName(String userName) {
        this.userName = userName;
        log.info("login username:{}", userName);
        return this;
    }

    public SysLog setIp(String ip) {
        this.ip = ip;
        log.info("Remote IP : " + ip);
        return this;
    }

    public SysLog setUrl(String url) {
        this.url = url;
        log.info("URL : " + url);
        return this;
    }

    public SysLog setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
        log.info("HTTP_METHOD : " + httpMethod);
        return this;
    }

    public SysLog setClassMethod(String classMethod) {
        this.classMethod = classMethod;
        log.info("CLASS_METHOD : " + classMethod);
        return this;
    }

    public SysLog setParam(String param) {
        this.param = param;
        log.info("ARGS : " + param);
        return this;
    }

    public SysLog setHandleLength(String handleLength) {
        this.handleLength = handleLength;
        log.info("use time:" + handleLength);
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
