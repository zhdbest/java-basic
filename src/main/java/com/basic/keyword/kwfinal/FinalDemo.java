package com.basic.keyword.kwfinal;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/3/24 15:07
 */
public class FinalDemo {

    private static void change(Object obj) {
        obj = new PalmCivet();
        System.out.println(obj.getClass().getSimpleName());
    }

    private static void change2(final Object obj) {
        // obj = new PalmCivet();
        System.out.println(obj.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Prince prince = new Prince();
        change(prince);
        change2(prince);
    }
}
