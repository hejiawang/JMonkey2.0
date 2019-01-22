package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.utils.UUIDUtil;
import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import com.wang.jmonkey.modules.sys.mapper.SysLogMapper;
import com.wang.jmonkey.modules.sys.service.ISysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-22
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    /**
     * mapper
     */
    @Autowired
    private SysLogMapper mapper;

    /**
     * 日志表前缀
     */
    private final String TABLE_NAME_START = "sys_log_";

    /**
     * 所有表名
     */
    private final List<String> TABLE_NAME_LIST = new ArrayList<String>(){
        {
            for ( int i = 0; i< 10; i++){
                add(TABLE_NAME_START + i);
            }
        }
    };

    /**
     * TODO sharding 页表限制太多，没在这个单工程中使用
     * 根据日期最后一位分表
     * @param entity
     * @return
     */
    @Override
    public boolean insert(SysLog entity) {
        String dayStr = String.valueOf(LocalDate.now().getDayOfMonth());
        String tableName = TABLE_NAME_START + dayStr.substring(dayStr.length() - 1);

        entity.setId(UUIDUtil.value());
        return mapper.save(entity, tableName) > 0;
    }

    /**
     * 删除所有日志信息
     * @return
     */
    @Override
    public Boolean deleteAll() {
        return mapper.deleteAll(TABLE_NAME_LIST) > 0;
    }

    /**
     * 获取分页数据
     * @param page
     * @return
     */
    @Override
    public Page<SysLog> selectPage(Page<SysLog> page) {
        int limitStart = page.getSize() * ( page.getCurrent() - 1 );
        page.setRecords(mapper.pageList(limitStart, page.getSize())).setTotal(mapper.pageCount())
                .setCurrent(page.getCurrent()).setSize(page.getSize());
        return page;
    }
}
