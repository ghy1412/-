package com.bit;

import com.bit.aop.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest {
    AnnotationConfigApplicationContext ann = null;
    @Before
    public void before(){
        ann = new AnnotationConfigApplicationContext(User.class);
    }
    @Test
    public void aspectTest(){
        User user = (User) ann.getBean("user1");
        user.print();
    }
}
