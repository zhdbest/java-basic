package com.hongmao.apache.commons.commonslang3.org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/11/25 14:44
 */
public class StopWatchTest {

    @Test
    public void testStopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(stopWatch);
        stopWatch.stop();
        System.out.println(stopWatch.getNanoTime());
        System.out.println(stopWatch.getStartTime());
    }
}