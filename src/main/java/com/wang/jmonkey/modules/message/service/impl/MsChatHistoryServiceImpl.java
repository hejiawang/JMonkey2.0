package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.message.model.dto.MsChatImHistoryDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.wang.jmonkey.modules.message.mapper.MsChatHistoryMapper;
import com.wang.jmonkey.modules.message.model.enums.MsChatHistoryTypeEnums;
import com.wang.jmonkey.modules.message.model.param.MsChatImHistoryParam;
import com.wang.jmonkey.modules.message.service.IMsChatHistoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息聊天记录 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
@Service
public class MsChatHistoryServiceImpl extends ServiceImpl<MsChatHistoryMapper, MsChatHistory> implements IMsChatHistoryService {

    /**
     * mapper
     */
    @Autowired
    private MsChatHistoryMapper mapper;

    /**
     * 获取聊天记录
     * @param page 分页信息
     * @param param 条件
     * @return MsChatImHistoryDto
     */
    @Override
    public Page<MsChatImHistoryDto> list(Page<MsChatImHistoryDto> page, MsChatImHistoryParam param) {
        param.setLimitStart();

        if (param.getType() == MsChatHistoryTypeEnums.Single) return this.listSingle(page, param);
        else return this.listGroup(page, param);
    }

    /**
     * 获取私聊聊天记录
     * @param page 分页信息
     * @param param 条件
     * @return MsChatImHistoryDto
     */
    private Page<MsChatImHistoryDto> listSingle(Page<MsChatImHistoryDto> page, MsChatImHistoryParam param) {
        page.setRecords( mapper.listSingle(param) )
                .setTotal( mapper.listSingleTotal(param) );
        return page;
    }

    /**
     * 获取群组聊天记录
     * @param page 分页信息
     * @param param 条件
     * @return MsChatImHistoryDto
     */
    private Page<MsChatImHistoryDto> listGroup(Page<MsChatImHistoryDto> page, MsChatImHistoryParam param) {
        page.setRecords( mapper.listGroup(param) )
                .setTotal( mapper.listGroupTotal(param) );
        return page;
    }
}
