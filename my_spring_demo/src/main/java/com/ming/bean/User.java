package com.ming.bean;

public class User {
    private String userName;
    private String passWord;

    public User(){

    }

    public User(String userName, String passWord) {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
