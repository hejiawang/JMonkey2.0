package com.wang.jmonkey.modules.message.task;

import com.wang.jmonkey.common.quartz.JMonkeyBaseTask;
import com.wang.jmonkey.modules.message.service.IMsChatHistoryService;
import com.xiaoleilu.hutool.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @Description: 清空聊天记录, 并将清空的聊天记录保存到一个excel文件中
 * @Auther: HeJiawang
 * @Date: 2019-02-24
 */
@Slf4j
@Component
public class MsChatClearHistoryTask extends JMonkeyBaseTask {

    /**
     * 自动删除n天前的聊天记录
     */
    @Value("${jmonkey.message.chat.history.clear}")
    private int clear;

    /**
     * 删除的聊天记录是否保存到Excel文件中
     */
    @Value("${jmonkey.message.chat.history.backups}")
    private boolean backups;

    /**
     * IMsChatHistoryService
     */
    @Autowired
    private IMsChatHistoryService historyService;

    /**
     * 任务执行
     */
    @Override
    public void run() {
        // 计算需要清空聊天历史的日期
        String clearDate = DateUtil.offsetDay(new Date(), clear).toString("yyyy-MM-dd");

        // 1、如果需要备份历史聊天信息, 将历史聊天信息保存到Excel中
        if (backups) {
            // TODO
        }

        // 2、清空聊天记录
        historyService.clearOldByDate(clearDate);
    }
}
