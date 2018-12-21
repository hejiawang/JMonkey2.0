package com.wang.jmonkey.modules.sys.mapper;

import com.wang.jmonkey.modules.sys.model.dto.SysUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wang.jmonkey.modules.sys.model.param.SysUserParam;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-07
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户dto信息
     * @param id 用户id
     * @return
     */
    SysUserDto selectDtoById( @Param("id") Serializable id);

    /**
     * 获取用户分页信息
     * @param param
     * @return
     */
    List<SysUserDto> selectDtoPage(SysUserParam param);

    /**
     * 用户信息条数
     * @param param
     * @return
     */
    int selectTotal(SysUserParam param);
}
