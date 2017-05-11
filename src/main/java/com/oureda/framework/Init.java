package com.oureda.framework;

import com.oureda.framework.load.*;
import com.oureda.framework.util.ClassUtil;
import com.oureda.framework.util.JsonUtil;

/**
 * Created by webhugo on 17-5-10.
 */
public class Init {

    public static void init(){
        Class<?>[] classList = {
                LoadAllClass.class,
                LoadAllBean.class,
                InitRouting.class,
                InitController.class,
                InitInject.class,
                InitService.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
        System.out.println("init");
    }

    public static void main(String[] args) {
        init();
    }
}