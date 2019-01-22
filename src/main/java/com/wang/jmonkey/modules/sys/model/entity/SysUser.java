package com.wang.jmonkey.modules.sys.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.wang.jmonkey.common.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseEntity<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.UUID)
    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 真是姓名
     */
    private String realName;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 性别 Man男 Woman女 Other其他
     */
    private String sex;
    /**
     * 用户头像
     */
    private String photo;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
