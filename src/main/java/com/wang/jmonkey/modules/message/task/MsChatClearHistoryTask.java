package com.wang.jmonkey.modules.message.task;

import com.wang.jmonkey.common.quartz.JMonkeyBaseTask;
import com.xiaoleilu.hutool.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
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
     * 任务执行
     */
    @Override
    public void run() {
        String clearDate = DateUtil.offsetDay(new Date(), clear).toString("yyyy-MM-dd");
        log.debug(clearDate);
        log.debug(String.valueOf(backups));
    }
}
