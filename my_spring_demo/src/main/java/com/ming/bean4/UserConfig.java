package com.ming.bean4;

import com.ming.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.ming")
@Configuration
public class UserConfig {
    @Bean(name = "user38")
    public User38 user38(){
        User38 user38 = new User38();
        user38.setAge(20);
        user38.setName("张三");
        return user38;
    }
}
