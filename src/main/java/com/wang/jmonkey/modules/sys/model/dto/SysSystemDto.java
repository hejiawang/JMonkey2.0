package com.wang.jmonkey.modules.sys.model.dto;

import com.wang.jmonkey.modules.sys.model.entity.SysSystem;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysSystemDto extends SysSystem {

    /**
     * 资源id
     */
    private String rId;

}
