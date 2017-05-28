package com.oureda.framework.load;

import com.oureda.framework.annotation.Aspect;
import com.oureda.framework.proxy.AspectProxy;
import com.oureda.framework.proxy.Proxy;
import com.oureda.framework.proxy.ProxyFactory;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by webhugo on 17-5-27.
 */
public class InitAspect {
    private static final Set<Class<?>> CLASS_SET = LoadAllClass.set;


    static {
        //获取继承于AspectProxy的所有类,和对应代理的target类,键是proxy类，值是target类
        Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>();
        for (Class<?> aClass : CLASS_SET) {
            if (AspectProxy.class.isAssignableFrom(aClass) && !aClass.equals(AspectProxy.class)) {
                if (aClass.isAnnotationPresent(Aspect.class)) {
                    Aspect aspect = aClass.getAnnotation(Aspect.class);
                    //根据@Aspect()的value获取对应所有的类，即是对应的所有类
                    Set<Class<?>> targetClassSet = new HashSet<Class<?>>();
                    Class<? extends Annotation> annotation = aspect.value();
                    if (annotation != null && !annotation.equals(Aspect.class)) {
                        targetClassSet.addAll(LoadAllClass.getClassSetByAnnotation(annotation));
                    }

                    proxyMap.put(aClass, targetClassSet);
                }
            }
        }
        //键是target类，值是proxy对象集合,即是一个target对象要被哪些proxy代理
        Map<Class<?>, List<Proxy>> targetMap = new HashMap<Class<?>, List<Proxy>>();
        for (Map.Entry<Class<?>, Set<Class<?>>> classSetEntry : proxyMap.entrySet()) {
            Class<?> proxyClass = classSetEntry.getKey();
            Set<Class<?>> targetClasses = classSetEntry.getValue();
            for (Class<?> targetClass : targetClasses) {
                try {
                    Proxy proxy = (Proxy) proxyClass.newInstance();
                    if (targetMap.containsKey(targetClass)) {
                        targetMap.get(targetClass).add(proxy);
                    } else {
                        List<Proxy> proxyList = new ArrayList<Proxy>();
                        proxyList.add(proxy);
                        targetMap.put(targetClass, proxyList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //动态生成
        for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
            Class<?> targetClass = targetEntry.getKey();
            List<Proxy> proxyList = targetEntry.getValue();
            Object proxy = ProxyFactory.createProxy(targetClass, proxyList);
            //把原来的覆盖掉，proxy对象就是增强之后的,这也是为什么在Init类中加载的顺序是InitAspect再到InitInject
            LoadAllBean.setBean(targetClass, proxy);
        }

    }
}
