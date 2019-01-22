package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 操作日志 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-22
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 插入日志信息
     * @param entity 日志信息
     * @param tableName 表名
     * @return result
     */
    int save(@Param("log") SysLog entity, @Param("tableName") String tableName);

    /**
     * 删除所有日志信息
     * @param tableList 所有日志表名
     * @return result
     */
    int deleteAll(@Param("tableList")List<String> tableList);

    /**
     * 分页数据
     * @param limitStart limitStart
     * @param size size
     * @return result
     */
    List<SysLog> pageList(@Param("limitStart")int limitStart, @Param("size")int size);

    /**
     * 日志总数
     * @return result
     */
    long pageCount();
}
