package com.bit;

import com.sun.jndi.cosnaming.IiopUrl;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
    public static void main1(String[] args) {
        Student per = new Student("张三",10);
        MyAddress address = new MyAddress("上海");
        Action action = new PlayBall();
        per.doSomething(address,action);
    }
}

class Person1{
    public String name;
    public Integer age;
    public Person1(){}

    public Person1(String name, Integer age) {
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
}

class Student extends Person1{
    public Student(String name, Integer age){
        super(name,age);
    }
    public void doSomething(MyAddress address, Action action){
        System.out.println(name+"zai"+age+"zuo");
        action.act(address);
    }
}
class MyAddress{
    public String getName() {
        return name;
    }

    String name;
    public MyAddress(String name){
        this.name = name;
    }

}
interface Action{
    void act(MyAddress address);
}

class PlayBall implements Action{
    @Override
    public void act(MyAddress address) {
        System.out.println(address.getName() + "打球");
    }
}