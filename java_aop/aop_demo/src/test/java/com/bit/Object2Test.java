package com.bit;

import com.bit.aop.User;
import com.bit.ssh.Student;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Object2Test {
    AnnotationConfigApplicationContext ann = null;
    @Before
    public void before(){
        ann = new AnnotationConfigApplicationContext(Student.class);
    }
    @Test
    public void aspectTest(){
    Student student = (Student) ann.getBean("sss");
    student.sayHello();
    student.goodbye();
    }
}
