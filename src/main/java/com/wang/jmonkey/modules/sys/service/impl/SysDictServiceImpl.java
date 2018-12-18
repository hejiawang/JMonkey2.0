package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.common.utils.TreeUtil;
import com.wang.jmonkey.modules.sys.model.dto.SysDictTreeDto;
import com.wang.jmonkey.modules.sys.model.entity.SysDict;
import com.wang.jmonkey.modules.sys.mapper.SysDictMapper;
import com.wang.jmonkey.modules.sys.service.ISysDictService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典值 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-17
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Autowired
    private SysDictMapper mapper;

    /**
     * 获取树形表格数据
     * @return
     */
    @Override
    public List<SysDictTreeDto> tree() {
        return  TreeUtil.bulid( mapper.tree(), null );
    }

    /**
     * 校验字典键值是否存在
     * @param sysDict
     * @return
     */
    @Override
    public Boolean checkValue(SysDict sysDict) {
        return mapper.checkValue(sysDict) > 0;
    }
}
