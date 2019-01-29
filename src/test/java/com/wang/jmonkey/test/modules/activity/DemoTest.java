package com.wang.jmonkey.test.modules.activity;

import com.wang.jmonkey.JmonkeyApplication;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
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
    TaskService taskservice;

    @Test
    public void saveTest() {
        List<ProcessDefinition> list=repositoryService.createProcessDefinitionQuery().list();
        for(int i=0;i<list.size();i++) {

            System.out.println(list.get(i).getDeploymentId());
            System.out.println(list.get(i).getId());
            System.out.println(list.get(i).getKey());
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getResourceName());
            System.out.println(list.get(i).getDiagramResourceName());
        }

        /*identityservice.setAuthenticatedUserId("user_test_id_1");
        ProcessInstance instance=runtimeservice.startProcessInstanceByKey("test_1", "test_1_1");
        System.out.println(instance.getId()); // 2501 */

        //taskservice.complete("2501");


    }
}
