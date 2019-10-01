package com.cn.servlet;

import com.cn.util.Md5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filterServlet")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_check = "123";
        try {
            password  = Md5Util.encodeByMd5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(username+"  "+password);
        request.setAttribute("name",username);
        request.setAttribute("password",password);

        request.getRequestDispatcher("ha.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      this.doPost(request, response);
    }
}
