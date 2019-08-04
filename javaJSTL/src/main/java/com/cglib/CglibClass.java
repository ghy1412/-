package com.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class CglibClass {
    public static MyASpect createMyASpect(){

       final MyASpect myASpect = new MyASpect();
       final enhanceClass enhanceClass = new enhanceClass();
        //1.核心类
      Enhancer enhancer = new Enhancer();
       //2.确定父类
      enhancer.setSuperclass(MyASpect.class);
        //3.设置回调函数.MethodInterceptor接口 等效 jdk InvocationHandler接口
       enhancer.setCallback(new MethodInterceptor() {
           @Override
           public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
              Object o1 = null;
               System.out.println("亲前");
              o1 = method.invoke(myASpect,objects);
               System.out.println("++++++后");
              return o1;
           }
       });
        //4,创建代理
        Object object = enhancer.create();

        return (MyASpect) object;
    }

    public static void main(String[] args) {
        CglibClass cglibClass = new CglibClass();
        MyASpect myASpect = cglibClass.createMyASpect();

        myASpect.print();
    }
}
