package com.hongmao.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/8 18:38
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {

        // 测试插入顺序的LinkedHashMap
        Map<String, Object> insertOrderMap = getInsertOrderMap();
        System.out.println(insertOrderMap);
        System.out.println(insertOrderMap.get("2"));
        System.out.println(insertOrderMap);
        insertOrderMap.remove("4");

        // 测试访问顺序的LinkedHashMap
        Map<String, Object> accessOrderMap = getAccessOrderMap();
        System.out.println(accessOrderMap);
        System.out.println(accessOrderMap.get("2"));
        System.out.println(accessOrderMap);
    }

    public static Map<String, Object> getInsertOrderMap() {
        Map<String, Object> insertOrderMap = new LinkedHashMap<String, Object>();
        insertOrderMap.put("1", "一");
        insertOrderMap.put("2", "二");
        insertOrderMap.put("3", "三");
        insertOrderMap.put("4", "四");
        return insertOrderMap;
    }

    public static Map<String, Object> getAccessOrderMap() {
        Map<String, Object> accessOrderMap = new LinkedHashMap<String, Object>(16, 0.75f, true);
        accessOrderMap.put("1", "一");
        accessOrderMap.put("2", "二");
        accessOrderMap.put("3", "三");
        accessOrderMap.put("4", "四");
        return accessOrderMap;
    }
}
