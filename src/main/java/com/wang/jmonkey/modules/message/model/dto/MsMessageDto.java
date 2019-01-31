package com.wang.jmonkey.modules.message.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.common.model.enums.YesOrNoEnum;
import com.wang.jmonkey.modules.message.model.entity.MsFile;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: 发布消息的DTO
 * @Auther: HeJiawang
 * @Date: 2019/1/31
 */
@Data
@Accessors(chain = true)
public class MsMessageDto extends MsMessage {

    /**
     * 附件
     */
    private List<MsFile> fileList;

    /**
     * 消息发布人的真实姓名
     */
    private String createName;

    /**
     * 消息的阅读状态
     */
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private YesOrNoEnum readState;
}
