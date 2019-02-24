package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.wang.jmonkey.modules.message.mapper.MsChatHistoryMapper;
import com.wang.jmonkey.modules.message.service.IMsChatHistoryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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

}
