package com.hongmao.keyword.kwstatic;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/25 19:44
 */
public class ClassWithStaticObj {
    private static Object obj = new Object();

    public static Object getObj() {
        return obj;
    }

    public static void setObj(Object obj) {
        ClassWithStaticObj.obj = obj;
    }
}
