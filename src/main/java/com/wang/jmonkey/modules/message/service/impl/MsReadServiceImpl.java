package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.common.model.enums.YesOrNoEnum;
import com.wang.jmonkey.modules.message.model.entity.MsRead;
import com.wang.jmonkey.modules.message.mapper.MsReadMapper;
import com.wang.jmonkey.modules.message.service.IMsReadService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 消息阅读情况 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
@Service
public class MsReadServiceImpl extends ServiceImpl<MsReadMapper, MsRead> implements IMsReadService {

    /**
     * mapper
     */
    @Autowired
    private MsReadMapper mapper;

    /**
     * user service
     */
    @Autowired
    private ISysUserService userService;

    /**
     * 保存消息阅读情况
     * @param messageId messageId
     * @return boolean
     */
    @Override
    public boolean saveList(String messageId) {
        userService.selectAll().forEach(sysUser -> {
            MsRead read = new MsRead()
                    .setMessageId(messageId).setUserId(sysUser.getId()).setState(YesOrNoEnum.No);
            this.insert(read);
        });

        return true;
    }

    /**
     * 删除消息阅读情况
     * @param messageId 消息id
     * @return boolean
     */
    @Override
    public boolean deleteByMsId(Serializable messageId) {
        return mapper.deleteByMsId(messageId) >= 0;
    }

    /**
     * 统计用户未读消息个数
     * @param userId 用户id
     * @return 个数
     */
    @Override
    public Integer countNoRead(String userId) {
        EntityWrapper<MsRead> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new MsRead().setUserId(userId));
        return this.selectCount(wrapper);
    }

    /**
     * 设置消息为已读
     * 此处是将ms_read表中数据删除,好处是控制表中数据量，缺点是不能记录用户读取消息的时间,不能统计用户读过多少消息
     * @param messageId messageId
     * @param userId userId
     * @return Boolean
     */
    @Override
    public Boolean read(String messageId, String userId) {
        return mapper.read(messageId, userId) >= 0;
    }
}
