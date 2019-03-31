package com.wang.jmonkey.modules.ieg.model.enums;

import com.wang.jmonkey.common.model.BaseEnum;

/**
 * @Description: 专业记录类型 common通用专业 other其他类型专业
 * @Auther: HeJiawang
 * @Date: 2019/3/24
 */
public enum IegSchoolMajorRecordTypeEnums implements BaseEnum {

    Common("Common", "通用专业"),
    Other("Other", "其他类型专业");

    private String value;
    private String desc;

    IegSchoolMajorRecordTypeEnums(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDesc(){
        return this.desc;
    }
}
