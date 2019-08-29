package com.ming.myspringboot;

public class User {

    private String userName;

    private String userAddr;

    public User(){

    }

    public User(String userName, String userAddr) {
        this.userName = userName;
        this.userAddr = userAddr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }
}
