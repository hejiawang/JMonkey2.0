package com.wang.jmonkey.modules.ieg.mapper;

import com.wang.jmonkey.modules.ieg.model.dto.IegSchoolMajorDto;
import com.wang.jmonkey.modules.ieg.model.entity.IegMajor;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolMajor;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.ieg.model.param.IegSchoolMajorParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 报考指南——学校历年录取信息 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-31
 */
public interface IegSchoolMajorMapper extends BaseMapper<IegSchoolMajor> {

    /**
     * 获取院校中有哪些专业门类
     * @param schoolId 院校id
     * @return 专业门类
     */
    List<IegMajor> findMajorOneBySchool(@Param("schoolId") String schoolId);

    /**
     * 院校专业list
     * @param param param
     * @return IegSchoolMajorDto
     */
    List<IegSchoolMajorDto> list(IegSchoolMajorParam param);
}
