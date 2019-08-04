package com.wang.utils;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcUtils {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test1";
    private String username = "root";
    private String password = "0226";

    Connection conn = null;
    ResultSet resultSet = null;
    Statement statement = null;
    public Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("loading .....");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet  queryFunction(String sql){

        try {
            conn = this.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeAll(){
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
