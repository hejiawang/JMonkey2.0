package com.wang.jmonkey.modules.sys.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import com.wang.jmonkey.modules.sys.service.ISysLogService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 操作日志 api
 * @Auther: HeJiawang
 * @Date: 2019-01-22
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogApi extends BaseHttp {

    @Resource
    private ISysLogService service;

    /**
     * 分页查询信息
     * @param page page
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<SysLog> list(Page<SysLog> page) {
        return new HttpPageResult<>( service.selectPage( page) );
    }

    /**
     * 删除实体信息
     * @return
     */
    @DeleteMapping(value = "/deleteAll")
    public HttpResult<Boolean> deleteAll( ){
        return new HttpResult<>(service.deleteAll());
    }

}