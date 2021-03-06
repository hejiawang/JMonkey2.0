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
    Page<MsMessageDto> selectListPage(Page<MsMessageDto> page, MsMessageSearchParam param);

    /**
     * 获取消息查看列表
     * @param page page
     * @param param param
     * @return result
     */
    Page<MsMessageDto> selectReadPage(Page<MsMessageDto> page, MsMessageSearchParam param);

    /**
     * 消息审核list
     * @param page page
     * @param param param
     * @return MsMessageDto list
     */
    Page<MsMessageDto> auditList(Page<MsMessageDto> page, MsMessageSearchParam param);

    /**
     * 审核消息
     * @param state 审核是否通过
     * @param taskId 任务id
     * @return Boolean
     */
    Boolean audit(boolean state, String taskId, String messageId);

    /**
     * 修改实体信息
     * @param param 实体信息
     * @return Boolean
     */
    Boolean modify(MsMessageParam param);
}
