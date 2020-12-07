package com.hongmao.jdk.java.lang;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2020/12/6 12:53
 */
public class StringTest {

    @Test
    public void testString1() {
        char[] chars = new char[5];
        Arrays.fill(chars, 'a');
        String str = new String(chars);
        System.out.println(str);
    }

    @Test
    public void testString2() {
        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        // 偏移量为0
        System.out.println(new String(chars, 0, 3));
        // 偏移量为1
        System.out.println(new String(chars, 1, 3));
    }

    @Test
    public void testString3() {
        System.out.println(new String(new int[]{41, 42, 43, 44, 45}, 0, 5));
        System.out.println(new String(new int[]{51, 52, 53, 54, 55}, 0, 5));
        System.out.println(new String(new int[]{61, 62, 63, 64, 65}, 0, 5));
    }

    @Test
    public void testString4() throws UnsupportedEncodingException {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, 0, bytes.length, "UTF-8"));
        System.out.println(new String(bytes, 0, 12, "UTF-8"));
        System.out.println(new String(bytes, 12, 12, "UTF-8"));
    }

    @Test
    public void testString5() {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, 0, bytes.length, StandardCharsets.UTF_8));
        System.out.println(new String(bytes, 0, 12, StandardCharsets.UTF_8));
        System.out.println(new String(bytes, 12, 12, StandardCharsets.UTF_8));
    }

    @Test
    public void testString6() throws UnsupportedEncodingException {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, "UTF-8"));
    }

    @Test
    public void testString7() {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void testString8() {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes, 0, bytes.length));
    }

    @Test
    public void testString9() {
        String str = "富强民主文明和谐";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
    }

    @Test
    public void testString10() {
        StringBuffer sf = new StringBuffer("StringBuffer线程安全");
        System.out.println(new String(sf));

        StringBuilder sd = new StringBuilder("StringBuilder线程不安全");
        System.out.println(new String(sd));
    }

    @Test
    public void testCodePointAt() {
        String str = "12345";
        System.out.println(str.codePointAt(2));
    }

    @Test
    public void testCodePointBefore() {
        String str = "02468";
        System.out.println(str.codePointAt(2));
        System.out.println(str.codePointBefore(2));
    }

    @Test
    public void testCodePointCount() {
        String str1 = "02468";
        System.out.println(str1.codePointCount(0, str1.length()));
        String str2 = "11111";
        System.out.println(str2.codePointCount(0, str2.length()));
    }

    @Test
    public void testOffsetByCodePoints() {
        String str = "azf";
        System.out.println(str.offsetByCodePoints(0, 2));
    }

    @Test
    public void testGetChars() {
        String str = "asdhajk";
        char[] chars = new char[30];
        // 截取完整字符串到给定的数组中，从数组的第一个元素位置开始写入
        str.getChars(0, str.length(), chars, 0);
        System.out.println(chars);
        // 截取完整字符串到给定的数组中，从数组的第N个元素位置开始写入
        str.getChars(0, str.length(), chars, str.length());
        System.out.println(chars);
        // 截取字符串的第二第三位到给定的数组中
        str.getChars(1, 3, chars, str.length() * 2);
        System.out.println(chars);
    }

    @Test
    public void testGetBytesWithCharsetName() throws UnsupportedEncodingException {
        String str = "文明和谐";
        for (byte aByte : str.getBytes("UTF-8")) {
            System.out.println(aByte);
        }
        System.out.println("******");
        for (byte aByte : str.getBytes("UTF-16")) {
            System.out.println(aByte);
        }
    }


    @Test
    public void testGetBytesWithCharset() {
        String str = "文明和谐";
        for (byte aByte : str.getBytes(StandardCharsets.UTF_8)) {
            System.out.println(aByte);
        }
        System.out.println("******");
        for (byte aByte : str.getBytes(StandardCharsets.UTF_16)) {
            System.out.println(aByte);
        }
    }

    @Test
    public void testGetBytes() {
        String str = "文明和谐";
        for (byte aByte : str.getBytes()) {
            System.out.println(aByte);
        }
    }

    @Test
    public void testEquals() {
        String str1 = "文明和谐";
        String str2 = "文明和谐";
        String str3 = "富强民主";

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
    }

    @Test
    public void testContentEquals() {
        String str = "富强民主";
        String str2 = "文明和谐";
        StringBuffer stringBuffer = new StringBuffer("爱国敬业");
        StringBuilder stringBuilder = new StringBuilder("诚信友善");
        StringBuilder stringBuilder2 = new StringBuilder("富强民主");
        System.out.println("字符串与字符串比较：" + str.contentEquals(str2));
        System.out.println("字符串与StringBuffer比较：" + str.contentEquals(stringBuffer));
        System.out.println("字符串与StringBuilder比较：" + str.contentEquals(stringBuilder));
        System.out.println("字符串与StringBuilder比较：" + str.contentEquals(stringBuilder2));
    }

    @Test
    public void testEqualsIgnoreCase() {
        String str1 = "Abc";
        String str2 = "abc";
        System.out.println(str1.equals(str2));
        System.out.println(str1.contentEquals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }

    @Test
    public void testCompareTo() {
        String str1 = "abc";
        String str2 = "Abc";
        String str3 = "Abcde";
        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str3));
        System.out.println('a' - 'A');
    }


    @Test
    public void testCompareToIgnoreCase() {
        String str1 = "abc";
        String str2 = "Abc";
        String str3 = "Abcde";
        System.out.println(str1.compareToIgnoreCase(str2));
        System.out.println(str2.compareToIgnoreCase(str3));
    }


    @Test
    public void testRegionMatches() {
        String str1 = "abcde";
        String str2 = "bcd";
        // 比较str1从索引位置1开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等
        System.out.println(str1.regionMatches(1, str2, 0, 3));
        // 比较str1从索引位置2开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等
        System.out.println(str1.regionMatches(2, str2, 0, 3));
    }

    @Test
    public void testRegionMatchesIgnoreCase() {
        String str1 = "abcde";
        String str2 = "bcD";
        // 比较str1从索引位置1开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等，忽略大小写
        System.out.println(str1.regionMatches(true, 1, str2, 0, 3));
        // 比较str1从索引位置2开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等，忽略大小写
        System.out.println(str1.regionMatches(true, 2, str2, 0, 3));

        // 比较str1从索引位置1开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等，不忽略大小写
        System.out.println(str1.regionMatches(false, 1, str2, 0, 3));
        // 比较str1从索引位置2开始3个字符的子区域与str2从索引位置0开始3个字符的子区域是否相等，不忽略大小写
        System.out.println(str1.regionMatches(false, 2, str2, 0, 3));
    }

    @Test
    public void testStartsWith() {
        String str = "123456";
        // 从位置0开始判断当前字符串是否以“12”开头
        System.out.println(str.startsWith("12", 0));
        // 从位置1开始判断当前字符串是否以“12”开头
        System.out.println(str.startsWith("12", 1));
        // 从位置0开始判断当前字符串是否以“23”开头
        System.out.println(str.startsWith("23", 0));
        // 从位置1开始判断当前字符串是否以“23”开头
        System.out.println(str.startsWith("23", 1));
    }

    @Test
    public void testEndsWith() {
        String str = "123456";
        // 此处相当于 str.startsWith("56", 4)
        System.out.println(str.endsWith("56"));
        System.out.println(str.endsWith("5"));
    }

    @Test
    public void testHashCode() {
        String str = "123456";
        System.out.println(str.hashCode());
        int h = 0;
        for (int i = 1; i < 7; i++) {
            int x = i + Integer.valueOf('0');
            h = h * 31 + Integer.valueOf(x);
        }
        System.out.println(h);
    }


    @Test
    public void testIndexOf() {
        String str = "abcdef";
        System.out.println(str.indexOf(Integer.valueOf('c')));
        System.out.println(str.indexOf(Integer.valueOf('c'), 1));
        System.out.println(str.indexOf(Integer.valueOf('c'), 3));
    }

    @Test
    public void testLastIndexOf() {
        String str = "abcdefc";
        // 不指定fromIndex时，默认取当前字符串的最后一个索引（即字符串长度 - 1），此处为6，指截止到索引位置6之前的字符均会被检查
        System.out.println(str.lastIndexOf(Integer.valueOf('c')));
        // 仅检查字符串前2个字符
        System.out.println(str.lastIndexOf(Integer.valueOf('c'), 1));
        // 仅检查字符串前3个字符
        System.out.println(str.lastIndexOf(Integer.valueOf('c'), 2));
        // 仅检查字符串前4个字符
        System.out.println(str.lastIndexOf(Integer.valueOf('c'), 3));
    }

    @Test
    public void testIndexOfForString() {
        String str = "abcdefc";
        System.out.println(str.indexOf("c"));
        System.out.println(str.indexOf("c", 2));
        System.out.println(str.indexOf("c", 3));
    }

    @Test
    public void testLastIndexOfForString() {
        String str = "abcdefc";
        // 不指定fromIndex时，默认取当前字符串的最后一个索引（即字符串长度 - 1），此处为6，指截止到索引位置6之前的字符均会被检查
        System.out.println(str.lastIndexOf("c"));
        // 仅检查字符串前2个字符
        System.out.println(str.lastIndexOf("c", 1));
        // 仅检查字符串前3个字符
        System.out.println(str.lastIndexOf("c", 2));
        // 仅检查字符串前4个字符
        System.out.println(str.lastIndexOf("c", 3));
    }

    @Test
    public void testSubstring() {
        String str = "abcdef";
        System.out.println("从索引位置0开始截取：" + str.substring(0));
        System.out.println("从索引位置5开始截取：" + str.substring(5));
        System.out.println("从索引位置6开始截取：" + str.substring(6));
        System.out.println(str);
        System.out.println("截取索引位置1~3：" + str.substring(1, 3));
        System.out.println("截取索引位置2~5：" + str.substring(2, 5));
    }
}
