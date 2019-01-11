package com.wang.jmonkey.modules.sys.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wang.jmonkey.common.model.enums.YesOrNoEnum;
import com.wang.jmonkey.modules.sys.model.entity.SysSystem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysSystemDto extends SysSystem {

    /**
     * 资源id
     */
    private String rId;

    /**
     * 对当前登陆用户是否授权
     */
    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingToString)
    private YesOrNoEnum isAuth = YesOrNoEnum.No;

    /**
     * 系统包含的菜单
     */
    private List<SysMenuDto> menuList;
}
