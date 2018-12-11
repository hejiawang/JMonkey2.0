package com.wang.jmonkey.common.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树形结构父类
 * @Auther: HeJiawang
 * @Date: 2018/12/11
 */
@Data
@Accessors(chain = true)
public abstract class BaseTreeNode extends BaseVo {

    /**
     * 自身id
     */
    protected String id;

    /**
     * 父级id
     */
    protected String parentId;

    /**
     * 子节点集合
     */
    protected List<BaseTreeNode> children = new ArrayList<>();

    /**
     * 添加子节点
     * @param node
     */
    public void addChildren(BaseTreeNode node) {
        children.add(node);
    }
}
