package com.ray.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class FileUtil
{
    private static Logger log = LoggerFactory.getLogger(FileUtil.class);


    /**
     * 保存图片到服务器
     *
     * @author qqjbest
     * @since 2016年6月29日 下午5:17:05
     * @param content
     * @param request
     * @return
     */
    public static String savePicToServer(MultipartFile content, HttpServletRequest request, String partPath, String fileName)
    {
        String retPath = null;
        if (!content.isEmpty()) {
            try {
                // 文件保存路径
                String filePath = "/opt/apache/img/";
                log.info("filePath"+filePath);
                File tempFile = new File(filePath);
                if(!tempFile.exists())
                {
                    tempFile.mkdirs();
                }
                filePath = filePath + fileName;
                tempFile = new File(filePath);
                content.transferTo(tempFile);
                retPath = fileName;
                //赋予文件读写权限
                Runtime.getRuntime().exec("chmod -R 755 " + filePath);
            } catch (Exception e) {
                log.error("保存图片到服务器异常", e);
            }
        }
        return retPath;
    }

    public static void main(String[] args)
    {
    }
}
