package com.bit.ssh;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration(value = "sss")
@ComponentScan(value = "com.bit.ssh")
@EnableAspectJAutoProxy
public class Student {

    public void sayHello(){
        System.out.println("叔叔好! ");
    }

    public void goodbye(){
        System.out.println("去你妹的! 憨批! 瓜怂!");
    }
}
