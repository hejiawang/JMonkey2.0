package com.wang.jmonkey.modules.message.model.enums;

import com.wang.jmonkey.common.model.BaseEnum;

/**
 * @Description: 聊天类型 Single私聊 group群聊
 * @Auther: HeJiawang
 * @Date: 2019/2/23
 */
public enum MsChatHistoryTypeEnums implements BaseEnum {

    Single("Single", "私聊"),
    Group("Group", "群聊");

    private String value;
    private String desc;

    MsChatHistoryTypeEnums(final String value, final String desc) {
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
