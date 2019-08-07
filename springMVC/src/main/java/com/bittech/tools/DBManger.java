package com.bittech.tools;


import com.mysql.jdbc.StatementImpl;

import java.sql.*;

public class DBManger {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test4";
    private String username = "root";
    private String password = "0226";

    private Connection conn = null;
    private Statement statement = null;
    private ResultSet rs = null;
    //获取连接
    public Connection getConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet executeQueryForUser(String str){
        try{
             conn = this.getConnection();
           statement =  conn.createStatement();
           rs = statement.executeQuery(str);
        } catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public void  close(){
        try{
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
