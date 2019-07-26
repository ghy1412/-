package com.ming;

import com.ming.bean.Bean1;
import com.ming.bean3.Bean6;
import com.ming.bean3.Bean7;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest4 {
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "applicationContext-beans.xml"
        });
    }
    @Test
    public void testMethod(){
        Bean6 bean6 = (Bean6)applicationContext.getBean("bean6");
        System.out.println(bean6.getName());
        System.out.println(bean6.getAge());
        System.out.println(bean6.getPassWord());
        System.out.println("=====================");
        Bean7 bean7 = (Bean7) applicationContext.getBean("bean7");
        System.out.println(bean7.getName());
        System.out.println(bean7.getPassWord());
    }
}
