package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.entity.SysResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统资源表 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 删除真正资源信息
     * @param tableName 资源表名
     * @param id 资源id
     * @return
     */
    Integer deleteResource(@Param("tableName") String tableName, @Param("id") String id);
}
