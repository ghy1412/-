/*
package com.spring.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

public class CreateDynamic implements InvocationHandler {
    private Object targetobj;

    public CreateDynamic(Object obj){
        this.targetobj = obj;
    }

    public Object newDynamicObjectInstance(){
     return  Proxy.newProxyInstance(this.targetobj.getClass().getClassLoader(),
                                this.targetobj.getClass().getInterfaces(),
                                    this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
            try {
                securityCheck();
                obj =  method.invoke(this.targetobj,args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
    private void securityCheck(){
        System.out.println("安全检查");
    }
}
*/
