package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.entity.MsChatRead;
import com.wang.jmonkey.modules.message.mapper.MsChatReadMapper;
import com.wang.jmonkey.modules.message.service.IMsChatReadService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息聊天记录读取情况 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-03-06
 */
@Service
public class MsChatReadServiceImpl extends ServiceImpl<MsChatReadMapper, MsChatRead> implements IMsChatReadService {

    /**
     * mapper
     */
    @Autowired
    private MsChatReadMapper mapper;

    /**
     * 保存消息未读情况
     * @param read read
     * @return boolean
     */
    @Override
    public boolean save(MsChatRead read) {
        mapper.deleteByRead(read);

        return super.insert(read);
    }
}
