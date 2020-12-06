package com.hongmao.lang.reflect.person.service;

import com.hongmao.lang.reflect.person.model.Student;
import com.hongmao.lang.reflect.person.model.Teacher;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设有两张表：Student、Teacher，他们中都有字段addedBy，此字段存的是新增人的id
 * 表中并未存新增人的name，但页面需要展示新增人的name。此处用反射来实现一个公共方法给数据赋值新增人名称。
 * 对于这个需求而言，这并不是好的实现，只是学习反射的一个demo。
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/17 19:57
 */
public class PersonService {
    public static void main(String[] args) {
        List<Student> studentList = getStudentList();
        fillOperator(studentList);
        for (Student student : studentList) {
            System.out.println(student.getAddedByName());
        }

        List<Teacher> teacherList = getTeacherList();
        fillOperator(teacherList);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getAddedByName());
        }
    }

    /**
     * 模拟查询学生数据列表
     * @return 学生数据列表
     */
    private static List<Student> getStudentList() {
        Student student = new Student();
        student.setAddedBy(1001L);
        return Lists.newArrayList(student);
    }

    /**
     * 模拟查询教师数据列表
     * @return 教师数据列表
     */
    private static List<Teacher> getTeacherList() {
        Teacher teacher = new Teacher();
        teacher.setAddedBy(1002L);
        return Lists.newArrayList(teacher);
    }

    /**
     * 赋值新增人信息
     * @param source 数据列表
     * @param <S> 数据的类型
     */
    private static <S> void fillOperator(List<S> source) {
        if (CollectionUtils.isEmpty(source)) {
            return;
        }

        // 提取操作人id
        List<Long> operatorIdList = new ArrayList<Long>();
        try {
            Class<?> cls = source.get(0).getClass();
            Method getMethod = cls.getMethod("getAddedBy");
            Method setMethod = cls.getMethod("setAddedByName", String.class);
            for (S s : source) {
                operatorIdList.add((Long) getMethod.invoke(s));
            }
            // 获取操作人Map
            Map<Long, String> map = getOperatorMap(operatorIdList);
            // 循环设置
            for (S s : source) {
                Long operatorId = (Long) getMethod.invoke(s);
                String operatorName = map.get(operatorId);
                if (StringUtils.isNotBlank(operatorName)) {
                    setMethod.invoke(s, operatorName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟调用外部服务拿到操作人相关信息
     * @param idList 操作人id集合
     * @return 模拟操作人数据集合
     */
    private static Map<Long, String> getOperatorMap(List<Long> idList) {
        // 此处为demo之便，直接返回Map
        Map<Long, String> map = new HashMap<Long, String>(2);
        map.put(1001L, "虹猫");
        map.put(1002L, "蓝兔");
        return map;
    }
}
