package com.hongmao.jdk.java.util.concurrent;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/18 14:07
 */
public class CompletableFutureTest {

    @Test
    public void testSupplyAsync() throws Exception {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> getStr(1));
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> getStr(2));
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> getStr(3));

        System.out.println(task3.get());
        System.out.println(task2.get());
        System.out.println(task1.get());

        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    @Test
    public void testSupplyAsyncWithExecutor() throws Exception {
        StopWatch stopWatch = new StopWatch();

        // 单个线程去跑，耗时为3次调用之和
        Executor executor = Executors.newSingleThreadExecutor();

        stopWatch.start();
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> getStr(1), executor);
        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> getStr(2), executor);
        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> getStr(3), executor);

        System.out.println(task3.get());
        System.out.println(task2.get());
        System.out.println(task1.get());

        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }













    private String getStr(Integer i) {
        System.out.println(Thread.currentThread().getName() + "执行task：" + i);
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            builder.append("*");
        }
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i + " " + builder;
    }
}
