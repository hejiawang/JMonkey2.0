package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.dto.SysMenuTreeDto;
import com.wang.jmonkey.modules.sys.model.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取所有菜单dto信息
     * @return 菜单dto信息
     */
    List<SysMenuTreeDto> selectDtoList();
}