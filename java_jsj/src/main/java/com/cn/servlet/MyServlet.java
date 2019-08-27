package com.cn.servlet;


import com.cn.po.Order;
import com.cn.po.User;
import com.cn.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/queryUser")
public class MyServlet extends HttpServlet {
    private Service service = new Service();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String myid = request.getParameter("id");
        System.out.println(myid);

        String username = request.getParameter("username");
        System.out.println(username);
        int id = Integer.parseInt(myid);

        User user = service.queryUser(id,username);
        if (user.getUsername() != null){
            System.out.println(user);
           List<Order> ordersList=  service.querOrders(user.getId());
            request.setAttribute("ordersList",ordersList);
            request.setAttribute("username",username);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        } else {
            request.setAttribute("error","fail");
            request.getRequestDispatcher("loginuser.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

}
