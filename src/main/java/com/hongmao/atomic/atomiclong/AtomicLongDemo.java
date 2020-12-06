package com.hongmao.atomic.atomiclong;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/10 19:02
 */
public class AtomicLongDemo {

    private static long notSafe = 0;

    private static long sync = 0;

    private static AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {
        // 普通long自增
        incrementNotSafe();
        // 同步自增
        incrementSync();
        // 原子类自增
        incrementAtomicLong();
    }

    /**
     * 普通long自增
     */
    private static void incrementNotSafe() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        notSafe++;
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(notSafe);
    }

    /**
     * 同步自增
     */
    private static void incrementSync() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        synchronized (AtomicLongDemo.class) {
                            sync++;
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sync);
    }

    /**
     * 原子类自增
     */
    private static void incrementAtomicLong() {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        atomicLong.incrementAndGet();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicLong.get());
    }
}
