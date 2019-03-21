package com.wang.jmonkey.modules.sys.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 数据规则 Dto
 * @author HeJiawang
 * @since 2019-03-21
 */
@Data
@Accessors(chain = true)
public class SysRoleDataRuleDto {

    /**
     * 请求链接
     */
    private String url;

    /**
     * 数据规则控制sql
     */
    private String sqlSegment;
}
