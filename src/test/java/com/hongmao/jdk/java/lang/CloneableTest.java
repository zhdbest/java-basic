package com.hongmao.jdk.java.lang;

import org.junit.Test;

/**
 * {@link Cloneable}测试类
 * @author zhaohaodong
 * @version 1.0. Added Time:2021/3/16 8:38 上午
 */
public class CloneableTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        Student student = new Student("张三", 18);
        // 报错：CloneNotSupportedException，因为Student未实现Cloneable接口
        Student newStudent = student.clone();
        System.out.println(newStudent);
        System.out.println(student);
    }

    @Test
    public void testClone2() throws CloneNotSupportedException {
        Teacher teacher = new Teacher("李四", 19);
        Teacher newTeacher = teacher.clone();
        System.out.println(teacher);
        System.out.println(newTeacher);
    }
}


class Student {
    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Teacher implements Cloneable {
    private String name;

    private Integer age;

    public Teacher(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        return (Teacher) super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}