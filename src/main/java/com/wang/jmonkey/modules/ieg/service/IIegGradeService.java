package com.wang.jmonkey.modules.ieg.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.ieg.model.entity.IegGrade;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 报考指南——一分一段表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-02
 */
public interface IIegGradeService extends IService<IegGrade> {

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    Page<IegGrade> list(Page<IegGrade> page, IegGrade entity);
}
