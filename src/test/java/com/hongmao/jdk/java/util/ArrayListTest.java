package com.hongmao.jdk.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

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
    public void testAddAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 本处为错误示例
        list.addAll(list);
        System.out.println(list);
    }

    @Test
    public void testListIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // 指定索引获取的迭代器，调用next方法会获得该索引位置的元素
        System.out.println(list.listIterator(2).previous());
        System.out.println(list.listIterator(2).next());
        // 不指定索引，等同于指定的索引为0，也即从头开始
        System.out.println(list.listIterator().hasPrevious());
        System.out.println(list.listIterator().next());
    }

    @Test
    public void testSubList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> subList = list.subList(1, 3);
        System.out.println(list);
        System.out.println(subList);
        System.out.println(subList.getClass());
    }

    @Test
    public void testRemoveIf() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.removeIf(l -> l >1 && l < 4);
        System.out.println(list);
    }

    @Test
    public void testReplaceAll() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.replaceAll(i -> i * 5);
        System.out.println(list);
    }

    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.sort(Comparator.comparingInt(i -> -i));
        System.out.println(list);
    }

    @Test
    public void testIterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        iterator.next();
        iterator.next();
        iterator.forEachRemaining(System.out::println);
    }

    @Test
    public void testSpliterator() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.spliterator());
    }

    /** 如下为ArrayList内部类ArrayListSpliterator相关测试 **/


    @Test
    public void testTryAdvance() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Spliterator spliterator = list.spliterator();
        spliterator.tryAdvance(System.out::println);

    }

    @Test
    public void testTrySplit() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Spliterator<Integer> spliterator = list.spliterator();
        Spliterator<Integer> spliterator1 = spliterator.trySplit();

        System.out.println(spliterator);
        System.out.println(spliterator1);

        System.out.println("spliterator1 : ");
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("spliterator : ");
        spliterator.forEachRemaining(System.out::println);


        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        System.out.println("spliterator2 : " + spliterator2);

    }

    @Test
    public void testCharacteristics() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Spliterator<Integer> spliterator = list.spliterator();
        System.out.println(spliterator.characteristics());
    }

    @Test
    public void testGetExactSizeIfKnown() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Spliterator<Integer> spliterator = list.spliterator();
        System.out.println(spliterator.getExactSizeIfKnown());
    }

    @Test
    public void testForEachRemaining() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Spliterator<Integer> spliterator = list.spliterator();
        spliterator.trySplit();
        spliterator.forEachRemaining(System.out::println);
    }

    /* ArrayList的内部类SubList相关测试 Start */
    @Test
    public void testSubListSet() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        // SubList
        List<Integer> subList = list.subList(1, 2);
        subList.set(0, 100);
        // 打印SubList
        System.out.println(subList);
        // 打印ArrayList，会发现修改了SubList中的元素，其父列表也会变更。
        System.out.println(list);
    }


    /* ArrayList的内部类SubList相关测试 End */

}
