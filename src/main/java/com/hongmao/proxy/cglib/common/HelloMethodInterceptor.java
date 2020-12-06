package com.hongmao.proxy.cglib.common;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/1 19:18
 */
public class HelloMethodInterceptor implements MethodInterceptor {

    private Object target;

    public HelloMethodInterceptor(Object target) {
        this.target = target;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // 记日志
        System.out.println("记录调用日志");
        return method.invoke(target, args);
    }
}
