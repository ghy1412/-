package com.ming.bean1;

import com.ming.bean.Person;
import com.ming.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ming")
public class SpringConfig {
    /*<bean id = "user" class = ".. ..">*/
    @Bean(name = "user")
    public User user(){
     User user = new User();
        return user;
    }
    @Bean(name = "person")
    public Person person(){
        Person person = new Person();
        return person;
    }

}
