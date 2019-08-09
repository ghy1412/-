package com.cn;

import com.cn.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyatis {
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void testInit(){
        String sqlMapConfig = "SqlMapConfig.xml";
        InputStream in = null;

        try {
           in =  Resources.getResourceAsStream(sqlMapConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void testUser(){


        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user =  sqlSession.selectOne("test.findAll",1);
        System.out.println(user);
    }
}
