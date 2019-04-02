package com.wang.jmonkey.modules.ieg.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.ieg.model.entity.IegGrade;
import com.wang.jmonkey.modules.ieg.mapper.IegGradeMapper;
import com.wang.jmonkey.modules.ieg.service.IIegGradeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报考指南——一分一段表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-02
 */
@Service
public class IegGradeServiceImpl extends ServiceImpl<IegGradeMapper, IegGrade> implements IIegGradeService {

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @Override
    public Page<IegGrade> list(Page<IegGrade> page, IegGrade entity) {
        EntityWrapper<IegGrade> wrapper = new EntityWrapper<>();
        wrapper.setEntity(entity);
        wrapper.orderBy("score", false);

        return super.selectPage(page, wrapper);
    }
}
