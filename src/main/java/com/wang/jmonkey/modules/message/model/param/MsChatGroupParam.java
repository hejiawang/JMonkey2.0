package com.wang.jmonkey.modules.message.model.param;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * <p>
 * 消息聊天群组信息 param
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Data
@Accessors(chain = true)
public class MsChatGroupParam extends MsChatGroup {

    /**
     * 群组成员id
     */
    private List<String> userList;

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

    public MsChatGroupParam setLimitStart() {
        this.limitStart = this.size * ( this.current - 1 );

        return this;
    }

    /**
     * 转换为entity信息
     * @return MsChatGroup
     */
    public MsChatGroup converToEntity(){
        MsChatGroup group = new MsChatGroup();
        BeanUtils.copyProperties(this, group);
        return group;
    }
}
