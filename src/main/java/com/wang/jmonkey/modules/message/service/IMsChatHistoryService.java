package com.wang.jmonkey.modules.message.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.message.model.dto.MsChatImHistoryDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.message.model.param.MsChatImHistoryParam;

/**
 * <p>
 * 消息聊天记录 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface IMsChatHistoryService extends IService<MsChatHistory> {

    /**
     * 获取聊天记录
     * @param page 分页信息
     * @param param 条件
     * @return MsChatImHistoryDto
     */
    Page<MsChatImHistoryDto> list(Page<MsChatImHistoryDto> page, MsChatImHistoryParam param);

    /**
     * 清空clearDate时间以前的聊天记录
     * @param clearDate 时间
     * @return int
     */
    int clearOldByDate(String clearDate);
}
