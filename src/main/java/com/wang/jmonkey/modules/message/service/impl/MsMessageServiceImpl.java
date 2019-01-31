package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.model.enums.YesOrNoEnum;
import com.wang.jmonkey.modules.message.model.dto.MsMessageDto;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.mapper.MsMessageMapper;
import com.wang.jmonkey.modules.message.model.param.MsMessageParam;
import com.wang.jmonkey.modules.message.model.param.MsMessageSearchParam;
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
     * mapper
     */
    @Autowired
    private MsMessageMapper mapper;

    /**
     * 发布消息
     * @param param 消息对象
     * @return Boolean
     */
    @Transactional
    @Override
    public Boolean save(MsMessageParam param) {
        MsMessage message = param.converToEntity();

        // TODO
        message.setState(YesOrNoEnum.Yes);

        return super.insert(message)
                && fileService.saveList(message.getId(), param.getFileList())
                && readService.saveList(message.getId());
    }

    /**
     * 获取小松dto信息
     * @param id 消息id
     * @return dto
     */
    @Override
    public MsMessageDto selectDtoById(Serializable id) {
        return mapper.selectDtoById(id);
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

    /**
     * 分页查询信息
     * @param page page
     * @param param param
     * @return List<MsMessage>
     */
    @Override
    public Page<MsMessage> selectListPage(Page<MsMessage> page, MsMessageSearchParam param) {
        param.setLimitStart();
        page.setRecords(mapper.selectListPage(param))
                .setTotal(mapper.selectTotal(param));
        return page;
    }

    /**
     * 获取消息查看列表
     * @param page page
     * @param param param
     * @return result
     */
    @Override
    public Page<MsMessage> selectReadPage(Page<MsMessage> page, MsMessageSearchParam param) {
        param.setLimitStart();
        page.setRecords(mapper.selectReadListPage(param))
                .setTotal(mapper.selectTotal(param));
        return page;
    }
}
