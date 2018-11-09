package com.wang.jmonkey.common.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 记录状态枚举
 * @Auther: HeJiawang
 * @Date: 2018/6/23
 */
public enum RecordStatusEnum implements IEnum {

    Used("Used", "启用"),
    Disable("Disable", "禁用"),
    Delete("Delete", "删除");

    private String value;
    private String desc;

    RecordStatusEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }

}
