package com.optimize;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        Produc  produc=  (Produc)ap.getBean("proxyId");
        produc.produce();
        produc.sell();
    }
}
