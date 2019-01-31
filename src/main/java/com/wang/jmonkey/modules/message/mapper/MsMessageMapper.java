package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 消息 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
public interface MsMessageMapper extends BaseMapper<MsMessage> {

    /**
     * 获取消息dto信息
     * @param id 消息id
     * @return dto
     */
    MsMessageDto selectDtoById(@Param("id") Serializable id);

    /**
     * 获取消息总数
     * @param param param
     * @return long
     */
    long selectTotal(MsMessageSearchParam param);

    /**
     * 分页查询信息
     * @param param param
     * @return List<MsMessage>
     */
    List<MsMessage> selectListPage(MsMessageSearchParam param);

    /**
     * 获取消息查看列表
     * @param param param
     * @return List<MsMessage>
     */
    List<MsMessage> selectReadListPage(MsMessageSearchParam param);
}
