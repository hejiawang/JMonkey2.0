package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.service.IMsMessageActivitiService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 消息发布流程 service impl
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-15
 */
@Service
public class MsMessageActivitiServiceImpl implements IMsMessageActivitiService {

    /**
     * activiti IdentityService
     */
    @Autowired
    IdentityService identityservice;

    /**
     * activiti RuntimeService
     */
    @Autowired
    RuntimeService runtimeservice;

    /**
     * activiti TaskService
     */
    @Autowired
    TaskService taskservice;

    /**
     * activiti HistoryService
     */
    @Autowired
    HistoryService histiryservice;

    @Override
    public ProcessInstance startPublish(String publishUserId, String businesskey, String audit) {
        identityservice.setAuthenticatedUserId(publishUserId);

        Map<String, Object> variables = new HashMap<String, Object>(){
            {
                put("publishUserId", publishUserId);
                put("isAudit", StringUtils.isNotEmpty(audit));
                put("auditUserId", audit);
            }
        };
        return runtimeservice.startProcessInstanceByKey("messagePublish", businesskey, variables);
    }

    /**
     * 删除消息流程
     * TODO if else 可以用catch exception改进
     * @param piId processInstanceId
     * @return Boolean
     */
    @Override
    public Boolean deleteProcess(String piId) {
        Task task = taskservice.createTaskQuery().processInstanceId(piId).singleResult();
        if (null == task) histiryservice.deleteHistoricProcessInstance(piId);
        else runtimeservice.deleteProcessInstance(piId, "delete message");

        return true;
    }

    /**
     * 重新发布消息流程
     * @param piId processInstanceId
     * @param audit 审核人id
     * @return Boolean
     */
    @Override
    public Boolean modifyMessage(String piId, String audit) {
        Task task = taskservice.createTaskQuery().processInstanceId(piId).singleResult();
        Map<String, Object> variables = new HashMap<String, Object>(){
            {
                put("isAudit", StringUtils.isNotEmpty(audit));
                put("auditUserId", audit);
            }
        };
        taskservice.complete(task.getId(), variables);

        return true;
    }

    /**
     * 审核消息
     * @param taskId task id
     * @param state 审核状态
     * @return boolea
     */
    @Override
    public Boolean audit(String taskId, boolean state) {
        Map<String, Object> variables = new HashMap<String, Object>(){
            {
                put("state", state);
            }
        };
        taskservice.complete(taskId, variables);

        return true;
    }

    /**
     * 构建消息消息的审核人id
     * @param messageDto messageDto
     * @return messageDto
     */
    @Override
    public MsMessageDto buildAudit(MsMessageDto messageDto) {
        List<HistoricVariableInstance> variableList = histiryservice.createHistoricVariableInstanceQuery()
                .processInstanceId(messageDto.getPiId()).variableName("auditUserId").list();
        variableList.forEach(variable ->
                messageDto.setAudit(
                        variable.getValue() != null ? variable.getValue().toString() : ""
                )
        );

        return messageDto;
    }

    /**
     * 构建消息的审核状态
     * @param messageDtoList messageDtoList
     * @return 消息的审核状态
     */
    @Override
    public List<MsMessageDto> buildAuditState (List<MsMessageDto> messageDtoList) {
        messageDtoList.forEach(msMessageDto ->{
            Task task = taskservice.createTaskQuery().processInstanceId(msMessageDto.getPiId()).singleResult();
            msMessageDto.setTaskKey(null != task ? task.getTaskDefinitionKey() : "endPublish")
                    .setTaskName(null != task ? task.getName() : "审核通过")
                    .setTaskId(null != task ? task.getId() : "");
        });

        return messageDtoList;
    }

}
