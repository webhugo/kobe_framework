package com.oureda.framework.load;

import com.oureda.framework.config.Config;
import com.oureda.framework.util.ClassUtil;

import java.util.Set;

/**
 * Created by webhugo on 17-5-10.
 */
public class LoadAllClass {
    public static Set<Class<?>> set = ClassUtil.getClassSet(Config.map.get("BASE_PACKAGE"));
}
