package com.wang.jmonkey.modules.sys.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.wang.jmonkey.modules.sys.service.ISysUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户表 api
 * @Auther: HeJiawang
 * @Date: 2018-12-07
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserApi extends BaseHttp {

    @Resource
    private ISysUserService service;

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<SysUser> list(Page<SysUser> page, SysUser entity) {
        log.info("user list request");
        EntityWrapper wrapper = new EntityWrapper<SysUser>();
        return new HttpPageResult<>( service.selectPage( page, wrapper ) );
    }

    /**
     * 保存实体信息
     * @param entity 实体信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysUser entity ){
        return new HttpResult<>(service.insert(entity));
    }

    /**
     * 修改实体信息
     * @param entity 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysUser entity ){
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
    public HttpResult<SysUser> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectById(id));
    }

}