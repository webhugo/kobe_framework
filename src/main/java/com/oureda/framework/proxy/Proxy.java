package com.oureda.framework.proxy;

/**
 * Created by webhugo on 17-5-27.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
