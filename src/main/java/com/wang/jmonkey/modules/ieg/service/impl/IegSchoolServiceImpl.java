package com.wang.jmonkey.modules.ieg.service.impl;

import com.wang.jmonkey.modules.ieg.model.entity.IegSchool;
import com.wang.jmonkey.modules.ieg.mapper.IegSchoolMapper;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolDetail;
import com.wang.jmonkey.modules.ieg.model.param.IegSchoolParam;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolDetailService;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolFeaturesService;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 报考指南——学校基本信息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-26
 */
@Service
public class IegSchoolServiceImpl extends ServiceImpl<IegSchoolMapper, IegSchool> implements IIegSchoolService {

    /**
     * detailService
     */
    @Autowired
    private IIegSchoolDetailService detailService;

    /**
     * featuresService
     */
    @Autowired
    private IIegSchoolFeaturesService featuresService;

    /**
     * 新建院校信息
     * @param schoolParam 院校信息
     * @return true
     */
    @Transactional
    @Override
    public Boolean save(IegSchoolParam schoolParam) {
        IegSchool school = schoolParam.converToEntity();
        IegSchoolDetail schoolDetail = schoolParam.converToDetail();

        return super.insert(school)
                && detailService.merge(schoolDetail.setSchoolId(school.getId()))
                && featuresService.mergeList(schoolParam.getFeatures(), school.getLogo());
    }

    /**
     * 修改实体信息
     * @param schoolParam 实体信息
     * @return Boolean
     */
    @Override
    public Boolean modify(IegSchoolParam schoolParam) {
        IegSchool school = schoolParam.converToEntity();
        IegSchoolDetail schoolDetail = schoolParam.converToDetail();

        return super.updateById(school)
                && detailService.merge(schoolDetail.setSchoolId(school.getId()))
                && featuresService.mergeList(schoolParam.getFeatures(), school.getLogo());
    }
}
