package com.wang.jmonkey.modules.message.mapper;

import com.wang.jmonkey.modules.message.model.dto.MsChatImHistoryDto;
import com.wang.jmonkey.modules.message.model.entity.MsChatHistory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.message.model.param.MsChatImHistoryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 消息聊天记录 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2019-02-23
 */
public interface MsChatHistoryMapper extends BaseMapper<MsChatHistory> {

    /**
     * 获取群组聊天记录
     * @param param
     * @return
     */
    List<MsChatImHistoryDto> listGroup(MsChatImHistoryParam param);

    /**
     * 获取群组聊天记录总条数
     * @param param
     * @return
     */
    long listGroupTotal(MsChatImHistoryParam param);

    /**
     * 获取私聊聊天记录
     * @param param
     * @return
     */
    List<MsChatImHistoryDto> listSingle(MsChatImHistoryParam param);

    /**
     * 获取私聊聊天记录总条数
     * @param param
     * @return
     */
    long listSingleTotal(MsChatImHistoryParam param);

    /**
     * 清空clearDate时间以前的聊天记录
     * @param clearDate 时间
     * @return int
     */
    int clearOldByDate(@Param("clearDate") String clearDate);
}
