package com.wang.jmonkey.modules.sys.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 系统显示方式
 * @Auther: HeJiawang
 * @Date: 2018/12/10
 */
public enum SystemShowTypeEnums implements IEnum {

    Tabs("Tabs", "标签页"),
    Breadcrumb("Breadcrumb", "导航条");

    private String value;
    private String desc;

    SystemShowTypeEnums(final String value, final String desc) {
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
