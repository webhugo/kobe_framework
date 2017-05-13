package com.oureda.framework.load;

/**
 * Created by webhugo on 17-5-10.
 */

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.annotation.Service;
import com.oureda.framework.util.ClassUtil;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * 检查Service
 */
public class InitService {
    private static Set<Class<?>> SERVICE_SET = new HashSet<>();
    public static Set<Class<?>> set = null;
    static {
        // TODO: 17-5-10 初始化工作
        set = LoadAllClass.set;
        for (Class<?> cls : set) {
            if(cls.isAnnotationPresent(Service.class)){
                SERVICE_SET.add(cls);
            }
        }
    }



    public static void main(String[] args) {
    }
}
