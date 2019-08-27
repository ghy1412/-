package com.cn.dao;

import com.cn.po.Order;
import com.cn.po.User;
import com.cn.utils.JdbcUtils;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserDao {
    static Connection  connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    static DataSource dataSource = null;
    static {
        //获取properties文件内容
        ResourceBundle bundle = ResourceBundle.getBundle("db");// 文件名.properties
        String username = bundle.getString("jdbc.username");
        System.out.println(username+"用户名");
        String password = bundle.getString("jdbc.password");
        String url = bundle.getString("jdbc.url");
        String driverClass = bundle.getString("jdbc.driver");
        //获取DBCP数据源的实现类的对象
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl(url);
        basicDataSource.setDriverClassName(driverClass);
       //配置数据库链接的参数
        basicDataSource.setInitialSize(5);
        try {
            connection = basicDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User queryUserDao(int id, String username) {
        User user = new User();
        try {
            String sql = "select * from user where NAME = ? and id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setInt(2,id);
            resultSet  =
                    preparedStatement.executeQuery();

            while (resultSet.next()){

                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Order> queryOrdersDao(int id) {
        ArrayList<Order> ordersList = new ArrayList<>();
        String sql = "select * from orders where userid = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUser_id(resultSet.getInt("userid"));
                order.setOrdername(resultSet.getString("ordername"));
                order.setDetail(resultSet.getString("detail"));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null){
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (resultSet != null){
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return ordersList;
    }
}
