package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.mapper.MsMessageMapper;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.service.IMsFileService;
import com.wang.jmonkey.modules.message.service.IMsMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wang.jmonkey.modules.message.service.IMsReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * <p>
 * 消息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-29
 */
@Service
public class MsMessageServiceImpl extends ServiceImpl<MsMessageMapper, MsMessage> implements IMsMessageService {

    /**
     * file service
     */
    @Autowired
    private IMsFileService fileService;

    /**
     * read service
     */
    @Autowired
    private IMsReadService readService;

    /**
     * 发布消息
     * @param param 消息对象
     * @return Boolean
     */
    @Transactional
    @Override
    public Boolean save(MsMessageParam param) {
        MsMessage message = param.converToEntity();

        return super.insert(message)
                && fileService.saveList(message.getId(), param.getFileList())
                && readService.saveList(message.getId());
    }

    /**
     * 删除消息
     * @param id 消息id
     * @return boolean
     */
    @Transactional
    @Override
    public boolean deleteById(Serializable id) {
        return super.deleteById(id) && fileService.deleteByMsId(id) && readService.deleteByMsId(id);
    }
}
