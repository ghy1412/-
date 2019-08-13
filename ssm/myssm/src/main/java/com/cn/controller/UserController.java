package com.cn.controller;

import com.cn.po.User;
import com.cn.service.UserService;
import com.cn.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/showUserList")
    public ModelAndView query(){

      List<User> userList =  userService.queryUserAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userListKey",userList);
        modelAndView.setViewName("showuser");
        return modelAndView;
    }
}
