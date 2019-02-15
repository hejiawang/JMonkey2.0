package com.wang.jmonkey.modules.message.service;

import com.wang.jmonkey.modules.message.model.entity.MsFile;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 消息附件 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-31
 */
public interface IMsFileService extends IService<MsFile> {

    /**
     * 保存消息附件信息
     * @param messageId messageId
     * @param fileList fileList
     * @return
     */
    boolean saveList(String messageId, List<MsFile> fileList);

    /**
     * 删除消息附件
     * @param messageId 消息id
     * @return boolean
     */
    boolean deleteByMsId(Serializable messageId);

    /**
     * 删除消息附件后保存消息附件信息
     * @param messageId messageId
     * @param fileList fileList
     * @return boolean
     */
    boolean mergeMsFile(String messageId, List<MsFile> fileList);
}
