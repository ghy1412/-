package com.cn;

import com.cn.bz.UserBz;
import com.cn.mapper.UserMapper;
import com.cn.po.User;
import com.cn.po.UserEx;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

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
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            List<UserEx> all = userMapper.findAll();
            System.out.println(all);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryForUser(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            UserEx userEx = new UserEx();
            userEx.setUsername("vin");
            userEx.setSex("2");
            UserBz userBz = new UserBz();
            userBz.setUserEx(userEx);

            List<UserEx> all = userMapper.queryForUser();
            System.out.println(all);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryByAlias(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);

            List<UserEx> all = userMapper.queryUserByAlias();
            System.out.println(all);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserByNameAndSex(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("arvin");
            user.setSex("2");
            List<User> users = userMapper.queryUserByNameAndSex(user);
            System.out.println(users);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testQueryUserForId(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            List<Integer> lis = new ArrayList<>();
            lis.add(1);
            lis.add(2);
            lis.add(24);
            lis.add(25);
            List<User> users = userMapper.queryUserForId(lis);
            System.out.println(users);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void testInsertUser(){
        try{
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("sssssssss");
            user.setSex("1");
            user.setAddress("china");
            User user1 = new User();
            user1.setUsername("cccccccccccc");
            user1.setSex("1");
            user1.setAddress("china");
            List<User> list = new ArrayList<>();
            list.add(user);
            list.add(user1);
           int count = userMapper.insertUser(list);
           sqlSession.commit();
            System.out.println(count);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
