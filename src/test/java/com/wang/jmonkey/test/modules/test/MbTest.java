package com.wang.jmonkey.test.modules.test;

import com.wang.jmonkey.JmonkeyApplication;
import com.wang.jmonkey.modules.test.model.entity.TestMb;
import com.wang.jmonkey.modules.test.service.ITestMbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JmonkeyApplication.class)
public class MbTest {

    @Resource
    private ITestMbService service;

    @Test
    public void saveTest() {
        TestMb mb = new TestMb().setPassword("123").setUsername("usernam");
        service.insert(mb);
    }

    @Test
    public void deleteTest(){
        TestMb mb = service.selectById("dd44edee2c1c4f4f81fd35ab9357327a").setUsername("update");
        service.updateById(mb);
        service.deleteById("dd44edee2c1c4f4f81fd35ab9357327a");
    }
}
