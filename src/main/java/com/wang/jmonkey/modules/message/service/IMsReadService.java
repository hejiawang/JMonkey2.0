package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.entity.MsRead;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 消息阅读情况 服务类
 * TODO 阅读情况应该存在redis中
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
public interface IMsReadService extends IService<MsRead> {

    /**
     * 保存消息阅读情况
     * @param messageId messageId
     * @return boolean
     */
    boolean saveList(String messageId);

    /**
     * 删除消息阅读情况
     * @param messageId 消息id
     * @return boolean
     */
    boolean deleteByMsId(Serializable messageId);
}
