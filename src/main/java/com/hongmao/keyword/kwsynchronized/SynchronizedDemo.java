package com.hongmao.keyword.kwsynchronized;


/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/18 21:10
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        // 测试修饰实例方法
        testSyncMethod();

        // 测试修饰类方法
        testSyncStaticMethod();

        // 测试修饰代码块
        checkSyncBlock();
    }

    /**
     * 测试没有synchronized的方法
     */
    private static void checkNoSafeList() {
        final NoSafeList<String> noSafeList = new NoSafeList<String>(500000);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        noSafeList.add("hello");
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(noSafeList.size());
    }

    /**
     * 测试synchronized方法
     */
    private static void checkSafeList() {
        final SafeList<String> safeList = new SafeList<String>(500000);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        safeList.add("hello");
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(safeList.size());
    }

    /**
     * 测试锁定实例方法
     */
    private static void testSyncMethod() {
        checkNoSafeList();
        checkSafeList();
    }

    /**
     * 测试同步代码块
     */
    private static void checkSyncBlock() {
        final NoSafeList<String> noSafeList = new NoSafeList<String>(500000);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (noSafeList) {
                        for (int j = 0; j < 10000; j++) {
                            noSafeList.add("hello");
                        }
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(noSafeList.size());
    }

    /**
     * 测试普通类方法
     */
    private static void checkNoSafeIncrease() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5000; j++) {
                        NoSafeIncrease.addOne();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(NoSafeIncrease.get());
    }

    /**
     * 测试同步类方法
     */
    private static void checkSafeIncrease() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 5000; j++) {
                        SafeIncrease.addOne();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(SafeIncrease.get());
    }

    /**
     * 测试锁定类方法
     */
    private static void testSyncStaticMethod() {
        checkNoSafeIncrease();
        checkSafeIncrease();
    }
}
