package com.wang.jmonkey.modules.message.api;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import com.wang.jmonkey.common.http.result.HttpResult;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
     * 群组头像照片
     */
    @Value("${jmonkey.message.chat.group.image}")
    private String chatGroupImage;

    /**
     * 聊天文件
     */
    @Value("${jmonkey.message.chat.im.file}")
    private String chatImFile;

    /**
     * 上传消息中的图片
     * @param uploadFile uploadFile
     * @return Boolean
     */
    @PostMapping("/image")
    public HttpResult<String> image(@RequestParam(value = "file") MultipartFile uploadFile ){
        return super.uploadFile(uploadFile, image);
    }

    /**
     * 上传消息中的附件
     * @param uploadFile uploadFile
     * @return Boolean
     */
    @PostMapping("/file")
    public HttpResult<String> file(@RequestParam(value = "file") MultipartFile uploadFile ){
        return super.uploadFile(uploadFile, file);
    }

    /**
     * 上传群组头像照片
     * @param uploadFile uploadFile
     * @return String
     */
    @PostMapping("/chat/group/image")
    public HttpResult<String> chatGroupImage(@RequestParam(value = "file") MultipartFile uploadFile){
        return super.uploadFile(uploadFile, chatGroupImage);
    }

    /**
     * 聊天文件
     * @param uploadFile 文件
     * @return 文件路径
     */
    @PostMapping("/chat/im/file")
    public HttpResult<String> chatImFile(@RequestParam(value = "file") MultipartFile uploadFile){
        return super.uploadFile(uploadFile, chatImFile);
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
