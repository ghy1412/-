package com.bit.service;

import com.bit.biz.HandlerBiz;
import com.bit.vo.User1;

import javax.servlet.http.HttpServlet;
import java.util.List;

public class HandlerService {
    private HandlerBiz handlerBiz = new HandlerBiz();
    public List<User1> querUserForService(){
        return handlerBiz.querUserForService();
    }
}
