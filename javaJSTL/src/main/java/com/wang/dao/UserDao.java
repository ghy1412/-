package com.wang.dao;

import com.wang.entity.User1;
import com.wang.utils.JdbcUtils;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User1> queryForUserDao() {
        JdbcUtils jdbcUtils = new JdbcUtils();
        List<User1> list = new ArrayList<>();

        String sql = "select * from user1";
        try {
            ResultSet resultSet = jdbcUtils.queryFunction(sql);
            while (resultSet.next()){
                User1 user1 = new User1();
                user1.setUserid(resultSet.getString("userid"));
                user1.setUsername(resultSet.getString("username"));
                user1.setPassword(resultSet.getString("password"));
                list.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
