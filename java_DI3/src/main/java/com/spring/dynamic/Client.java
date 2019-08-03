package com.spring.dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
/*        UserManager userManager = new UserManagerImpl();
        CreateDynamic createDynamic = new CreateDynamic(userManager);

        UserManager manager =  (UserManager)createDynamic.newDynamicObjectInstance();
        manager.add("张三","1314");
        manager.del("张三","1234");*/
      /*  UserManagerImpl userManager = new UserManagerImpl();
        userManager.add("张三","1214");*/
        ApplicationContext applicationContext = null;

        applicationContext = new
                ClassPathXmlApplicationContext("applicationContext-AOP.xml");
        UserManager userMgr = (UserManager)applicationContext.getBean("userMgr");
        userMgr.add("张三","1234");
        userMgr.del("zhangsan","sa");
    }
}
