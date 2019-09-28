package com.cn.spring_demo1.serviceConfig;

import com.cn.spring_demo1.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 代表这是一个
@Configuration
public class ServiceConfig {

    @Bean("springdemo1")
    public UserServiceImpl userServiceImpl(){
        UserServiceImpl userService = new UserServiceImpl();
        return userService;
    }
}
