package com.ming.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootConfiguration
 *      @Configuration : 使用该注解，表明该类是一个spring配置类，相当于applicationContext.xml
 * @EnableAutoConfiguration
 *      @AutoConfigurationPackage : 自动扫描springbootapplication所在的包以及其下的子包
 *      @Import({AutoConfigurationImportSelector.class}) : 通过spring.factors文件自动加载很多的配置
 * @ComponentScan : 代表将该组件标识的类纳入spring框架的管理之中
 */
@SpringBootApplication
public class MyBootRun {
    public static void main(String[] args) {
        SpringApplication.run(MyBootRun.class,args);
    }
}
