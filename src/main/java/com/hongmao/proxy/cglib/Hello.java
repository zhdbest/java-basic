package com.hongmao.proxy.cglib;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/1 19:09
 */
public class Hello {

    public void sayHello() {
        System.out.println("Hello!");
    }

    public final void sayFinal() {
        System.out.println("Final!");
    }

    public static void sayStatic() {
        System.out.println("Static!");
    }
}
