package com.hongmao.jdk.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/8 19:15
 */
public class ArrayListTest {

    @Test
    public void testArrayListWithCollection() {
        // list1，类型是Arrays中自已实现的ArrayList，其内部用于存储列表元素的数组类型为：E[]，E为泛型
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        System.out.println(list1.toArray().getClass());

        // list2，类型是java.util.ArrayList，即使声明这是一个Integer列表，但其用于存储列表元素的数组类型仍为：Object[]
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        System.out.println(list2.toArray().getClass());

        // 使用参数为一个集合的构造器构造一个java.util.ArrayList实例，即使该集合的toArray()方法返回的并非Object[]类型，则该构造器也会对其进行转换
        List<Integer> list3 = new ArrayList<>(list2);
        System.out.println(list3.toArray().getClass());
    }

    @Test
    public void testTrimToSize() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.trimToSize();
    }

    @Test
    public void testEnsureCapacity() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.ensureCapacity(20);
    }












    @Test
    public void testToArray() {
        System.out.println(5 >> 1);
    }






}
