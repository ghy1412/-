package com.cn.spring_demo1.service;


import org.springframework.stereotype.Service;

/*@Service 这是Sprig的方式 不是Springboot的方式*/
public class UserServiceImpl implements  UserService {
    @Override
    public void addUser() {
        System.out.println("haha**********这是service方法**************");
    }
}
