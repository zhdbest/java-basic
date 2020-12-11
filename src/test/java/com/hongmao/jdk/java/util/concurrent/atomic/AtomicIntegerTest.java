package com.hongmao.jdk.java.util.concurrent.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/8 16:14
 */
public class AtomicIntegerTest {


    @Test
    public void testGetAndAdd() {
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 5; i++) {
            System.out.println(atomicInteger.getAndAdd(1));
        }
        System.out.println("***************************");
        for (int i = 0; i < 5; i++) {
            System.out.println(atomicInteger.getAndAdd(2));
        }
    }
}
