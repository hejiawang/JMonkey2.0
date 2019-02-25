package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroupMember;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.sys.model.dto.SysDeptUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 消息聊天群组信息 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface IMsChatGroupMemberService extends IService<MsChatGroupMember> {

    /**
     * save member users
     * @param groupId groupId
     * @param userList userList
     * @return boolean
     */
    boolean saveList(String groupId, List<String> userList);

    /**
     * modify member users
     * @param groupId groupId
     * @param userList userList
     * @return boolean
     */
    boolean modifyList(String groupId, List<String> userList);

    /**
     * 删除群组内的用户
     * @param groupId groupId
     * @return boolean
     */
    boolean deleteList(String groupId);

    /**
     * 退出群组
     * @param groupMember 群组成员信息
     * @return Boolean
     */
    boolean outGroup(MsChatGroupMember groupMember);

    /**
     * 获取群组成员信息
     * @param groupId 群组id
     * @return 成员信息
     */
    List<SysUser> selectMemberByGroupId(String groupId);

    /**
     * 群组成员信息
     * @param groupId 群组id
     * @return SysDeptUserDto
     */
    List<SysDeptUserDto> deptUserList(String groupId);
}
