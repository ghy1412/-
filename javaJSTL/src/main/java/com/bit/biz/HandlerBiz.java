package com.bit.biz;

import com.bit.tools.DbManager;
import com.bit.vo.User1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HandlerBiz {
    public List<User1> querUserForService(){
        List<User1> user1s = new ArrayList<>();
        String strSql = "select * from user1";
        DbManager db  = new DbManager();
        ResultSet resultSet = null;

        //Connection conn = db.getConnection();
        try {
            resultSet = db.querDBFunction(strSql);
            while (resultSet.next()){
                User1 user1 = new User1();
                user1.setUserid(resultSet.getString("userid"));
                user1.setUsername(resultSet.getString("username"));
                user1.setPassword(resultSet.getString("password"));
                user1s.add(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1s;
    }
}
