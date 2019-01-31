package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.entity.MsRead;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 消息阅读情况 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
public interface MsReadMapper extends BaseMapper<MsRead> {

    /**
     * 删除消息阅读情况
     * @param messageId 消息id
     * @return int
     */
    int deleteByMsId( @Param("messageId") Serializable messageId);

    /**
     * 设置消息为已读
     * 此处是将ms_read表中数据删除,好处是控制表中数据量，缺点是不能记录用户读取消息的时间,不能统计用户读过多少消息
     * @param messageId messageId
     * @param userId userId
     * @return Boolean
     */
    int read(@Param("messageId")String messageId, @Param("userId")String userId);
}
