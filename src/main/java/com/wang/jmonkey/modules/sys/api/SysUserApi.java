package com.wang.jmonkey.modules.sys.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpPageResult;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.common.utils.FileUtil;
import com.wang.jmonkey.modules.sys.model.dto.SysUserDto;
import com.wang.jmonkey.modules.sys.model.entity.SysUser;
import com.wang.jmonkey.modules.sys.model.param.SysUserParam;
import com.wang.jmonkey.modules.sys.service.ISysUserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * @Description: 用户表 api
 * @Auther: HeJiawang
 * @Date: 2018-12-07
 */
@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserApi extends BaseHttp {

    @Resource
    private ISysUserService service;

    @Value("${jmonkey.user.photo}")
    private String userPhotoPath;

    /**
     * 分页查询信息
     * @param page page
     * @param userParam 实体信息
     * @return
     */
    @GetMapping(value = "/list")
    public HttpPageResult<SysUserDto> list(Page<SysUserDto> page, SysUserParam userParam) {
        return new HttpPageResult<>( service.selectPage( page, userParam ) );
    }

    /**
     * 保存实体信息
     * @param userParam 实体信息
     * @return
     */
    @PostMapping(value = "/save")
    public HttpResult<Boolean> save( @RequestBody SysUserParam userParam ){
        return new HttpResult<>(service.save(userParam));
    }

    /**
     * 修改实体信息
     * @param userParam 实体信息
     * @return
     */
    @PutMapping(value = "/modify")
    public HttpResult<Boolean> modify( @RequestBody SysUserParam userParam ){
        return new HttpResult<>(service.modify(userParam));
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
    @GetMapping(value = "/findDto/{id}")
    public HttpResult<SysUserDto> findById(@PathVariable Serializable id ){
        return new HttpResult<>(service.selectDtoById(id));
    }

    /**
     * 校验用户登录名是否重复
     * @param sysUser 用户登录名信息
     * @return
     */
    @PostMapping(value = "/checkUsername")
    public HttpResult<Boolean> checkUsername( @RequestBody SysUser sysUser){
        return new HttpResult<>(service.checkUsername(sysUser));
    }

    /**
     * 上传用户头像
     * @param uploadFile 头像文件
     * @return 用户头像访问路径
     */
    @PostMapping("/uploadPhoto")
    public HttpResult<String> uploadPhoto( @RequestParam(value = "file") MultipartFile uploadFile ){
        HttpResult<String> result = new HttpResult<>();

        try {
            String filePath = userPhotoPath + FileUtil.renderFileName(uploadFile.getOriginalFilename());
            InputStream is = uploadFile.getInputStream();

            if( FileUtil.uploadFile(filePath, is) ) result.setResult(filePath);
            else result.setIsSuccess(false);
        } catch (IOException e) {
            log.error("uploadPhoto error : ", e);
            result.setIsSuccess(false);
        }

        return result;
    }

}