package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.entity.SysButton;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.sys.model.param.SysButtonParam;

/**
 * <p>
 * 按钮权限表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
public interface ISysButtonService extends IService<SysButton> {

    /**
     * 新增按钮
     * @param param 按钮信息
     * @return
     */
    boolean insert(SysButtonParam param);

}
