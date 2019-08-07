package com.bittech.service;

import com.bittech.dao.UserDao;
import com.bittech.po.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();

    @Override
    public List<User> queryUserService() throws Exception {
        //call by DAO layer
        return userDao.queryUserDAO();
    }
}
