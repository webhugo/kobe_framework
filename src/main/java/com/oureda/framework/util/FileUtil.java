package com.oureda.framework.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by webhugo on 17-5-10.
 */
public class FileUtil {

    /**
     * 获取真实文件名（自动去掉文件路径）
     */
    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }


    public static void createFile(String filePath) {
        String message;
        File file = new File(filePath);
        //判断目标文件所在的目录是否存在
        if (!file.getParentFile().exists()) {
            try {
                FileUtils.forceMkdir(file.getParentFile());
                //创建目标文件
                if (!file.createNewFile()) {
                    message = "create file " + filePath + " fail";
                    throw new IOException(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
       File file = new File("./a.txt");
        System.out.println(file.getParentFile());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
