package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.dto.MsChatGroupDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.message.model.param.MsChatGroupParam;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天群组信息 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface IMsChatGroupService extends IService<MsChatGroup> {

    /**
     * 保存实体信息
     * @param param 实体信息
     * @return Boolean
     */
    Boolean save(MsChatGroupParam param);

    /**
     * 修改实体信息
     * @param param 实体信息
     * @return Boolean
     */
    Boolean modify(MsChatGroupParam param);

    /**
     * 获取群组以及群组内成员信息
     * @param id 群组id
     * @return 群组信息
     */
    MsChatGroupDto selectDtoById(Serializable id);
}
