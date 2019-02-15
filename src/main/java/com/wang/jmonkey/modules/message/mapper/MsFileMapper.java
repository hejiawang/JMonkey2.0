package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.entity.MsFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 消息附件 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-31
 */
public interface MsFileMapper extends BaseMapper<MsFile> {

    /**
     * 物理删除消息的附件
     * @param messageId 消息id
     * @return 删除个数
     */
    int deleteByMsId(@Param("messageId") Serializable messageId);
}
