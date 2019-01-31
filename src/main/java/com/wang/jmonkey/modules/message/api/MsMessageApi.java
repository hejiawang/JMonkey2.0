package com.wang.jmonkey.modules.message.api;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.common.model.vo.UserVo;
import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
import com.wang.jmonkey.modules.message.service.IMsMessageService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @Description: 消息 api
 * @Auther: HeJiawang
 * @Date: 2019-01-29
 */
@RestController
@RequestMapping("/ms/message")
public class MsMessageApi extends BaseHttp {

    @Resource
    private IMsMessageService service;

    /**
     * 分页查询信息
     * @param page page
     * @param param 实体信息
     * @return result
     */
    @GetMapping(value = "/list")
    public HttpPageResult<MsMessage> list(Page<MsMessage> page, MsMessageSearchParam param) {
        return new HttpPageResult<>( service.selectListPage( page, param ) );
    }

    /**
     * 获取消息查看列表
     * @param page page
     * @param param param
     * @param userVo userVo
     * @return result
     */
    @GetMapping(value = "/readList")
    public HttpPageResult<MsMessage> readList(Page<MsMessage> page, MsMessageSearchParam param, UserVo userVo) {
        return new HttpPageResult<>( service.selectReadPage( page, param.setUserId(userVo.getId()) ) );
    }

    /**
     * 保存实体信息
     * @param param 实体信息
     * @return Boolean
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody MsMessageParam param ){
        return new HttpResult<>(service.save(param));
    }

    /**
     * 修改实体信息
     * @param entity 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody MsMessage entity ){
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
    public HttpResult<MsMessageDto> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectDtoById(id));
    }

}