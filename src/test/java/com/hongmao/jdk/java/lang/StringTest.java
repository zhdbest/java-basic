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
}
