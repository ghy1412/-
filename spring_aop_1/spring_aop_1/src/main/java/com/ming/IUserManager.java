package com.ming;


public interface IUserManager {

    public boolean addUserInfo(String username, String password) throws Exception;

    public boolean delUserInfo(int id) throws Exception;

    public boolean modifyUserInfo(String username,String password, int id) throws Exception;

    public Object queryUserbyId(int id) throws Exception;
}
