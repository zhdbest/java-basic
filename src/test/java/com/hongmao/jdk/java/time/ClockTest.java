package com.hongmao.jdk.java.time;

import org.junit.Test;

import java.time.Clock;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/24 18:42
 */
public class ClockTest {

    @Test
    public void testSystemUTC() {
        System.out.println(Clock.systemUTC().instant());
    }
}
