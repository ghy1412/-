package com.bit.tools;

import java.sql.*;

public class DbManager {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test1";
    private String username = "root";
    private String password = "0226";

   public Connection conn = null;
   public Statement state = null;
   public ResultSet rs = null;

   public DbManager(){

   }

   //get db connection
    public Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("loding diver prosperity.......");
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet querDBFunction(String strSql){
        try {
           conn = this.getConnection();
           state = conn.createStatement();
           rs = state.executeQuery(strSql);
           return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeDb(){
        try {
            if (rs != null) rs.close();
            if (state != null) state.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
