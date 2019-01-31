package com.wang.jmonkey.modules.message.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;

import java.io.Serializable;

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

    /**
     * 获取小松dto信息
     * @param id 消息id
     * @return dto
     */
    MsMessageDto selectDtoById(Serializable id);

    /**
     * 分页查询信息
     * @param page page
     * @param param param
     * @return List<MsMessage>
     */
    Page<MsMessage> selectListPage(Page<MsMessage> page, MsMessageSearchParam param);

    /**
     * 获取消息查看列表
     * @param page page
     * @param param param
     * @return result
     */
    Page<MsMessage> selectReadPage(Page<MsMessage> page, MsMessageSearchParam param);
}
