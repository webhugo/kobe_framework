package com.oureda.framework.load;

/**
 * Created by webhugo on 17-5-10.
 */

import com.oureda.framework.annotation.Controller;
import com.oureda.framework.config.Config;
import com.oureda.framework.handleRouter.Handler;
import com.oureda.framework.handleRouter.Request;
import com.oureda.framework.util.ClassUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 检查Controller
 */
public class InitController {
    private static Set<Class<?>> CONTROLLER_SET = new HashSet<>();
    public static Map<Request, Handler> HANDLER_MAP;
    public static Set<Class<?>> set = null;
    static {
        System.out.println("initController");
        // TODO: 17-5-10 初始化工作
        set = LoadAllClass.set;
        for (Class<?> cls : set) {
            if(cls.isAnnotationPresent(Controller.class)){
                CONTROLLER_SET.add(cls);
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath){
        Request request = new Request(requestPath,requestMethod);
        System.out.println(request);
        return InitRouting.HANDLER_MAP.get(request);
    }


    public static Object getController(Class<?> cls){
        // TODO 17-5-10
        return LoadAllBean.BEAN_MAP.get(cls);
    }
    public static void main(String[] args) {
        System.out.println(CONTROLLER_SET);;
    }
}
