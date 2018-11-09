package com.wang.jmonkey.modules.test.service.impl;

import com.wang.jmonkey.modules.test.model.entity.TestMb;
import com.wang.jmonkey.modules.test.mapper.TestMbMapper;
import com.wang.jmonkey.modules.test.service.ITestMbService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * mybatis 测试 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-11-09
 */
@Service
public class TestMbServiceImpl extends ServiceImpl<TestMbMapper, TestMb> implements ITestMbService {

}
