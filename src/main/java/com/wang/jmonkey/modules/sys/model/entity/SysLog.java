package com.wang.jmonkey.modules.sys.model.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-22
 */
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
