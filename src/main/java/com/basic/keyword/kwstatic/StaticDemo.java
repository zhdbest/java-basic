package com.basic.keyword.kwstatic;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/25 19:43
 */
public class StaticDemo {

    public static void main(String[] args) {
        // 非静态对象
        ClassWithNonStaticObj nonStaticObj1 = new ClassWithNonStaticObj();
        ClassWithNonStaticObj nonStaticObj2 = new ClassWithNonStaticObj();
        System.out.println(nonStaticObj1.getObj() == nonStaticObj2.getObj());

        // 静态对象
        ClassWithStaticObj staticObj1 = new ClassWithStaticObj();
        ClassWithStaticObj staticObj2 = new ClassWithStaticObj();
        System.out.println(staticObj1.getObj() == staticObj2.getObj());

        // 测试调用顺序
        Son son = new Son();
    }
}
