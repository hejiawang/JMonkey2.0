package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.entity.MsChatGroupMember;
import com.wang.jmonkey.modules.message.mapper.MsChatGroupMemberMapper;
import com.wang.jmonkey.modules.message.service.IMsChatGroupMemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.sys.model.dto.SysDeptUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 消息聊天群组信息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Service
public class MsChatGroupMemberServiceImpl extends ServiceImpl<MsChatGroupMemberMapper, MsChatGroupMember> implements IMsChatGroupMemberService {

    /**
     * mapper
     */
    @Autowired
    private MsChatGroupMemberMapper mapper;

    /**
     * save member users
     * @param groupId groupId
     * @param userList userList
     * @return boolean
     */
    @Override
    public boolean saveList(String groupId, List<String> userList) {
        if (CollectionUtil.isNotEmpty(userList)) {
            userList.forEach(user ->
                super.insert(
                        new MsChatGroupMember().setUserId(user).setGroupId(groupId)
                )
            );
        }

        return true;
    }

    /**
     * modify member users
     * @param groupId groupId
     * @param userList userList
     * @return boolean
     */
    @Override
    public boolean modifyList(String groupId, List<String> userList) {
        return this.deleteList(groupId)
                && this.saveList(groupId, userList);
    }

    /**
     * 删除群组内的用户
     * @param groupId groupId
     * @return boolean
     */
    @Override
    public boolean deleteList(String groupId) {
        return mapper.deleteByGroupId(groupId) >= 0;
    }

    /**
     * 退出群组
     * @param groupMember 群组成员信息
     * @return Boolean
     */
    @Override
    public boolean outGroup(MsChatGroupMember groupMember) {
        return mapper.outGroup(groupMember) >= 0;
    }

    /**
     * 获取群组成员信息
     * @param groupId 群组id
     * @return 成员信息
     */
    @Override
    public List<SysUser> selectMemberByGroupId(String groupId) {
        return mapper.selectMemberByGroupId(groupId);
    }

    /**
     * 群组成员信息
     * @param groupId 群组id
     * @return SysDeptUserDto
     */
    @Override
    public List<SysDeptUserDto> deptUserList(String groupId) {
        return mapper.deptUserList(groupId);
    }
}
