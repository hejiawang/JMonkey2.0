package com.wang.jmonkey.modules.message.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 消息列表的参数
 * @Auther: HeJiawang
 * @Date: 2019/1/31
 */
@Data
@Accessors(chain = true)
public class MsMessageSearchParam {

    /**
     * 消息标题
     */
    private String title;

    /**
     * 查看消息的人
     */
    private String userId;

    /**
     * 要查询的消息id list
     */
    private List<String> msIdList = new ArrayList<>();

    /**
     * 分页条件 分页条数
     */
    private Integer size;

    /**
     * 分页条件 当前页数
     */
    private Integer current;

    /**
     * 分页条件 mysql limit 起始值
     */
    private Integer limitStart;

    public MsMessageSearchParam setLimitStart() {
        this.limitStart = this.size * ( this.current - 1 );

        return this;
    }
}
