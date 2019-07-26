package com.ming;

import com.ming.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest2 {
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-user.xml");
    }
    @Test
    public void testMethod(){
        User user = (User)applicationContext.getBean("user");
        System.out.println(user.getUserName());
        System.out.println(user.getPassWord());
    }
}
