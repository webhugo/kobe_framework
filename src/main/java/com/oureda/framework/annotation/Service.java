package com.oureda.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by webhugo on 17-5-10.
 */

@Target(ElementType.TYPE)
//运行时保存
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

}
