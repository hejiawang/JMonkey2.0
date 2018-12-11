package com.wang.jmonkey.modules.sys.model.enums;

import com.baomidou.mybatisplus.enums.IEnum;

/**
 * @Description: 按钮请求方式
 * @Auther: HeJiawang
 * @Date: 2018/12/10
 */
public enum ButtonMethodEnums implements IEnum {

    Get("Get", "Get"),
    Post("Post", "Post"),
    Put("Put", "Put"),
    Delete("Delete", "Delete");

    private String value;
    private String desc;

    ButtonMethodEnums(final String value, final String desc) {
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
