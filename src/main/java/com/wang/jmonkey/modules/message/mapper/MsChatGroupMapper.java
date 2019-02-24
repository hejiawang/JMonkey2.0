package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.dto.MsChatGroupDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 消息聊天群组信息 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface MsChatGroupMapper extends BaseMapper<MsChatGroup> {

    /**
     * 获取群组以及群组内成员信息
     * @param id 群组id
     * @return 群组信息
     */
    MsChatGroupDto selectDtoById(@Param("id") Serializable id);
}
