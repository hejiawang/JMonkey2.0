package com.wang.jmonkey.modules.sys.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.modules.sys.model.dto.SysMenuTreeDto;
import com.wang.jmonkey.modules.sys.model.entity.SysMenu;
import com.wang.jmonkey.modules.sys.model.param.SysMenuParam;
import com.wang.jmonkey.modules.sys.service.ISysMenuService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @Description: 菜单权限表 api
 * @Auther: HeJiawang
 * @Date: 2018-12-11
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuApi extends BaseHttp {

    @Resource
    private ISysMenuService service;

    /**
     * 菜单树表格
     * @param rId 归属系统的资源id
     * @return
     */
    @GetMapping(value = "/treeList")
    public HttpResult<List<SysMenuTreeDto>> list(String rId) {
        return new HttpResult<>( service.treeList(rId) );
    }

    /**
     * 保存实体信息
     * @param param 实体信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysMenuParam param ){
        return new HttpResult<>(service.insert(param));
    }

    /**
     * 修改实体信息
     * @param entity 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysMenu entity ){
        return new HttpResult<>(service.updateById(entity));
    }

    /**
     * 删除实体信息
     * @param id 实体ID
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public HttpResult<Boolean> delete( @PathVariable Serializable id ){
        return new HttpResult<>(service.deleteById(id));
    }

    /**
     * 查找实体信息
     * @param id 实体ID
     * @return
     */
    @GetMapping(value = "/find/{id}")
    public HttpResult<SysMenu> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectById(id));
    }

}