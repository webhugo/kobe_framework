package com.oureda.framework.load;

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.annotation.Service;
import com.oureda.framework.util.ReflectUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by webhugo on 17-5-10.
 */
public class LoadAllBean {
    public static Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        for (Class<?> cls : LoadAllClass.set) {
            if(cls.isAnnotationPresent(Controller.class)){
                BEAN_MAP.put(cls,ReflectUtil.newInstance(cls));
            }
        }
        for (Class<?> cls : LoadAllClass.set) {
            if(cls.isAnnotationPresent(Service.class)){
                BEAN_MAP.put(cls,ReflectUtil.newInstance(cls));
            }
        }
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> cls, Object obj) {
        BEAN_MAP.put(cls, obj);
    }

}
