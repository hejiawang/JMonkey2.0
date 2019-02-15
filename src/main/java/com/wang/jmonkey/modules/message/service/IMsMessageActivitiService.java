package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;

/**
 * <p>
 * 消息发布流程 service
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-15
 */
public interface IMsMessageActivitiService {

    /**
     * 开始发布消息的流程
     * @param publishUserId 发布人id
     * @param businesskey 消息id
     * @param audit 审核人id
     */
    ProcessInstance startPublish (String publishUserId, String businesskey, String audit);

    /**
     * 删除消息流程
     * @param piId processInstanceId
     * @return Boolean
     */
    Boolean deleteProcess(String piId);

    /**
     * 重新发布消息流程
     * @param piId processInstanceId
     * @param audit 审核人id
     * @return Boolean
     */
    Boolean modifyMessage(String piId, String audit);

    /**
     * 审核消息
     * @param taskId task id
     * @param state 审核状态
     * @return boolea
     */
    Boolean audit(String taskId, boolean state);

    /**
     * 构建消息消息的审核人id
     * @param messageDto messageDto
     * @return messageDto
     */
    MsMessageDto buildAudit(MsMessageDto messageDto);

    /**
     * 构建消息发布任务信息
     * @param messageDtoList messageDtoList
     * @return messageDtoList
     */
    List<MsMessageDto> buildAuditState (List<MsMessageDto> messageDtoList);

}
