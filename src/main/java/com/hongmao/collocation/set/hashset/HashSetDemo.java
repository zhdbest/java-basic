package com.hongmao.collocation.set.hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/7 18:37
 */
public class HashSetDemo {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("1");
        set.add("1");
        System.out.println(set.size());
    }
}
