package com.hongmao.jdk.java.io;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhaohaodong
 * @version 1.0. Added Time:2021/3/23 8:29 上午
 */
public class SerializableTest {

    @Test
    public void testNoSerializableClass() throws Exception {
        Animal animal = new Animal();
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(animal);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);
    }

    @Test
    public void testSerializableClass() throws Exception {
        Dog dog = new Dog();
        dog.setWeight(BigDecimal.ONE);
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(dog);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass2() throws Exception {
        Fish fish = new Fish();
        fish.setAge(5);
        fish.setLength(7);
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(fish);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass3() throws Exception {
        Earth earth = new Earth();
        earth.setAge(1000000000000L);
        Animal animal = new Animal();
        animal.setAge(50000);
//        earth.setAnimal(animal);
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(earth);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass4() throws Exception {
        Cat cat = new Cat();
        cat.setColor("yellow");
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(cat);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass5() throws Exception {
        Fiction fiction = new Fiction();
        fiction.setProtagonist("Jack");
        // 序列化
//        FileOutputStream fileOutputStream = new FileOutputStream("fiction.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(fiction);
        // 反序列化
        FileInputStream fileInputStream = new FileInputStream("fiction.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass6() throws Exception {
        Pig pig = new Pig();
        pig.setWeight("6.8");
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(pig);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass7() throws Exception {
        People people = new People();
        people.setName("Jack");
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(people);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }

    @Test
    public void testSerializableClass8() throws Exception {
        Computer computer = new Computer();
        computer.setName("Dell");
        // 序列化
//        FileOutputStream fileOutputStream = new FileOutputStream("computer.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(computer);
        // 反序列化
        FileInputStream fileInputStream = new FileInputStream("computer.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(JSON.toJSONString(o));
    }
}

class Animal {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Dog implements Serializable {
    private BigDecimal weight;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}

class Fish extends Animal implements Serializable {
    private Integer length;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}

class Earth implements Serializable {

    private Long age;

    private Animal animal;

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}

class Cat implements Serializable {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        System.out.println("调用Cat.writeObject");
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        System.out.println("调用Cat.readObject");
    }
}

class Book implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void readObjectNoData() throws ObjectStreamException {
        System.out.println("调用Book.readObjectNoData");
    }
}

class Fiction extends Book implements Serializable {
    private String protagonist;

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }
}

class Pig implements Serializable {
    private String weight;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    private Object writeReplace() {
        System.out.println("调用Pig.writeReplace");
        Dog dog = new Dog();
        dog.setWeight(new BigDecimal("7.1"));
        return dog;
    }
}

class People implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Object readResolve() {
        System.out.println("调用People.readResolve");
        Dog dog = new Dog();
        dog.setWeight(new BigDecimal("9.9"));
        return dog;
    }
}

class Computer implements Serializable {

    private static final long serialVersionUID = -2L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
