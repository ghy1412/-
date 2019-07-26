package com.ming;

import com.ming.bean.Bean1;
import com.ming.bean.Person;
import com.ming.bean.User;
import com.ming.bean1.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest3 {
    private AnnotationConfigApplicationContext context = null;
    @Before
    public void testInitial(){
        context = new AnnotationConfigApplicationContext(SpringConfig.class);

    }
    @Test
    public void testMethod(){
        User user = (User)context.getBean("user");
        user.setUserName("ad");
        user.setPassWord("e131");
        System.out.println(user.getUserName());
        System.out.println(user.getPassWord());
        System.out.println("===========================");
        Person person = (Person) context.getBean("person");
        person.setName("arvien");
        System.out.println(person.getName());
    }
}
