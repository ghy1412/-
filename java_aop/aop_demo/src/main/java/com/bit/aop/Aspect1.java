package com.bit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Date;
@Component
@Aspect
public class Aspect1 {
    public Aspect1() {
    }

    @Pointcut("execution(* com.bit.aop.User.*(..))" )
    public void point(){}

    @Before("point()")
    public void security(){
        System.out.println("查房啦!!!!!!!!!!!!");
    }
}
