package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.entity.MsChatRead;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 消息聊天记录读取情况 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-06
 */
public interface IMsChatReadService extends IService<MsChatRead> {

    /**
     * 保存消息未读情况
     * @param read read
     * @return boolean
     */
    boolean save(MsChatRead read);
}
