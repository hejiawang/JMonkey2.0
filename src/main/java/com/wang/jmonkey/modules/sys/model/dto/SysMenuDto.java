package com.wang.jmonkey.modules.sys.model.dto;

import com.wang.jmonkey.modules.sys.model.entity.SysMenu;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SysMenuDto extends SysMenu {

    /**
     * 上级资源id
     */
    private String parentId;
}
