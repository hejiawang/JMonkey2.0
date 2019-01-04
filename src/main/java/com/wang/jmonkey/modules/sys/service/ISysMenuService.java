package com.wang.jmonkey.modules.sys.service;

import com.wang.jmonkey.modules.sys.model.dto.SysMenuDto;
import com.wang.jmonkey.modules.sys.model.dto.SysMenuTreeDto;
import com.wang.jmonkey.modules.sys.model.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;
import com.wang.jmonkey.modules.sys.model.param.SysMenuParam;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-11
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 构建菜单的树形结构
     * @param pId 上级资源id
     * @return
     */
    List<SysMenuTreeDto> treeList(String pId);

    /**
     * 增加菜单信息，并增加菜单资源
     * @param param
     * @return
     */
    boolean insert(SysMenuParam param);

    /**
     * 修改菜单信息
     * @param param 菜单信息
     * @return
     */
    boolean updateById(SysMenuParam param);

    /**
     * 获取菜单信息
     * @param id 菜单信息id
     * @return
     */
    SysMenuDto selectDtoById(Serializable id);
}
