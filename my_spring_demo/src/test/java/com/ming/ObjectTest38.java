package com.ming;


import com.ming.bean.Bean1;
import com.ming.bean4.User38;
import com.ming.bean4.UserConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jws.soap.SOAPBinding;

public class ObjectTest38 {
    private AnnotationConfigApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
    }
    @Test
    public void testMethod(){
        User38 user38 = (User38) applicationContext.getBean("user38");
        System.out.println( user38.getName());
    }
}
