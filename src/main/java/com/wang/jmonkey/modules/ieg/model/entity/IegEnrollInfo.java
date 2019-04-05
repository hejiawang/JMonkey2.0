package com.wang.jmonkey.modules.ieg.model.entity;

import com.wang.jmonkey.common.model.BaseEntity;

import com.wang.jmonkey.common.utils.poi.annotation.ExcelField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 报考指南——招生录取投档线信息
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class IegEnrollInfo extends BaseEntity<IegEnrollInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 招生录取投档线类型ID
     */
    private String enrollId;
    /**
     * 投档单位编码
     */
    @ExcelField(title="投档单位编码", align=2)
    private String submitCode;
    /**
     * 院校名称
     */
    @ExcelField(title="院校名称", align=2)
    private String schoolName;
    /**
     * 分数
     */
    @ExcelField(title="分数", align=2)
    private Double score;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
