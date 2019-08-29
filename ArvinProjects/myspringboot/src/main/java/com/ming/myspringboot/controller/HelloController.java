package com.ming.myspringboot.controller;


import com.ming.myspringboot.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String testControllerMethod(Map<String,Object> myMap){
        myMap.put("testKey","this is Arvin.");
        return "test";
    }

    @RequestMapping("/listMethod")
    public String listMethod(Map<String,Object> myMap){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("arvin01","xian"));
        userList.add(new User("arvin02","xian"));
        userList.add(new User("arvin03","xian"));
        userList.add(new User("arvin04","xian"));
        userList.add(new User("arvin05","xian"));

        myMap.put("userListKey",userList);

        myMap.put("myKey",1);
        myMap.put("numberValueKey",1);


        return "test";
    }

}
