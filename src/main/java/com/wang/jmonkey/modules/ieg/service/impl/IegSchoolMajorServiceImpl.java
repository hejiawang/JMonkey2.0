package com.wang.jmonkey.modules.ieg.service.impl;

import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolMajor;
import com.wang.jmonkey.modules.ieg.mapper.IegSchoolMajorMapper;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolMajorFeatures;
import com.wang.jmonkey.modules.ieg.model.param.IegSchoolMajorParam;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolMajorFeaturesService;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolMajorService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报考指南——学校历年录取信息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-31
 */
@Service
public class IegSchoolMajorServiceImpl extends ServiceImpl<IegSchoolMajorMapper, IegSchoolMajor> implements IIegSchoolMajorService {

    /**
     * majorFeaturesService
     */
    @Autowired
    private IIegSchoolMajorFeaturesService majorFeaturesService;

    /**
     * 保存院校专业信息
     * @param param 专业信息
     * @return true
     */
    @Override
    public Boolean save(IegSchoolMajorParam param) {
        IegSchoolMajor schoolMajor = param.converToEntity();

        return super.insert(schoolMajor)
                && majorFeaturesService.merge(schoolMajor.getId(), param.getFeatures());
    }

    /**
     * 修改院校专业信息
     * @param param 专业信息
     * @return true
     */
    @Override
    public Boolean modify(IegSchoolMajorParam param) {
        IegSchoolMajor schoolMajor = param.converToEntity();

        return super.updateById(schoolMajor)
                && majorFeaturesService.merge(schoolMajor.getId(), param.getFeatures());
    }
}
