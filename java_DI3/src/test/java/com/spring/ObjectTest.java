package com.spring;

import com.spring.bean.Bean1;
import com.spring.bean.DateC;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest {
    private ApplicationContext context = null;
    @Before
    public void testInit(){
        context = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
    }
    @Test
    public void testFunction(){
        Bean1 bean1 = (Bean1)context.getBean("bean1");
        System.out.println(bean1.getAge());
        System.out.println(bean1.getName());
        System.out.println(bean1.getListValue());
        System.out.println(bean1.getMapValue());

       DateC dateC = (DateC)context.getBean("dateC");
        System.out.println( dateC.getDate());
    }
}
