package com.wang.jmonkey.modules.ieg.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.ieg.model.entity.IegEnroll;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 报考指南——招生录取投档线类型 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-04
 */
public interface IIegEnrollService extends IService<IegEnroll> {

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    Page<IegEnroll> listPage(Page<IegEnroll> page, IegEnroll entity);

    /**
     * 校验信息是否存在
     * @param entity entity
     * @return Boolean
     */
    Boolean checkExist(IegEnroll entity);
}
