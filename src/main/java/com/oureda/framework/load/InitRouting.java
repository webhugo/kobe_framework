package com.oureda.framework.load;

/**
 * Created by webhugo on 17-5-10.
 */

import com.oureda.framework.annotation.Inject;
import com.oureda.framework.annotation.Routing;
import com.oureda.framework.handleRouter.Handler;
import com.oureda.framework.handleRouter.Request;
import com.oureda.framework.util.ReflectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 检查Routing
 */
public class InitRouting {

    public static Map<Class<?>, Object> BEAN_MAP;
    public static Map<Request, Handler> HANDLER_MAP = new HashMap<>();

    static {
        System.out.println("initRouting");
        BEAN_MAP = LoadAllBean.BEAN_MAP;
        for (Map.Entry<Class<?>, Object> entry : BEAN_MAP.entrySet()) {
            Class<?> beanClass = entry.getKey();
            Object instance = entry.getValue();
            Method[] methods = beanClass.getDeclaredMethods();
            for (Method method:methods) {
                if(method.isAnnotationPresent(Routing.class)){
                    Routing routing = method.getAnnotation(Routing.class);
                    String requestPath = routing.value();
                    Routing.METHOD requestMethod = routing.method();
                    Request request = new Request(requestPath,requestMethod.toString());
                    Handler handler = new Handler(beanClass,method);
                    System.out.println(request);
                    HANDLER_MAP.put(request,handler);

                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
