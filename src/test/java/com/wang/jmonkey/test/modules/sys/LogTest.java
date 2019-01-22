package com.wang.jmonkey.test.modules.sys;

import com.wang.jmonkey.JmonkeyApplication;
import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import com.wang.jmonkey.modules.sys.service.ISysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JmonkeyApplication.class)
public class LogTest {

    /**
     * service
     */
    @Resource
    private ISysLogService service;

    @Test
    public void saveTest() {
        SysLog log = new SysLog().setParam("sdfsdf");
        service.insert(log);
    }
}
