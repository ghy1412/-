package com.spring.dynamic;

public class UserManagerImpl implements UserManager{
    @Override
    public void add(String name, String password) {
        System.out.println("添加 姓名 :"+ name + "密码+ " + password);
    }

    @Override
    public void del(String name, String password) {
        System.out.println("删除 姓名 :"+ name + "密码+ " + password);
    }
}
