package com.hongmao.jdk.java.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/25 18:18
 */
public class LocalDateTest {


    @Test
    public void getYesterday() {
        System.out.println(LocalDate.now().minusDays(1));
    }

    @Test
    public void dateToLocalDate() {
        Date date = new Date();

        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
}
