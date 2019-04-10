package com.basic.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/8 18:38
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");
        map.put("4", "四");

        System.out.println(map.get("2"));
    }
}
