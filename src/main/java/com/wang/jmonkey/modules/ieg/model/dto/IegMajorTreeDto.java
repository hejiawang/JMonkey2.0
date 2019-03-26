package com.wang.jmonkey.modules.ieg.model.dto;

import com.wang.jmonkey.common.model.BaseTreeNode;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description: 报考指南——专业树信息
 * @Auther: heJiawang
 * @Date: 2019-03-24
 */
@Data
@Accessors(chain = true)
public class IegMajorTreeDto extends BaseTreeNode<IegMajorTreeDto> {

    /**
     * 专业名称
     */
    private String name;
}
