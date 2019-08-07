package com.bittech.controller;


import com.bittech.po.User;
import com.bittech.service.UserService;
import com.bittech.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    //set up relations between controller and service.
    private UserService userService = new UserServiceImpl();


    @RequestMapping(value = "/queryUser")
    public ModelAndView queryUser() throws Exception{

        //call by service layer
        List<User> userList = userService.queryUserService();


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userListKey",userList);
        modelAndView.setViewName("showuser");
        return modelAndView;
    }
}
