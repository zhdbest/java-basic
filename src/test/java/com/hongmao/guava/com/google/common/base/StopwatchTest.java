package com.hongmao.guava.com.google.common.base;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/25 14:44
 */
public class StopwatchTest {

    @Test
    public void testStopwatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Thread.sleep(1);
        stopwatch.stop();

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));


    }
}
