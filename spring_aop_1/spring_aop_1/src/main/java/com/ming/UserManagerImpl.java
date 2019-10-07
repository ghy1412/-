package com.ming;

/**
 * TargetObject
 */
public class UserManagerImpl implements IUserManager {


    public boolean addUserInfo(String username, String password) throws Exception {
        System.out.println("=========UserManagerImpl.addUserInfo()=========");
        return false;
    }

    public boolean delUserInfo(int id) throws Exception {
        System.out.println("=========UserManagerImpl.delUserInfo()=========");
        return false;
    }

    public boolean modifyUserInfo(String username, String password, int id) throws Exception {
        System.out.println("=========UserManagerImpl.modifyUserInfo()=========");
        return false;
    }

    public Object queryUserbyId(int id) throws Exception {
        System.out.println("=========UserManagerImpl.queryUserbyId()=========");
        return null;
    }
}
