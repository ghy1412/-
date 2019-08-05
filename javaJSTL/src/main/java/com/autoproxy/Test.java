package com.autoproxy;

import com.autoproxy.Produc2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext-auto.xml");
        Produc2  produc=  (Produc2)ap.getBean("productId1");
        produc.produce();
        produc.sell();
    }
}
