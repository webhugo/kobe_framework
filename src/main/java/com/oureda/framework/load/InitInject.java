package com.oureda.framework.load;

/**
 * Created by webhugo on 17-5-10.
 */

import com.oureda.framework.annotation.Inject;
import com.oureda.framework.util.ReflectUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 检查Inject
 */
public class InitInject {

    public static Map<Class<?>, Object> BEAN_MAP;

    static {
        System.out.println("intiInject");
        BEAN_MAP = LoadAllBean.BEAN_MAP;
        for (Map.Entry<Class<?>, Object> entry : BEAN_MAP.entrySet()) {
            Class<?> beanClass = entry.getKey();
            Object instance = entry.getValue();
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> beanFieldClass = field.getType();
                    Object beanFeildInstance = BEAN_MAP.get(beanFieldClass);
                    if (beanFeildInstance != null){
                        ReflectUtil.setField(instance, field, beanFeildInstance);
                    }

                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
