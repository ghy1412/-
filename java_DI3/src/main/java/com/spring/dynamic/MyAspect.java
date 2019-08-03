/*
package com.spring.dynamic;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//切面
@Aspect
public class MyAspect {
    */
/*
    * 这是一个标识,该方法不具体的被调用,仅仅是指定一个范围
    * *//*

    //@Pointcut("execution(* add*(..))")
    @Pointcut("execution(* *(..))")
    private  void allAddMethod(){ }
   // 横切关注点
    @After("allAddMethod()")
  public void securityCheck(){
      System.out.println("============安全检查============");
  }
}*/
