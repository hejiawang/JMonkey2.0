package com.wang.jmonkey.modules.test.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.test.model.entity.TestMb;
import com.wang.jmonkey.modules.test.service.ITestMbService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: mybatis 测试 api
 * @Auther: HeJiawang
 * @Date: 2018-11-09
 */
@RestController
@RequestMapping("/testMb")
public class TestMbApi extends BaseHttp {

    @Resource
    private ITestMbService service;

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<TestMb> list(Page<TestMb> page, TestMb entity) {
        EntityWrapper wrapper = new EntityWrapper<TestMb>();

        return new HttpPageResult<>( service.selectPage( page, wrapper ) );
    }

    /**
     * 保存实体信息
     * @param entity 实体信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody TestMb entity ){
        return new HttpResult<>(service.insert(entity));
    }

    /**
     * 修改实体信息
     * @param entity 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody TestMb entity ){
        return new HttpResult<>(service.updateById(entity));
    }

    /**
     * 删除实体信息
     * @param id 实体ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(service.deleteById(id));
    }

    /**
     * 查找实体信息
     * @param id 实体ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<TestMb> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectById(id));
    }

}