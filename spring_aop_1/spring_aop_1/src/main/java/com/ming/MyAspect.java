//package com.ming;
//
//import jdk.internal.instrumentation.TypeMapping;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.Bean;
//
////注解Annotation
//@Aspect
//public class MyAspect {
//
//    /**
//     * PointCut是一个范围
//     * allMethod就是一个标识，标识PointCut
//     */
//    @Pointcut("execution(* add*(..)) || execution(* del*(..))")
//    private void allMethod(){}
//
//    //横切性的关注点(方法)
//    @Before("allMethod()")
//    public void checkSecurity(){
//        System.out.println("================checkSecurity()===========");
//    }
//}
