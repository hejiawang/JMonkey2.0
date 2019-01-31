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
}
