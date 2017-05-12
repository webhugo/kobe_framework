package com.oureda.framework.config;

import com.oureda.framework.util.PropsUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by webhugo on 17-5-10.
 */
public class Config {
    public static Map<String, String> map = new HashMap();
    public static String BASE_PACKAGE = "base_package";
    public static String JSP_PATH = "JSP_PATH";
    public static String FILE_UPLOAD_LIMIT = "FILE_UPLOAD_LIMIT";

    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        map.put("BASE_PACKAGE", properties.getProperty("base_package"));
        map.put("JSP_PATH", properties.getProperty("jsp_path"));
        if(properties.getProperty("file_upload_limit") == null){
            map.put(FILE_UPLOAD_LIMIT, "1");
        }else{
            map.put(FILE_UPLOAD_LIMIT, properties.getProperty("file_upload_limit"));
        }
    }

    public static void main(String[] args) {

    }
}
