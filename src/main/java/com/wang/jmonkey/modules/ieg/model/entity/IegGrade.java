package com.wang.jmonkey.modules.ieg.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.common.model.BaseEntity;

import com.wang.jmonkey.modules.ieg.model.enums.IegGradeTypeEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 报考指南——一分一段表
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class IegGrade extends BaseEntity<IegGrade> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 年
     */
    private Integer year;
    /**
     * 分数
     */
    private Integer score;
    /**
     * 人数
     */
    private Integer number;
    /**
     * 累计排名
     */
    private Integer sort;

    /**
     * 类型 W文科 L理科
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private IegGradeTypeEnums type;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
