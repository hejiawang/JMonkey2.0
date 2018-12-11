package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.modules.sys.model.entity.SysResource;
import com.wang.jmonkey.modules.sys.mapper.SysResourceMapper;
import com.wang.jmonkey.modules.sys.model.enums.ResourceTypeEnums;
import com.wang.jmonkey.modules.sys.service.ISysResourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统资源表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Autowired
    private SysResourceMapper mapper;

    /**
     * 资源类型对应的表名
     */
    private Map<ResourceTypeEnums, String> rMap = new HashMap<ResourceTypeEnums, String>(){
        {
            put(ResourceTypeEnums.Menu, "sys_menu");
            put(ResourceTypeEnums.System, "sys_system");
            put(ResourceTypeEnums.Button, "sys_button");
        }
    };

    /**
     * 删除该资源的资源信息，并将其子节点一并删除
     * @param rId 当前资源id
     * @return
     */
    @Override
    public boolean deleteByRId(Serializable rId) {
        SysResource resource = super.selectOne(
                new EntityWrapper<>(
                        new SysResource().setRId(String.valueOf(rId))
                )
        );
        return this.deleteResource(resource);
    }

    /**
     * 递归删除资源信息，子节点资源信息
     * @param resource 资源信息
     * @return
     */
    public boolean deleteResource(SysResource resource) {
        // 子节点资源信息
        List<SysResource> rChildren = this.selectList(
                new EntityWrapper<>(
                        new SysResource().setParentId(String.valueOf(resource.getId()))
                )
        );
        // 删除子节点信息
        rChildren.forEach( r -> this.deleteResource(r) );

        // 子节点信息删除后，删除自己
        mapper.deleteResource(rMap.get(resource.getType()), resource.getRId());
        return super.deleteById(resource.getId());
    }
}
