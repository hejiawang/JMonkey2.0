package com.wang.jmonkey.modules.sys.service.impl;

import com.wang.jmonkey.modules.sys.model.entity.SysDataScope;
import com.wang.jmonkey.modules.sys.mapper.SysDataScopeMapper;
import com.wang.jmonkey.modules.sys.service.ISysDataScopeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 获取数据规则定义 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-20
 */
@Service
public class SysDataScopeServiceImpl extends ServiceImpl<SysDataScopeMapper, SysDataScope> implements ISysDataScopeService {

    /**
     * mapper
     */
    @Autowired
    private SysDataScopeMapper mapper;

    /**
     * 校验名称是否存在
     * @param dataScope
     * @return Boolean
     */
    @Override
    public Boolean checkName(SysDataScope dataScope) {
        return mapper.checkName(dataScope) > 0;
    }

    /**
     * 校验拦截路径是否重复
     * @param dataScope
     * @return Boolean
     */
    @Override
    public Boolean checkUrl(SysDataScope dataScope) {
        return mapper.checkUrl(dataScope) > 0;
    }
}
