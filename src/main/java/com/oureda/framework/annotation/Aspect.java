package com.oureda.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by webhugo on 17-5-27.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
