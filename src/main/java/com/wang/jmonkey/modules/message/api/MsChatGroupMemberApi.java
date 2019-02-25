package com.wang.jmonkey.modules.message.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.message.model.entity.MsChatGroupMember;
import com.wang.jmonkey.modules.message.service.IMsChatGroupMemberService;

import com.wang.jmonkey.modules.sys.model.dto.SysDeptUserDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 消息聊天群组信息 api
 * @Auther: HeJiawang
 * @Date: 2019-02-23
 */
@RestController
@RequestMapping("/ms/chat/group/member")
public class MsChatGroupMemberApi extends BaseHttp {

    @Resource
    private IMsChatGroupMemberService service;

    /**
     * 退出群组
     * @param groupMember 群组成员信息
     * @return Boolean
     */
    @GetMapping(value = "/out")
    public HttpResult<Boolean> outGroup(MsChatGroupMember groupMember){
        return new HttpResult<>(service.outGroup(groupMember));
    }

    /**
     * 群组成员信息
     * @param groupId 群组id
     * @return SysDeptUserDto
     */
    @GetMapping(value = "/deptUserList/{groupId}")
    public HttpResult<List<SysDeptUserDto>> deptUserList(@PathVariable String groupId){
        return new HttpResult<>(service.deptUserList(groupId));
    }

}