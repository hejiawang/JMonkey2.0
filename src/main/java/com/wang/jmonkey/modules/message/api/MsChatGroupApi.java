package com.wang.jmonkey.modules.message.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.message.model.dto.MsChatGroupDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroup;
import com.wang.jmonkey.modules.message.model.param.MsChatGroupParam;
import com.wang.jmonkey.modules.message.service.IMsChatGroupService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 消息聊天群组信息 api
 * @Auther: HeJiawang
 * @Date: 2019-02-23
 */
@RestController
@RequestMapping("/ms/chat/group")
public class MsChatGroupApi extends BaseHttp {

    @Resource
    private IMsChatGroupService service;

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<MsChatGroup> list(Page<MsChatGroup> page, MsChatGroup entity) {
        EntityWrapper wrapper = new EntityWrapper<MsChatGroup>();

        return new HttpPageResult<>( service.selectPage( page, wrapper ) );
    }

    /**
     * 保存实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody MsChatGroupParam param ){
        return new HttpResult<>(service.save(param));
    }

    /**
     * 修改实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody MsChatGroupParam param ){
        return new HttpResult<>(service.modify(param));
    }

    /**
     * 删除实体信息
     * @param id 实体ID
     * @return Boolean
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
    public HttpResult<MsChatGroupDto> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectDtoById(id));
    }

}