package com.cn;

import com.cn.bz.UserBz;
import com.cn.mapper.OrdersMapper;
import com.cn.mapper.UserMapper;
import com.cn.po.Orders;
import com.cn.po.OrdersEx;
import com.cn.po.User;
import com.cn.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class OrdersTest {

    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void testInitial(){
        InputStream in = null;
        String configFile = "sqlMapConfig.xml";

        try {
           in =  Resources.getResourceAsStream(configFile);
           sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryAllUser(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<OrdersEx> ordersExes = ordersMapper.queryOrderTOUser();
            System.out.println(ordersExes);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryOrderToUser(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
           List<Orders> ordersList= ordersMapper.queryOrderToUD();

            for (Orders orders : ordersList){
                System.out.println(orders);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryOrderToUDI(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
            List<Orders> ordersList= ordersMapper.queryOrderToUDI();

            for (Orders orders : ordersList){
                System.out.println("======");
                System.out.println(orders);
                System.out.println("======");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserToItems(){
        /*User为主表*/
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userslist = userMapper.queryUserToItems();
            for (User users : userslist){
                System.out.println("======");
                System.out.println(users);
                System.out.println("======");
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
