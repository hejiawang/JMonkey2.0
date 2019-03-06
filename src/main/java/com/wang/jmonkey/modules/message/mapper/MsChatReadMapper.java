package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.entity.MsChatRead;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 消息聊天记录读取情况 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-06
 */
public interface MsChatReadMapper extends BaseMapper<MsChatRead> {

    /**
     * 删除消息未读情况
     * @param read read
     * @return int
     */
    int deleteByRead(MsChatRead read);
}
