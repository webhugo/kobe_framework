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
    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        map.put("BASE_PACKAGE",properties.getProperty("base_package"));
    }

    public static void main(String[] args) {

    }
}
