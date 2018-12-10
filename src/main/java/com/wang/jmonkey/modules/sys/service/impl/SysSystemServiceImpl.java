package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.modules.sys.model.entity.SysSystem;
import com.wang.jmonkey.modules.sys.mapper.SysSystemMapper;
import com.wang.jmonkey.modules.sys.service.ISysSystemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统配置 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-10
 */
@Service
public class SysSystemServiceImpl extends ServiceImpl<SysSystemMapper, SysSystem> implements ISysSystemService {

    /**
     * 获取系统信息列表
     * @return
     */
    @Override
    public List<SysSystem> selectList() {
        EntityWrapper<SysSystem> wrapper = new EntityWrapper<>();
        wrapper.orderBy( "sort", true );
        return this.selectList(wrapper);
    }
}
