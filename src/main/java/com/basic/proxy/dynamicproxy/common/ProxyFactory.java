package com.basic.proxy.dynamicproxy.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 18:51
 */
public class ProxyFactory {

    public static Object getProxy(Class cls, InvocationHandler invocationHandler) {
        return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), invocationHandler);
    }
}
