package com.cn.spring_demo1;

import com.cn.spring_demo1.po.User;
import com.cn.spring_demo1.service.UserService;
import com.cn.spring_demo1.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemo1ApplicationTests {

    @Autowired
    private User user;

    @Autowired
    private UserServiceImpl userService;
  @Autowired
  ApplicationContext context;
    @Test
    public void contextLoads() {
        System.out.println(user);
    }

    @Test
    public void testUserServiceImpl() {
/*        UserService userService = (UserService) context.getBean("userService");
        userService.addUser();*/

    userService.addUser();
    }

}
