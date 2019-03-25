package com.basic.keyword.kwstatic;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/25 19:44
 */
public class ClassWithNonStaticObj {
    private Object obj = new Object();

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
