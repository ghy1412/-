package com.ming.springboot.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/*
    applicationContext.xml

*   <bean id="employee" class="com.ming.po.Employee">
        <property name="empName" value="arvin"/>
    </bean>
* */
@Component
//@ConfigurationProperties(prefix = "myemp")
public class Employee {

    /**
     *   <property name="empName" value="arvin"/>
     */
    @Value("${myemp.emp-name}")
    private String empName;

    private int empAge;

    @Value("${myemp.boss}")
    private boolean boss;

    private List list;

    private Map map;

    private User user;

    public Employee(){

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", boss=" + boss +
                ", list=" + list +
                ", map=" + map +
                ", user=" + user +
                '}';
    }
}
