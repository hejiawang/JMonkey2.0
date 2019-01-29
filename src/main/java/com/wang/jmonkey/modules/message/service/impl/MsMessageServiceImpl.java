package com.wang.jmonkey.modules.message.service.impl;

import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import com.wang.jmonkey.modules.message.mapper.MsMessageMapper;
import com.wang.jmonkey.modules.message.service.IMsMessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
