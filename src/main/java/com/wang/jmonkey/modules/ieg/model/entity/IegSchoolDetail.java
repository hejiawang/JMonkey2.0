package com.wang.jmonkey.modules.ieg.model.entity;

import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 报考指南——学校详细信息
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class IegSchoolDetail extends BaseEntity<IegSchoolDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 学校基本信息ID
     */
    private String schoolId;
    /**
     * 学校简介
     */
    private String describe;
    /**
     * 学院简介
     */
    private String faculty;
    /**
     * 食宿条件
     */
    private String life;
    /**
     * 当地气候饮食情况
     */
    private String environment;
    /**
     * 奖学金设置
     */
    private String scholarship;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
