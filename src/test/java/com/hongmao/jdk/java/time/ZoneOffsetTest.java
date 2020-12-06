package com.hongmao.jdk.java.time;

import org.junit.Test;

import java.time.ZoneOffset;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/26 18:45
 */
public class ZoneOffsetTest {

    @Test
    public void testGetId() {
        // 世界标准时间
        System.out.println(ZoneOffset.UTC.getId());
        // 偏移5秒，其实ZoneOffset重写的toString()方法返回的就是id
        System.out.println(ZoneOffset.ofTotalSeconds(5));
    }

    @Test
    public void testOfTotalSeconds() {
        // 偏移5秒
        System.out.println(ZoneOffset.ofTotalSeconds(5));
        // 偏移-6秒
        System.out.println(ZoneOffset.ofTotalSeconds(-6));
        // 偏移7200秒
        System.out.println(ZoneOffset.ofTotalSeconds(7200));
    }
}
