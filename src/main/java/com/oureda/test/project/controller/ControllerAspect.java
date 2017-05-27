package com.oureda.test.project.controller;

import com.oureda.framework.annotation.Aspect;
import com.oureda.framework.annotation.Controller;
import com.oureda.framework.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by webhugo on 17-5-27.
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        System.out.println("--------begin---------");
        System.out.println(String.format("class: %s",cls.getName()));
        System.out.println(String.format("method: %s",method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        System.out.println(String.format("time: %dms",System.currentTimeMillis()-begin));
//        System.out.println(System.currentTimeMillis()-begin);
        System.out.println("--------end--------");
    }
}
