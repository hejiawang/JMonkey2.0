package com.wang.jmonkey.modules.message.model.param;

import com.wang.jmonkey.modules.message.model.enums.MsChatHistoryTypeEnums;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *     获取聊天历史记录时的参数
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-05
 */
@Data
@Accessors(chain = true)
public class MsChatImHistoryParam {

    /**
     * 聊天类型
     */
    private MsChatHistoryTypeEnums type;

    /**
     * 消息发送者id
     */
    private String senderId;

    /**
     * 消息接收方id
     */
    private String receiverId;

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

    public MsChatImHistoryParam setLimitStart() {
        this.limitStart = this.size * ( this.current - 1 );
        return this;
    }
}
