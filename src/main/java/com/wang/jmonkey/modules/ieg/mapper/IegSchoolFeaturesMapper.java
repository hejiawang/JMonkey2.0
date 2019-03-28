package com.wang.jmonkey.modules.ieg.mapper;

import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolFeatures;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 报考指南——学校特性 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-27
 */
public interface IegSchoolFeaturesMapper extends BaseMapper<IegSchoolFeatures> {

    /**
     * 删除院校的特征
     * @param schoolId schoolId
     * @return int
     */
    int deleteBySchool(@Param("schoolId") String schoolId);
}
