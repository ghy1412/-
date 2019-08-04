package com.bit.controll;

import com.bit.service.HandlerService;
import com.bit.vo.User1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/handlerServlet")
public class HandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //1.获取表单参数,因为没有所以不做
        //2.调用业务逻辑对象
        HandlerService handlerService = new HandlerService();
        List<User1> user1 = handlerService.querUserForService();
        request.getSession().setAttribute("userListKey",user1);
        //转发其他web组件
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
