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

    /**
     * 统计用户未读消息个数
     * @param userId 用户id
     * @return 个数
     */
    Integer countNoRead(String userId);

    /**
     * 设置消息为已读
     * 此处是将ms_read表中数据删除,好处是控制表中数据量，缺点是不能记录用户读取消息的时间,不能统计用户读过多少消息
     * @param messageId messageId
     * @param userId userId
     * @return Boolean
     */
    Boolean read(String messageId, String userId);
}
