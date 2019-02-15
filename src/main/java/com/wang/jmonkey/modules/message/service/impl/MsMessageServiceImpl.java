package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.mapper.MsMessageMapper;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
import com.wang.jmonkey.modules.message.service.IMsFileService;
import com.wang.jmonkey.modules.message.service.IMsMessageActivitiService;
import com.wang.jmonkey.modules.message.service.IMsMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.message.service.IMsReadService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

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
     * activitiService
     */
    @Autowired
    private IMsMessageActivitiService activitiService;

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
        ProcessInstance ins = activitiService.startPublish(param.getPublishUserId(), message.getId(), param.getAudit());
        return super.updateById(message.setPiId(ins.getId()));
    }

    /**
     * 获取消息dto信息
     * @param id 消息id
     * @return dto
     */
    @Override
    public MsMessageDto selectDtoById(Serializable id) {
        return activitiService.buildAudit(
                mapper.selectDtoById(id)
        );
    }

    /**
     * 删除消息
     * @param id 消息id
     * @return boolean
     */
    @Transactional
    @Override
    public boolean deleteById(Serializable id) {
        String piId = super.selectById(id).getPiId();

        return activitiService.deleteProcess(piId)
                &&super.deleteById(id)
                && fileService.deleteByMsId(id)
                && readService.deleteByMsId(id);
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
            activitiService.buildAuditState(mapper.selectListPage(param))
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

        page.setRecords(  mapper.selectReadListPage(param) ).setTotal(process.count());
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
        HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery()
                .processDefinitionKey("messagePublish").variableValueEquals("auditUserId", param.getUserId())
                .orderByProcessInstanceEndTime().desc();
        List<HistoricProcessInstance> processList = process.listPage(param.getLimitStart(), param.getSize());
        processList.forEach(history -> param.getMsIdList().add(history.getBusinessKey()) );

        page.setRecords(
            activitiService.buildAuditState(mapper.selectAuditListPage(param))
        ).setTotal(
            process.count()
        );
        return page;
    }

    /**
     * 审核消息
     * @param state 审核是否通过
     * @param taskId 任务id
     */
    @Override
    public Boolean audit(boolean state, String taskId, String messageId) {
        if (state) readService.saveList(messageId);

        return activitiService.audit(taskId, state);
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

        return activitiService.modifyMessage(message.getPiId(), param.getAudit());
    }
}
