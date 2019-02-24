package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroupMember;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 消息聊天群组信息 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface MsChatGroupMemberMapper extends BaseMapper<MsChatGroupMember> {

    /**
     * 删除群组用户
     * @param groupId 群组id
     * @return 删除个数
     */
    int deleteByGroupId(@Param("groupId") String groupId);
}
