package com.oureda.test.project.test;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Created by webhugo on 17-5-27.
 */
public class ProxyTest {
    public static void main(String[] args) {
        HelloImpl hello = CglibProxy.getInstance().getProxy(HelloImpl.class);
        hello.say();
    }
}
