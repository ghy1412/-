package com.ming.mapper;

import com.ming.bz.UserBz;
import com.ming.po.User;
import com.ming.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<UserEx> querUserByZH(UserBz userBz) throws Exception;

    public int queryUserByCount(UserBz userBz) throws Exception;

    public List<UserEx> queryUserByAlias() throws Exception;

    public List<User> queryUserByAlias2() throws Exception;


}
