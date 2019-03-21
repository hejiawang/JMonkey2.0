package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.sys.model.entity.SysDataScopeRule;
import com.wang.jmonkey.modules.sys.mapper.SysDataScopeRuleMapper;
import com.wang.jmonkey.modules.sys.service.ISysDataScopeRuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据规则 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-20
 */
@Service
public class SysDataScopeRuleServiceImpl extends ServiceImpl<SysDataScopeRuleMapper, SysDataScopeRule> implements ISysDataScopeRuleService {

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @Override
    public Page<SysDataScopeRule> selectPageList(Page<SysDataScopeRule> page, SysDataScopeRule entity) {
        EntityWrapper wrapper = new EntityWrapper<SysDataScopeRule>();
        wrapper.setEntity(entity);

        return super.selectPage(page, wrapper);
    }
}
