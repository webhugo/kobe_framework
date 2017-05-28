package com.oureda.framework.load;

import com.oureda.framework.config.Config;
import com.oureda.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by webhugo on 17-5-10.
 */
public class LoadAllClass {
    public static Set<Class<?>> set = ClassUtil.getClassSet(Config.map.get("BASE_PACKAGE"));

    /**
     * 获取应用包名下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {

        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : set) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
