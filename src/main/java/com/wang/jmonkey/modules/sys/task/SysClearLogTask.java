package com.wang.jmonkey.modules.sys.task;

import com.wang.jmonkey.common.quartz.JMonkeyBaseTask;
import com.wang.jmonkey.common.utils.SpringContextHolder;
import com.wang.jmonkey.modules.sys.service.ISysLogService;
import com.wang.jmonkey.modules.sys.service.impl.SysLogServiceImpl;

/**
 * @Description: 清空日志信息任务类
 * @Auther: HeJiawang
 * @Date: 2019-01-24
 */
public class SysClearLogTask extends JMonkeyBaseTask {

    /**
     * 任务执行
     */
    @Override
    public void run() {
        ISysLogService service = SpringContextHolder.getBean(SysLogServiceImpl.class);
        service.deleteAll();
    }
}
