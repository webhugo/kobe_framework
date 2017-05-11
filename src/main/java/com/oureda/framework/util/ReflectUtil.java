package com.oureda.framework.util;

/**
 * Created by webhugo on 17-5-10.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射生成实例对象注入
 */
public class ReflectUtil {

    public static Object newInstance(Class<?> cls){
        Object instance;
        try {
            instance = cls.newInstance();
        } catch ( Exception e){
            System.out.println("new instance failure"+ e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    public static Object invokeMethod(Object obj, Method method , Object ...params){
        Object result;
        try{
            method.setAccessible(true);
            result = method.invoke(obj,params);
        }catch (Exception e){
            System.out.println("invoke method failure"+e);
            throw new RuntimeException(e);
        }
        return result;
    }


    public static void setField(Object obj, Field field,Object value) {
        try {
            field.setAccessible(true);
            field.set(obj,value);
        }catch (Exception e){
            System.out.println("set field failure"+e);
            throw new RuntimeException(e);
        }
    }
}
