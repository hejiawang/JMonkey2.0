package com.wang.jmonkey.common.amqp.Listener;

import com.wang.jmonkey.common.constant.MqQueueConstant;
import com.wang.jmonkey.modules.sys.model.entity.SysLog;
import com.wang.jmonkey.modules.sys.service.ISysLogService;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 接收操作日志
 * @Auther: HeJiawang
 * @Date: 2018/9/7
 */
@Component
@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogReceiveListener {

    /**
     * KEY_USER
     */
    private static final String KEY_USER = "jmonkey_log_user";

    /**
     * 日志接口
     */
    @Resource
    private ISysLogService sysLogService;

    /**
     * 存储操作日志
     * @param log 日志信息
     */
    @RabbitHandler
    public void receive(SysLog log) {
        MDC.put(KEY_USER, log.getUserName());
        sysLogService.insert(log);
        MDC.remove(KEY_USER);
    }
}
