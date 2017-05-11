package com.oureda.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by webhugo on 17-5-10.
 */
//描述方法
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Routing {

    public METHOD method() default METHOD.GET;

    public String value() default "/";

    enum METHOD{
        GET(),POST(),PUT(),DELETE();
    }


}

