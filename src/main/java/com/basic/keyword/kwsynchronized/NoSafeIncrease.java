package com.basic.keyword.kwsynchronized;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/18 21:48
 */
public class NoSafeIncrease {

    private static int i = 0;

    public static void addOne() {
        i++;
    }

    public static void addTwo() {
        i = i + 2;
    }

    public static int get() {
        return i;
    }
}
