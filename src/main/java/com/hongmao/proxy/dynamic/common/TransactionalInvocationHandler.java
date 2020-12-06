package com.hongmao.proxy.dynamic.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/31 18:01
 */
public class TransactionalInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionalInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("BEGIN TRANSACTION");
        Object obj;
        try {
            obj = method.invoke(target, args);
        } catch (Exception e) {
            System.out.println("ROLLBACK");
            throw e;
        }
        System.out.println("COMMIT");
        return obj;
    }
}
