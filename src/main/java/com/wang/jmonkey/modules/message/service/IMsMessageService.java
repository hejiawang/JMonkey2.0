package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;

/**
 * <p>
 * 消息 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
public interface IMsMessageService extends IService<MsMessage> {

    /**
     * 发布消息
     * @param param 消息对象
     * @return Boolean
     */
    Boolean save(MsMessageParam param);
}
