package com.wang.jmonkey.modules.ieg.mapper;

import com.wang.jmonkey.modules.ieg.model.dto.IegSchoolDto;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchool;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 报考指南——学校基本信息 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-26
 */
public interface IegSchoolMapper extends BaseMapper<IegSchool> {

    /**
     * 查找实体信息
     * @param id 实体ID
     * @return IegSchoolDto
     */
    IegSchoolDto findDtoById(@Param("id") Serializable id);
}
