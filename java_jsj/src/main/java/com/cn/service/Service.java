package com.cn.service;

import com.cn.dao.UserDao;
import com.cn.po.Order;
import com.cn.po.User;

import java.util.List;

public class Service {
    private UserDao userDao = new UserDao();
    public User queryUser(int id, String username) {
       return  userDao.queryUserDao(id,username);
    }

    public List<Order> querOrders(int id) {
        return userDao.queryOrdersDao(id);
    }
}
