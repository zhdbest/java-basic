package com.basic.map.linkedhashmap.lrucache;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/13 17:32
 */
public class LruCacheDemo {

    public static void main(String[] args) {
        LruCache<String, Object> lruCache = new LruCache<String, Object>(5);
        for (int i = 0; i < 10; i++) {
            lruCache.put(String.valueOf(i), i);
        }
        System.out.println("size : " + lruCache.size());
        System.out.println("map : " + lruCache);

        lruCache.get("5");
        lruCache.put("11", 11);

        System.out.println("size : " + lruCache.size());
        System.out.println("map : " + lruCache);
    }
}
