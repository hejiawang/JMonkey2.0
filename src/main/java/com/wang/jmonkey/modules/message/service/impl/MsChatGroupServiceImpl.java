package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.dto.MsChatGroupDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import com.wang.jmonkey.modules.message.mapper.MsChatGroupMapper;
import com.wang.jmonkey.modules.message.model.param.MsChatGroupParam;
import com.wang.jmonkey.modules.message.service.IMsChatGroupMemberService;
import com.wang.jmonkey.modules.message.service.IMsChatGroupService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天群组信息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Service
public class MsChatGroupServiceImpl extends ServiceImpl<MsChatGroupMapper, MsChatGroup> implements IMsChatGroupService {

    /**
     * mapper
     */
    @Autowired
    private MsChatGroupMapper mapper;

    /**
     * groupMemberService
     */
    @Autowired
    private IMsChatGroupMemberService groupMemberService;

    /**
     * 保存实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @Override
    public Boolean save(MsChatGroupParam param) {
        MsChatGroup group = param.converToEntity();
        return super.insert(group)
                && groupMemberService.saveList(group.getId(), param.getUserList());
    }

    /**
     * 修改实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @Override
    public Boolean modify(MsChatGroupParam param) {
        MsChatGroup group = param.converToEntity();
        return super.insert(group)
                && groupMemberService.modifyList(group.getId(), param.getUserList());
    }

    /**
     * 删除群组信息并删除群组内的用户
     * @param id 群组id
     * @return boolean
     */
    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id)
                && groupMemberService.deleteList(String.valueOf(id));
    }

    /**
     * 获取群组以及群组内成员信息
     * @param id 群组id
     * @return 群组信息
     */
    @Override
    public MsChatGroupDto selectDtoById(Serializable id) {
        return mapper.selectDtoById(id);
    }
}
