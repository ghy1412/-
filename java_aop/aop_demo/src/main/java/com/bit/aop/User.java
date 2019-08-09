package com.bit.aop;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@ComponentScan(value = "com.bit")
@Configuration(value = "user1")
@EnableAspectJAutoProxy
public class User {
    public User() {
    }

    public void print(){
        System.out.println("买包子");
    }
}
