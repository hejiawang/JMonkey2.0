package com.wang.jmonkey.common.mybatis.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.wang.jmonkey.common.utils.UserUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.StringUtils;

/**
 * @Description: mybatis 自动填充字段
 * @Auther: HeJiawang
 * @Date: 2018/7/24
 */
public class DataMetaObjectHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createBy = getFieldValByName("createBy", metaObject);
        if ( StringUtils.isEmpty(createBy) ) setFieldValByName("createBy", UserUtils.getUser(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateBy = getFieldValByName("updateBy", metaObject);
        if ( StringUtils.isEmpty(updateBy) ) setFieldValByName("updateBy", UserUtils.getUser(), metaObject);
    }
}
