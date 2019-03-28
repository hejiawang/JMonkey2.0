package com.wang.jmonkey.modules.ieg.model.param;

import com.wang.jmonkey.modules.ieg.model.entity.IegSchool;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolDetail;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 报考指南——院校Dto信息
 * @author heJiawang
 * @since 2019-03-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class IegSchoolParam extends IegSchool {

    /**
     * 院校特性编码
     */
    public List<String> features;
    /**
     * 学校简介
     */
    public String describe;
    /**
     * 学院简介
     */
    public String faculty;
    /**
     * 食宿条件
     */
    public String life;
    /**
     * 当地气候饮食情况
     */
    public String environment;
    /**
     * 奖学金设置
     */
    public String scholarship;

    /**
     * 转成院校基本信息
     * @return
     */
    public IegSchool converToEntity() {
        IegSchool school = new IegSchool();
        BeanUtils.copyProperties(this, school);

        return school;
    }

    /**
     * 转成院校详细信息
     * @return
     */
    public IegSchoolDetail converToDetail() {
        IegSchoolDetail school = new IegSchoolDetail();
        BeanUtils.copyProperties(this, school);

        return school;
    }
}
