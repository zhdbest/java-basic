package com.hongmao.collection.list.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/7 16:11
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        List list = new LinkedList();
        // add
        list.add("1");
        list.add(1, "2");

        // set
        printList(list);
        list.set(1, "set");
        printList(list);

        // remove
        list.remove("set");
        list.remove(0);
        printList(list);
    }

    private static void printList(List list) {
        if (list == null) {
            System.out.println("list为空");
            return;
        }
        System.out.println("list中元素数量：" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("下标：%s，元素：%s", i, list.get(i)));
        }
    }
}
