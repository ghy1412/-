package com.ming;


import com.ming.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Mybatis APIs
 * sqlSessionFactory : be used create sqlSession on Mybatis Framework
 * sqlSession : similar the connection of the Java Database
 */

public class MybatisTest {

    private SqlSessionFactory  sqlSessionFactory = null;

    @Before
    public void testInit(){
        //acquire sqlSessionFactory
        String mybatisConfigFile = "sqlMapConfig.xml";
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(mybatisConfigFile);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //execute relevant operation  CRUD
    @Test
    public void queryUserById(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("test.queryUserById",1);
            System.out.println(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
