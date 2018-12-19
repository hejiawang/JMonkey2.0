package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.dto.SysDictDto;
import com.wang.jmonkey.modules.sys.model.dto.SysDictTreeDto;
import com.wang.jmonkey.modules.sys.model.entity.SysDict;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 字典值 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-17
 */
public interface ISysDictService extends IService<SysDict> {

    /**
     * 获取树形表格数据
     * @return
     */
    List<SysDictTreeDto> tree();

    /**
     * 校验字典键值是否存在
     * @param sysDict
     * @return
     */
    Boolean checkValue(SysDict sysDict);

    /**
     * 获取字典dto信息
     * @param id 字典id
     * @return
     */
    SysDictDto selectDtoById(Serializable id);
}
