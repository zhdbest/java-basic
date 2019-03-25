package com.basic.keyword.kwstatic;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/25 21:14
 */
public class Son extends Father {

    Friend friend = new Friend();

    static Wife wife = new Wife();

    static {
        System.out.println("I am son");
    }

    Son() {
        System.out.println("son 构造器");
    }
}
