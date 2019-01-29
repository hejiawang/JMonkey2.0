package com.wang.jmonkey.common.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: Yes No
 * @Auther: HeJiawang
 * @Date: 2018/12/10
 */
public enum YesOrNoEnum implements IEnum {

    Yes("Yes", "是"),
    No("No", "否"),
    Temp("Temp", "Temp");

    private String value;
    private String desc;

    YesOrNoEnum(final String value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
