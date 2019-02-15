package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.mapper.MsMessageMapper;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
import com.wang.jmonkey.modules.message.service.IMsFileService;
import com.wang.jmonkey.modules.message.service.IMsMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.message.service.IMsReadService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 消息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
@Service
public class MsMessageServiceImpl extends ServiceImpl<MsMessageMapper, MsMessage> implements IMsMessageService {

    /**
     * file service
     */
    @Autowired
    private IMsFileService fileService;

    /**
     * read service
     */
    @Autowired
    private IMsReadService readService;

    /**
     * mapper
     */
    @Autowired
    private MsMessageMapper mapper;

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

    /**
     * 发布消息
     * @param param 消息对象
     * @return Boolean
     */
    @Transactional
    @Override
    public Boolean save (MsMessageParam param) {
        // 保存消息信息
        MsMessage message = param.converToEntity();
        super.insert(message);
        fileService.saveList(message.getId(), param.getFileList());

        // 如果没有审核人,设置用户读取消息的情况
        if (StringUtils.isEmpty(param.getAudit())) readService.saveList(message.getId());

        // 开始发布消息的流程
        ProcessInstance ins = this.startPublish(param.getPublishUserId(), message.getId(), param.getAudit());
        return super.updateById(message.setPiId(ins.getId()));
    }

    /**
     * 开始发布消息的流程
     * @param publishUserId 发布人id
     * @param businesskey 消息id
     * @param audit 审核人id
     */
    private ProcessInstance startPublish (String publishUserId, String businesskey, String audit) {
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
     * 获取消息dto信息
     * @param id 消息id
     * @return dto
     */
    @Override
    public MsMessageDto selectDtoById(Serializable id) {
        MsMessageDto messageDto = mapper.selectDtoById(id);

        // 获取最后审核人员
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
     * 删除消息
     * @param id 消息id
     * @return boolean
     */
    @Transactional
    @Override
    public boolean deleteById(Serializable id) {
        // 删除流程实例
        // TODO 可以用catch Exception改进
        String piId = super.selectById(id).getPiId();
        Task task = taskservice.createTaskQuery().processInstanceId(piId).singleResult();
        if (null == task) histiryservice.deleteHistoricProcessInstance(piId);
        else runtimeservice.deleteProcessInstance(piId, "delete message");

        return super.deleteById(id) && fileService.deleteByMsId(id) && readService.deleteByMsId(id);
    }

    /**
     * 分页查询信息
     * @param page page
     * @param param param
     * @return List<MsMessage>
     */
    @Override
    public Page<MsMessageDto> selectListPage(Page<MsMessageDto> page, MsMessageSearchParam param) {
        param.setLimitStart();
        page.setRecords(
            this.buildAuditState(mapper.selectListPage(param))
        ).setTotal(
            mapper.selectTotal(param)
        );
        return page;
    }

    /**
     * 获取消息查看列表
     * @param page page
     * @param param param
     * @return result result
     */
    @Override
    public Page<MsMessageDto> selectReadPage(Page<MsMessageDto> page, MsMessageSearchParam param) {
        param.setLimitStart();

        // 查询流程结束（消息发布审核通过）的message id
        // TODO 如果要对message查询怎么办？？？？？？？
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery()
                .processDefinitionKey("messagePublish").finished().orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> processList = process.listPage(param.getLimitStart(), param.getSize());
        processList.forEach(history -> param.getMsIdList().add(history.getBusinessKey()) );

        page.setRecords(mapper.selectReadListPage(param)).setTotal(process.count());
        return page;
    }

    /**
     * 消息审核list
     * @param page page
     * @param param param
     * @return MsMessageDto list
     */
    @Override
    public Page<MsMessageDto> auditList(Page<MsMessageDto> page, MsMessageSearchParam param) {
        param.setLimitStart();

        // 查询当前登录人审核的消息流程
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery().processDefinitionKey("messagePublish")
                .variableValueEquals("auditUserId", param.getUserId()).orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> processList = process.listPage(param.getLimitStart(), param.getSize());
        processList.forEach(history -> param.getMsIdList().add(history.getBusinessKey()) );

        page.setRecords(
            this.buildAuditState(mapper.selectAuditListPage(param))
        ).setTotal(
            process.count()
        );
        return page;
    }

    /**
     * 构建消息的审核状态
     * @param messageDtoList messageDtoList
     * @return 消息的审核状态
     */
    private List<MsMessageDto> buildAuditState (List<MsMessageDto> messageDtoList) {
        messageDtoList.forEach(msMessageDto ->{
            Task task = taskservice.createTaskQuery().processInstanceId(msMessageDto.getPiId()).singleResult();
            msMessageDto.setTaskKey(null != task ? task.getTaskDefinitionKey() : "endPublish")
                    .setTaskName(null != task ? task.getName() : "审核通过")
                    .setTaskId(null != task ? task.getId() : "");
        });

        return messageDtoList;
    }

    /**
     * 审核消息
     * @param state 审核是否通过
     * @param taskId 任务id
     * @param userId userId
     * @return Boolean
     */
    @Override
    public Boolean audit(boolean state, String taskId, String messageId, String userId) {
        Map<String, Object> variables = new HashMap<String, Object>(){
            {
                put("state", state);
            }
        };

        // taskservice.claim(taskId, userId);
        taskservice.complete(taskId, variables);

        if (state) readService.saveList(messageId);

        return true;
    }

    /**
     * 修改实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @Override
    public Boolean modify(MsMessageParam param) {
        // 修改消息信息
        MsMessage message = param.converToEntity();
        super.updateById(message);
        fileService.mergeMsFile(message.getId(), param.getFileList());

        // 如果没有审核人,设置用户读取消息的情况
        if (StringUtils.isEmpty(param.getAudit())) readService.saveList(message.getId());

        // activiti 流程处理
        Task task = taskservice.createTaskQuery().processInstanceId(message.getPiId()).singleResult();
        Map<String, Object> variables = new HashMap<String, Object>(){
            {
                put("isAudit", StringUtils.isNotEmpty(param.getAudit()));
                put("auditUserId", param.getAudit());
            }
        };
        taskservice.complete(task.getId(), variables);

        return true;
    }
}
