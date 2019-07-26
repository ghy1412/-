package com.ming;

import com.ming.bean.Bean1;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectTest {
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial(){
        applicationContext = new ClassPathXmlApplicationContext(new String[]{
                "applicationContext.xml"
        });
    }
    @Test
    public void testMethod(){
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println("==============bean2==============");
        System.out.println(bean1.getBean2().getIntValue());
        System.out.println(bean1.getBean2().getStrValue());
        System.out.println("==============bean3==============");
        System.out.println("arrayValue: "+bean1.getBean3().getArrayValue()[1]);
        System.out.println("listValue: "+bean1.getBean3().getListValue());
        System.out.println("mapValue: "+bean1.getBean3().getMapValue());
        System.out.println("setValue: "+bean1.getBean3().getSetValue());
        System.out.println("==============bean4==============");
        System.out.println(bean1.getBean4().getDate());
    }
}
