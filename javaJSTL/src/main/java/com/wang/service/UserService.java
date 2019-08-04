package com.wang.service;

import com.wang.dao.UserDao;
import com.wang.entity.User1;

import java.util.List;

public class UserService {
    public List<User1> queryForUser() {
        UserDao userDao = new UserDao();
       List<User1> list =  userDao.queryForUserDao();
        return list;
    }
}
