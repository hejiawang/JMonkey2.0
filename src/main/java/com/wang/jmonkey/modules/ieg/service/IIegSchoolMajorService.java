package com.wang.jmonkey.modules.ieg.service;

import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolMajor;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.ieg.model.param.IegSchoolMajorParam;

/**
 * <p>
 * 报考指南——学校历年录取信息 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-31
 */
public interface IIegSchoolMajorService extends IService<IegSchoolMajor> {

    /**
     * 保存院校专业信息
     * @param param 专业信息
     * @return true
     */
    Boolean save(IegSchoolMajorParam param);

    /**
     * 修改院校专业信息
     * @param param 专业信息
     * @return true
     */
    Boolean modify(IegSchoolMajorParam param);
}
