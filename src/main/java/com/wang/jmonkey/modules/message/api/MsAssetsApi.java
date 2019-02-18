package com.wang.jmonkey.modules.message.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.wang.jmonkey.common.utils.FileUtil;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
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

    @Value("${jmonkey.static-locations-path}")
    private String staticLocationsPath;

    /**
     * page office test
     * @return String
     */
    @GetMapping("/pageOfficeTest")
    public HttpResult<String> pageOfficeTest(){
        String path = staticLocationsPath + "pageOffice/pageOfficeTest.docx";

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setServerPage(request.getContextPath()+"/poserver.zz"); //此行必须
        poCtrl.setTitlebar(false); // 隐藏标题栏
        poCtrl.setMenubar(false); // 隐藏菜单栏
        poCtrl.setCustomToolbar(false); // 隐藏自定义工具栏
        poCtrl.setCaption("pageOfficeTest");
        poCtrl.webOpen(path, OpenModeType.docNormalEdit, "pageOfficeTest");
        return new HttpResult<>(poCtrl.getHtmlCode("PageOfficeCtrl1"));
    }

}
