package com.wang.jmonkey.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: 文件工具类
 * @Auther: HeJiawang
 * @Date: 2018/12/28
 */
@Slf4j
@Component
public class FileUtil {

    @Component
    static class FileBuilder {
        /**
         * 文件保存基础路径
         */
        public static String staticLocationsFile;

        /**
         * 重命名文件分隔符
         */
        public static String FILE_NAME_SPLIT = "_";

        @Value("${jmonkey.static-locations-file}")
        public void setStaticLocationsFile( String staticLocationsFile ){
            this.staticLocationsFile = staticLocationsFile;
        }
    }

    /**
     * 生成上传文件的文件名
     * @param fileName 原始文件名
     * @return 新文件名
     */
    public static String renderFileName( String fileName ){
        return  UUIDUtil.value() + FileBuilder.FILE_NAME_SPLIT + fileName;
    }

    /**
     * 上传文件
     * @param filePath 上传文件路径
     * @param is 上传文件的输入流
     * @return
     */
    public static boolean uploadFile(String filePath, InputStream is) {
        boolean result;

        try {
            File targetFile = new File(FileBuilder.staticLocationsFile + filePath);
            FileUtils.copyInputStreamToFile(is, targetFile);

            result = true;
        } catch (IOException e) {
            log.error("uploadFile error : ", e);
            result = false;
        }

        return result;
    }
}
