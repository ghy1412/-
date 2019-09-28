package com.cn.spring_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/*
*  @SpringBootConfiguration
*             @Configuration  配置注解 相当于applicationContext.xml
*  @EnableAutoConfiguration
*             @AutoConfigurationPackage   自动扫描启动包 及其子包
*             @Import({AutoConfigurationImportSelector.class})  导致依赖配置
*  @ComponentScan   扫描组件 并注入spring容器
*
*
* */

/*@ImportResource(locations="classpath:applicationContext.xml")*/
@SpringBootApplication
public class SpringDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo1Application.class, args);
    }

}
