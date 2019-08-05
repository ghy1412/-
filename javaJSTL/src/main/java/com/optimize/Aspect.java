package com.optimize;
//切面类

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

public class Aspect implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("前面");
        Object proceed = invocation.proceed();
        System.out.println("后面");
        return proceed;
    }
}
