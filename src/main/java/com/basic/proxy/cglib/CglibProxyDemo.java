package com.basic.proxy.cglib;

import com.basic.proxy.cglib.common.CglibProxyFactory;
import com.basic.proxy.cglib.common.HelloMethodInterceptor;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/1 19:10
 */
public class CglibProxyDemo {

    public static void main(String[] args) {

        Hello hello = (Hello) CglibProxyFactory.getProxy(Hello.class, new HelloMethodInterceptor(new Hello()));
        hello.sayHello();
        hello.sayFinal();
        // 应尽量避免使用对象调用static方法
        hello.sayStatic();
    }
}
