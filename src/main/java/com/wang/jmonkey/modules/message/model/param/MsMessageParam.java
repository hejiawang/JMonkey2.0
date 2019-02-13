package com.wang.jmonkey.modules.message.model.param;

import com.wang.jmonkey.modules.message.model.entity.MsFile;
import com.wang.jmonkey.modules.message.model.entity.MsMessage;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @Description: 发布消息的参数
 * @Auther: HeJiawang
 * @Date: 2019/1/31
 */
@Data
@Accessors(chain = true)
public class MsMessageParam extends MsMessage {

    /**
     * 附件
     */
    private List<MsFile> fileList;

    /**
     * 审核人员id
     */
    private String audit;

    /**
     * 发布人id
     */
    private String publishUserId;

    public MsMessage converToEntity () {
        MsMessage msMessage = new MsMessage();
        BeanUtils.copyProperties(this, msMessage);

        return msMessage;
    }
}
