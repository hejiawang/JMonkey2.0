package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.entity.SysResource;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 系统资源表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
public interface ISysResourceService extends IService<SysResource> {

    /**
     * 删除该资源的资源信息，并将其子节点一并删除
     * @param rId
     * @return
     */
    boolean deleteByRId(Serializable rId);
}
