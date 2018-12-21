package com.wang.jmonkey.modules.sys.model.param;

import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * 用户信息 param
 * @Auther: HeJiawang
 * @Date: 2018/12/21
 */
@Data
@Accessors(chain = true)
public class SysUserParam extends SysUser {

    /**
     * 部门id集合
     * 用于新增修改用户信息使用
     */
    private List<String> deptIds;

    /**
     * 角色id集合
     * 用于新增修改用户信息使用
     */
    private List<String> roleIds;

    /**
     * 部门id
     * 根据部门id搜索用户信息使用
     */
    private String deptId;

    /**
     * 角色id
     * 根据角色id搜索用户信息使用
     */
    private String roleId;

    /**
     * 分页条件 分页条数
     */
    private Integer size;

    /**
     * 分页条件 当前页数
     */
    private Integer current;

    /**
     * 分页条件 mysql limit 起始值
     */
    private Integer limitStart;

    /**
     * 获取分页开始位置
     */
    public void setLimitStart() {
        this.limitStart = this.size * ( this.current - 1 );
    }

    /**
     * 将param信息转换为entity信息
     * @return
     */
    public SysUser converToEntity(){
        SysUser user = new SysUser();
        BeanUtils.copyProperties(this, user);

        return user;
    }
}
