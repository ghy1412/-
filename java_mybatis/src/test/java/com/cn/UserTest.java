package com.cn;

import com.cn.mapper.OrdersMapper;
import com.cn.mapper.UserMapper;
import com.cn.po.Orders;
import com.cn.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
    private SqlSessionFactory sqlSessionFactory ;

    @Before
    public void InitTest(){
        String file = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(file);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试一级缓存
    @Test
    public void queryUserByIdTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try {
            user = mapper.queryUserById(1);
            System.out.println(user);
            System.out.println("========");
            User user1 = new User();
            user1.setUserId(1);
            user1.setUserName("xiaoming");
            mapper.modifyUserById(user1);
            sqlSession.commit();
            user =  mapper.queryUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }

    //测试二级缓存
    @Test
    public void queryUserByIdTest_level_II(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        try {

            /**
             * 二级缓存的特点：
             * 1,需要配置
             * 2,可以管理(开启，关闭，清空，使用)
             *
             */

            /**
             *  一级和二级缓存适用的场景：
             *   1， 被经常查询的数据【适用】
             *   2， 相对来说不重要的数据【适用】
             *   3， 对实时性要求不高的数据【适用】
             *   4,  在多表关联中，最好是存放单表的数据在缓存中【适用】
             *   5,
             *   6,
             * */
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            User user1 = userMapper1.queryUserById(1);
            System.out.println(user1);
            sqlSession1.close();//一级缓存关闭

            //udpate,delete,insert清空二级缓存[待定]
            UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
            User user3 = userMapper3.queryUserById(1);
            userMapper3.modifyUserById(user3);
            sqlSession3.commit();//清空二级缓存

            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
            User user2 = userMapper2.queryUserById(1);//是否发出sql语句？
            System.out.println(user2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //sqlSession.close();
        }
    }

    //延迟加载
    @Test
    public void lazyLoadingTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
         OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.lazyLoadUser();
        for (Orders orders : ordersList){
            orders.getUser().getUserName();
        }
    }
}
