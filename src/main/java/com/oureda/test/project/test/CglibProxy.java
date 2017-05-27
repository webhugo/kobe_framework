package com.oureda.test.project.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by webhugo on 17-5-27.
 */

public class CglibProxy implements MethodInterceptor {

    public static CglibProxy instance = new CglibProxy();

    public static CglibProxy getInstance(){
        return instance;
    }

    public <T> T getProxy(Class clazz) {
        // 通过字节码技术动态创建子类实例
        return (T) Enhancer.create(clazz, this);
    }

    // 实现 MethodInterceptor 接口方法
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("前置代理");
        // 通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("后置代理");
        return result;
    }
}

