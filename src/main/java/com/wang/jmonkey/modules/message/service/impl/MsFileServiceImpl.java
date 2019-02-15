package com.wang.jmonkey.modules.message.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.modules.message.model.entity.MsFile;
import com.wang.jmonkey.modules.message.mapper.MsFileMapper;
import com.wang.jmonkey.modules.message.service.IMsFileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 消息附件 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-01-31
 */
@Service
public class MsFileServiceImpl extends ServiceImpl<MsFileMapper, MsFile> implements IMsFileService {

    /**
     * mapper
     */
    @Autowired
    private MsFileMapper mapper;

    /**
     * 保存消息附件信息
     * @param messageId messageId
     * @param fileList fileList
     * @return
     */
    @Override
    public boolean saveList(String messageId, List<MsFile> fileList) {
        if (CollectionUtil.isNotEmpty(fileList)) {
            fileList.forEach(msFile ->
                this.insert(msFile.setMessageId(messageId))
            );
        }

        return true;
    }

    /**
     * 删除消息附件
     * @param messageId 消息id
     * @return boolean
     */
    @Override
    public boolean deleteByMsId(Serializable messageId) {
        return mapper.deleteByMsId(messageId) >= 0;
    }

    /**
     * 删除消息附件后保存消息附件信息
     * @param messageId messageId
     * @param fileList fileList
     * @return boolean
     */
    @Override
    public boolean mergeMsFile(String messageId, List<MsFile> fileList) {
        return this.deleteByMsId(messageId) && this.saveList(messageId, fileList);
    }
}
