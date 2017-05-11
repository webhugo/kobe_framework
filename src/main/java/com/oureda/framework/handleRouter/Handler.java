package com.oureda.framework.handleRouter;

import java.lang.reflect.Method;

/**
 * Created by webhugo on 17-5-10.
 */
public class Handler {
    public Class<?> controllerClass;
    public Method method;

    public Handler(Class<?> controllerClass, Method method) {
        this.controllerClass = controllerClass;
        this.method = method;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Handler{" +
                "controllerClass=" + controllerClass +
                ", method=" + method +
                '}';
    }
}
