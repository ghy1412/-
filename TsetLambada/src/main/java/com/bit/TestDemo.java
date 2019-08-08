package com.bit;


import org.junit.jupiter.api.Test;

import java.util.Scanner;


class Student implements Cloneable{
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class TestDemo {
    @Test
    public void test(){
        Student student = new Student("张三",20);
        Student clone1 = null;
        try {
          clone1 = (Student)student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(clone1 == student); //
        System.out.println(clone1.getAge());
        System.out.println(clone1.getClass() == student.getClass());
    }
}
