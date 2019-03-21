package com.wang.jmonkey.modules.sys.service.impl;

import com.wang.jmonkey.modules.sys.model.dto.SysRoleDataConverDto;
import com.wang.jmonkey.modules.sys.model.entity.SysRoleData;
import com.wang.jmonkey.modules.sys.mapper.SysRoleDataMapper;
import com.wang.jmonkey.modules.sys.service.ISysRoleDataService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色数据规则表 服务实现类
 * </p>
 *
 * @author heJiawang
 * @since 2019-03-20
 */
@Service
public class SysRoleDataServiceImpl extends ServiceImpl<SysRoleDataMapper, SysRoleData> implements ISysRoleDataService {

    /**
     * mapper
     */
    @Autowired
    private SysRoleDataMapper mapper;

    /**
     * 删除角色授权的数据规则信息
     * @param id 数据规则id
     * @return true
     */
    @Override
    public boolean deleteByScopeId(Serializable id) {
        return mapper.deleteByScopeId(id) >= 0;
    }

    /**
     * 删除角色已经授权的数据规则
     * @param roleId 角色id
     * @return true
     */
    private boolean deleteByRoleId(String roleId) {
        return mapper.deleteByRoleId(roleId) >= 0;
    }

    /**
     * 为角色授权数据规则
     * @param roleId roleId
     * @param ruleIds ruleIds
     * @return Boolean
     */
    @Override
    public boolean auth(String roleId, List<String> ruleIds) {
        Boolean result = this.deleteByRoleId(roleId);

        ruleIds.forEach( ruleId -> {
            SysRoleData roleData = new SysRoleData().setRoleId(roleId).setRuleId(ruleId);
            super.insert(roleData);
        });

        return result;
    }

    /**
     * 获取角色授权的数据规则
     * @param roleId 角色id
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> findByRole(String roleId) {
        Map<String, String> result = CollectionUtil.newHashMap();

        List<SysRoleDataConverDto> dtoList = mapper.findByRole(roleId);
        dtoList.forEach( dto -> result.put(dto.getScopeId(), dto.getRuleId()) );

        return result;
    }
}
