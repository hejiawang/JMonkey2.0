package com.wang.jmonkey.modules.ieg.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.modules.ieg.model.entity.IegGrade;
import com.wang.jmonkey.modules.ieg.mapper.IegGradeMapper;
import com.wang.jmonkey.modules.ieg.model.param.IegGradeParam;
import com.wang.jmonkey.modules.ieg.service.IIegGradeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * <p>
 * 报考指南——一分一段表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2019-04-02
 */
@Service
public class IegGradeServiceImpl extends ServiceImpl<IegGradeMapper, IegGrade> implements IIegGradeService {

    /**
     * mappere
     */
    @Autowired
    private IegGradeMapper mapper;

    /**
     * 基础路径
     */
    @Value("${jmonkey.static-locations-file}")
    private String staticLocation;

    /**
     * 分页查询信息
     * @param page page
     * @param entity 实体信息
     * @return
     */
    @Override
    public Page<IegGrade> list(Page<IegGrade> page, IegGrade entity) {
        EntityWrapper<IegGrade> wrapper = new EntityWrapper<>();
        wrapper.setEntity(entity);
        wrapper.orderBy("score", false);

        return super.selectPage(page, wrapper);
    }

    /**
     * 批量导入
     * @param param param
     * @return Boolean
     */
    @Override
    public Boolean importGrade(IegGradeParam param) {
        // File file = new File(this.staticLocation + param.getFilePath());


        return true;
    }

    /**
     * 批量删除
     * @param entity 删除条件
     * @return true
     */
    @Override
    public Boolean delByYearAndType(IegGrade entity) {
        return mapper.delByYearAndType(entity) >= 0;
    }
}
