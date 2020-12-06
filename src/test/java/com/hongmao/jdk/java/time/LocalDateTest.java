package com.hongmao.jdk.java.time;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/25 18:18
 */
public class LocalDateTest {


    @Test
    public void getYesterday() {
        System.out.println(LocalDate.now().minusDays(1));
    }
}
