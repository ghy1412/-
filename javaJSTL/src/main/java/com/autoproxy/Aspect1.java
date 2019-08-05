package com.autoproxy;
//切面类

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.*;

@Aspect
public class Aspect1 {
    @Pointcut("execution(* *(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void before(){
        System.out.println("方法前面代理");
    }
}

/*
public class Aspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("前面");
        Object proceed = invocation.proceed();
        System.out.println("后面");
        return proceed;
    }
}*/
