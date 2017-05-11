package com.oureda.framework.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by webhugo on 17-5-10.
 */
public class FileUtil {


    public static void createFile(String filePath) throws IOException {
        String message;
        File file = new File(filePath);
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            FileUtils.forceMkdir(file.getParentFile());
        }
        //创建目标文件
        if (!file.createNewFile()) {
            message = "create file " + filePath + " fail";
            System.out.println(message);
            throw new IOException(message);
        }
    }


}
