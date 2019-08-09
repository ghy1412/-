package com.bit.ssh;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Securty {
    @Pointcut(value = "execution(* say*(..))")
    public void poinCut1(){

    }
    @Pointcut(value = "execution(* g*(..))")
    public void poinCut2(){}

    @Before(value = "poinCut1()")
    public void secur1(){
        System.out.println("我要看看你个憨批问好没");
    }
    @Before(value = "poinCut2()")
    public void secur2(){
        System.out.println("你妈卖批! 你个瓜son");
    }
}
