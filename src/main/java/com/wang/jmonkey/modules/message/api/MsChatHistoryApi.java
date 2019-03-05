package com.wang.jmonkey.modules.message.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.wang.jmonkey.modules.message.service.IMsChatHistoryService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 消息聊天记录 api
 * @Auther: HeJiawang
 * @Date: 2019-02-23
 */
@RestController
@RequestMapping("/ms/chat/history")
public class MsChatHistoryApi extends BaseHttp {

    @Resource
    private IMsChatHistoryService service;

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<MsChatHistory> list(Page<MsChatHistory> page, MsChatHistory entity) {
        EntityWrapper wrapper = new EntityWrapper<MsChatHistory>();

        return new HttpPageResult<>( service.selectPage( page, wrapper ) );
    }

}