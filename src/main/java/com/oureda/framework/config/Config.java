package com.oureda.framework.config;

import com.oureda.framework.util.PropsUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by webhugo on 17-5-10.
 */
public class Config {
    public static Map<String,String> map= new HashMap();
    public static String BASE_PACKAGE = "base_package";
    public static String JSP_PATH = "JSP_PATH";
    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        map.put("BASE_PACKAGE",properties.getProperty("base_package"));
        map.put("JSP_PATH",properties.getProperty("jsp_path"));
    }

    public static void main(String[] args) {

    }
}
