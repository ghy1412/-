package com.bite.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("key", "sb");
        response.addCookie(cookie);
        response.getWriter().write("cookie已经添加");
        //下一次访问
        Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies
             ) {
            System.out.println("值"+c.getName()+"  "+c.getValue());
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

}
