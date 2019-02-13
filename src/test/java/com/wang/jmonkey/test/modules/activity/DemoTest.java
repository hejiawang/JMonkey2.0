package com.wang.jmonkey.test.modules.activity;

import com.wang.jmonkey.JmonkeyApplication;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.service.IMsMessageService;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JmonkeyApplication.class)
public class DemoTest {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    IdentityService identityservice;

    @Autowired
    RuntimeService runtimeservice;


    @Autowired
    RuntimeService runservice;


    @Autowired
    TaskService taskservice;

    @Autowired
    IMsMessageService service;

    @Autowired
    HistoryService histiryservice;

    @Test
    public void saveTest() {
        List<Task> tasks = taskservice.createTaskQuery().taskAssignee("1").orderByDueDateNullsLast().desc().list();
        for (Task task : tasks) {
            String instanceid=task.getProcessInstanceId();
            ProcessInstance ins=runtimeservice.createProcessInstanceQuery().processInstanceId(instanceid).singleResult();
            String businesskey=ins.getBusinessKey();
            MsMessage msMessage = service.selectById(businesskey);
            System.out.println(msMessage.getTitle());
            System.out.println(task.getName());
        }
    }

    @Test
    public void saveTest2 () {
        List<ProcessInstance> a = runservice.createProcessInstanceQuery().processDefinitionKey("messagePublish").involvedUser("1").list();

        for(ProcessInstance p : a){
            System.out.println(p.getActivityId());
            System.out.println(p.getBusinessKey());
            System.out.println(p.getId());
        }
    }

    @Test
    public void saveTest3 () {

        /*HistoricProcessInstanceQuery process = histiryservice.createHistoricProcessInstanceQuery().processDefinitionKey("messagePublish").startedBy("1");
        List<HistoricProcessInstance> info = process.list();
        for(HistoricProcessInstance history : info){

            String bussinesskey=history.getBusinessKey();
            MsMessage msMessage = service.selectById(bussinesskey);
            System.out.println(msMessage.getTitle());
        }*/

        List<HistoricVariableInstance> eq = histiryservice.createHistoricVariableInstanceQuery()
                .variableValueEquals("auditUserId", "36f8103bf41c4098b72d28734c5fb2ed").list();
        for(HistoricVariableInstance history : eq){
            String instanceid = history.getProcessInstanceId();
            ProcessInstance ins=runtimeservice.createProcessInstanceQuery().processInstanceId(instanceid).singleResult();
            String businesskey=ins.getBusinessKey();
            MsMessage msMessage = service.selectById(businesskey);
            System.out.println(msMessage.getTitle());
        }
    }
}
