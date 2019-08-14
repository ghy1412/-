package com.cn.mapper;

import com.cn.bz.UserBz;
import com.cn.po.User;
import com.cn.po.UserEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<UserEx> findAll();

    List<UserEx> queryForUser();

    List<UserEx> queryUserByAlias();

    List<User>  queryUserToItems();

    List<User> queryUserByNameAndSex(User user);

    List<User> queryUserForId(List<Integer> list);

    int insertUser(@Param("list") List<User> user);
}
