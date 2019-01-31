package com.wang.jmonkey.modules.message.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.common.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description: 资源 api
 * @Auther: HeJiawang
 * @Date: 2019-01-29
 */
@Slf4j
@RestController
@RequestMapping("/ms/assets")
public class MsAssetsApi extends BaseHttp {

    /**
     * 消息中图片存储位置
     */
    @Value("${jmonkey.message.image}")
    private String image;

    /**
     * 消息中附件存储位置
     */
    @Value("${jmonkey.message.file}")
    private String file;

    /**
     * 上传消息中的图片
     * @param uploadFile uploadFile
     * @return Boolean
     */
    @PostMapping("/image")
    public HttpResult<String> image(@RequestParam(value = "file") MultipartFile uploadFile ){
        HttpResult<String> result = new HttpResult<>();

        try {
            String filePath = image + FileUtil.renderFileName(uploadFile.getOriginalFilename());

            if( FileUtil.uploadFile(filePath, uploadFile.getInputStream()) ) result.setResult(filePath);
            else result.setIsSuccess(false);
        } catch (IOException e) {
            log.error("upload message image error : ", e);
            result.setIsSuccess(false);
        }

        return result;
    }

    /**
     * 上传消息中的附件
     * @param uploadFile uploadFile
     * @return Boolean
     */
    @PostMapping("/file")
    public HttpResult<String> file(@RequestParam(value = "file") MultipartFile uploadFile ){
        HttpResult<String> result = new HttpResult<>();

        try {
            String filePath = file + FileUtil.renderFileName(uploadFile.getOriginalFilename());

            if( FileUtil.uploadFile(filePath, uploadFile.getInputStream()) ) result.setResult(filePath);
            else result.setIsSuccess(false);
        } catch (IOException e) {
            log.error("upload message file error : ", e);
            result.setIsSuccess(false);
        }

        return result;
    }
}
