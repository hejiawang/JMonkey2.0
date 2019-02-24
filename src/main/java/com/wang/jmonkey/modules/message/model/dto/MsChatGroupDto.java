package com.wang.jmonkey.modules.message.model.dto;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 消息聊天群组信息 dto
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Data
@Accessors(chain = true)
public class MsChatGroupDto extends MsChatGroup {

    /**
     * 群组成员id
     */
    private List<String> userList;

    /**
     * 创建人姓名
     */
    private String creatorName;
}
