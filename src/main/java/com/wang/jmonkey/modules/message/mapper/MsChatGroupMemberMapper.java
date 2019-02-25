package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroupMember;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.sys.model.dto.SysDeptUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 退出群组
     * @param groupMember 群组成员信息
     * @return Boolean
     */
    int outGroup(MsChatGroupMember groupMember);

    /**
     * 获取群组成员信息
     * @param groupId 群组id
     * @return 成员信息
     */
    List<SysUser> selectMemberByGroupId(@Param("groupId") String groupId);

    /**
     * 群组成员信息
     * @param groupId 群组id
     * @return SysDeptUserDto
     */
    List<SysDeptUserDto> deptUserList(@Param("groupId") String groupId);
}
