package com.basic.keyword.kwsynchronized;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/18 21:42
 */
public class SafeIncrease {

    private static int i = 0;

    public static synchronized void addOne() {
        i++;
    }

    public synchronized void addTwo() {
        i = i + 2;
    }

    public static int get() {
        return i;
    }
}
