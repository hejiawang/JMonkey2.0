package com.wang.jmonkey.modules.ieg.service.impl;

import com.wang.jmonkey.modules.ieg.model.entity.IegEnrollInfo;
import com.wang.jmonkey.modules.ieg.mapper.IegEnrollInfoMapper;
import com.wang.jmonkey.modules.ieg.model.param.IegEnrollInfoParam;
import com.wang.jmonkey.modules.ieg.service.IIegEnrollInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报考指南——招生录取投档线信息 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-04
 */
@Service
public class IegEnrollInfoServiceImpl extends ServiceImpl<IegEnrollInfoMapper, IegEnrollInfo> implements IIegEnrollInfoService {

    /**
     * 导入投档分数线信息
     * @param param param
     * @return Boolean
     */
    @Override
    public Boolean importInfo(IegEnrollInfoParam param) {

        // TODO
        
        return true;
    }
}
