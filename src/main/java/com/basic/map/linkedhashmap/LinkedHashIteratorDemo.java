package com.basic.map.linkedhashmap;

import java.util.Iterator;
import java.util.Map;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/13 14:20
 */
public class LinkedHashIteratorDemo {

    public static void main(String[] args) {
        // 测试并发修改异常
        checkConcurrentModificationException();
    }

    private static void checkConcurrentModificationException() {
        Map<String, Object> insertOrderMap = LinkedHashMapDemo.getInsertOrderMap();
        Iterator iterator = insertOrderMap.entrySet().iterator();
        insertOrderMap.put("5", "五");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
