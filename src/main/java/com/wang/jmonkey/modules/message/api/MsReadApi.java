package com.wang.jmonkey.modules.message.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.common.model.vo.UserVo;
import com.wang.jmonkey.modules.message.service.IMsReadService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 消息阅读情况 api
 * @Auther: HeJiawang
 * @Date: 2019-01-29
 */
@RestController
@RequestMapping("/ms/read")
public class MsReadApi extends BaseHttp {

    @Resource
    private IMsReadService service;

    /**
     * 当前用户未读消息个数
     * @param userVo userVo
     * @return 未读消息个数
     */
    @GetMapping(value = "/count")
    public HttpResult<Integer> count(UserVo userVo) {
        return new HttpResult<>(service.countNoRead(userVo.getId()));
    }

    /**
     * 设置用户的消息为已读
     * @param messageId messageId
     * @param userVo userVo
     * @return boolean
     */
    @GetMapping(value = "/read")
    public HttpResult<Boolean> read(String messageId, UserVo userVo){
        return new HttpResult<>(service.read(messageId, userVo.getId()));
    }

}