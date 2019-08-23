package com.bit.itemslist.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.sql.ast.expr.SQLCaseStatement;
import com.bit.itemslist.po.Items;
import com.bit.itemslist.utils.JdbcUtils;
import com.bit.itemslist.utils.LoadProperties;
import jdk.internal.dynalink.beans.StaticClass;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Component
public class ItemsDao{

private Connection connection;

    public List<Items> queryItems(){

        ArrayList<Items> list = new ArrayList<>();
        try {

            connection = new JdbcUtils().getConnection();
            String sql = "select * from items";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                items.setPrice(resultSet.getFloat("price"));
                items.setDetail(resultSet.getString("detail"));
                items.setCreatetime(resultSet.getDate("createtime"));
                list.add(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }




  /*  private static DruidDataSource DATASOURCE;
    private  Connection connection;
    //1.加载数据源
    static {
        Properties properties = LoadProperties.loadProperties("classpath: db.properties");

        System.out.println(properties);
        try {
          DATASOURCE =   (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //2.获取连接
    public DruidPooledConnection getConnection() throws SQLException {
      return (DruidPooledConnection) DATASOURCE.getPooledConnection();
    }

    //3. 查询

    public List<Items> queryItems(){

        ArrayList<Items> list = new ArrayList<>();
        try {
            connection = this.getConnection();
            String sql = "select * from items";
            PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                items.setPrice(resultSet.getFloat("price"));
                items.setDetail(resultSet.getString("datail"));
                items.setCreatetime(resultSet.getDate("createtime"));
                list.add(items);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

    // 4.关闭资源
    protected void closeResources(Connection conn,
                                  Statement statement) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void closeResources(Connection conn,
                                  Statement statement,
                                  ResultSet resultSet) {
        closeResources(conn,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }*/
}
