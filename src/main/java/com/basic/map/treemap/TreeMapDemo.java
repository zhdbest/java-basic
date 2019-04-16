package com.basic.map.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/14 12:38
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Long, Object> defaultTreeMap = getDefaultTreeMap();
//        defaultTreeMap.put(null ,null);

        // 指定了比较器的TreeMap是可能支持key为null的
        Map<Long, Object> diyTreeMap = getDIYTreeMap();
        diyTreeMap.put(null, null);
        System.out.println(diyTreeMap);
        diyTreeMap.remove(null);
    }

    private static TreeMap<Long, Object> getDefaultTreeMap() {
        return new TreeMap<Long, Object>();
    }

    private static TreeMap<Long, Object> getDIYTreeMap() {
        return new TreeMap<Long, Object>(new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return 0;
            }
        });
    }
}
