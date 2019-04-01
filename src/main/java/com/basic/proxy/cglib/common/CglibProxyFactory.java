package com.basic.proxy.cglib.common;


import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/1 19:37
 */
public class CglibProxyFactory {

    public static Object getProxy(Class cls, Callback callback) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(callback);
        return enhancer.create();
    }
}
