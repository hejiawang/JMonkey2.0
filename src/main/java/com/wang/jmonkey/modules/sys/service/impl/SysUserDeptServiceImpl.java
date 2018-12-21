package com.wang.jmonkey.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.modules.sys.model.entity.SysUserDept;
import com.wang.jmonkey.modules.sys.mapper.SysUserDeptMapper;
import com.wang.jmonkey.modules.sys.service.ISysUserDeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaoleilu.hutool.collection.CollectionUtil;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户部门表 服务实现类
 * </p>
 *
 * @author HeJiawang
 * @since 2018-12-21
 */
@Service
public class SysUserDeptServiceImpl extends ServiceImpl<SysUserDeptMapper, SysUserDept> implements ISysUserDeptService {

    /**
     * 根据部门id，删除部门用户关联关系
     * @param deptId 部门id
     * @return
     */
    @Override
    public boolean deleteByDeptId(Serializable deptId) {
        EntityWrapper<SysUserDept> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysUserDept().setDeptId(String.valueOf(deptId)));
        return super.delete(wrapper);
    }

    /**
     * 根据用户id，删除部门用户关联关系
     * @param userId 用户id
     * @return
     */
    @Override
    public boolean deleteByUserId(Serializable userId) {
        EntityWrapper<SysUserDept> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new SysUserDept().setUserId(String.valueOf(userId)));
        return super.delete(wrapper);
    }

    /**
     * merge 用户部门关联关系信息
     * @param userId 用户id
     * @param deptIds 部门 id 集合
     * @return
     */
    @Override
    public boolean mergeDepts(String userId, List<String> deptIds) {
        this.deleteByUserId(userId);

        if(CollectionUtil.isNotEmpty(deptIds)){
            deptIds.forEach( deptId -> {
                SysUserDept userDept = new SysUserDept().setUserId(userId).setDeptId(deptId);
                super.insert(userDept);
            });
        }

        return true;
    }
}
