package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.dto.MsChatGroupDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.message.model.param.MsChatGroupParam;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

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

    /**
     * 获取当前登录人所在的群组list
     * @param userId 当前登录人Id
     * @return List<MsChatGroup>
     */
    List<MsChatGroupDto> list(@Param("userId")String userId);

    /**
     * 获取用户所在群组的id集合
     * @param userId 用户id
     * @return 群组id集合
     */
    List<String> listGroupIds(@Param("userId")String userId);

    /**
     * 分页查询信息
     * @param param param
     * @return MsChatGroup
     */
    List<MsChatGroupDto> selectPageList(MsChatGroupParam param);

    /**
     * 分页查询信息总数
     * @param param param
     * @return long
     */
    long selectPageTotal(MsChatGroupParam param);

}
