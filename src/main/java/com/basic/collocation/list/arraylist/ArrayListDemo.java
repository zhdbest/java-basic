package com.basic.collocation.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/7 11:02
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        // 在下标3的位置新增元素
        List<String> aList = getStringList();
        aList.add(3, "add(index, element)");
        printList(aList);

        // 在下标3的位置设置元素
        List<String> bList = getStringList();
        bList.set(3, "set(index, element)");
        printList(bList);

        // 删除指定元素
        List<String> cList = getStringList();
        cList.remove("2");
        printList(cList);

        // 删除指定位置元素
        List<String> dList = getStringList();
        dList.remove(0);
        printList(dList);
    }

    private static List<String> getStringList() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        return list;
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
