package com.hongmao.keyword.kwsynchronized;

/**
 * 一个极其简易的List，只可用于验证并发
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/18 20:56
 */
public class SafeList<T> {

    private Object[] table;

    private int size;

    public SafeList(int initCapacity) {
        table = new Object[initCapacity];
    }

    public synchronized boolean add(T t) {
        table[size++] = t;
        return true;
    }

    public Object get(int index) {
        return table[index];
    }

    public int size() {
        return size;
    }
}
