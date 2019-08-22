package com.cn.mapper;

import com.cn.po.User;

public interface UserMapper {
    User queryUserById(int userId) throws Exception;
    void modifyUserById(User user) throws Exception;
}
