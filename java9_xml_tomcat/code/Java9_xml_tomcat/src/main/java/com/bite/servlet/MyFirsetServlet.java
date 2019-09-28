package com.bite.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 继续HttpServlet(HttpServlet报错：引入servlet-api.jar)
 *
 *正常：
 * http://localhost:8080/web工程名称/servlet的url-pattern
 *
 * http：//localhost:8080/hello
 *
 *
 */
public class MyFirsetServlet extends HttpServlet {

    //覆盖doGet（）:默认get方式提交

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //向浏览器输出，解决乱码
        response.setContentType("text/html;charset=utf-8");

        //向浏览器输出内容
        response.getWriter().print("hello,servlet,i'm coming...");
        response.getWriter().write("当前系统时间是:"+new Date());

    }
}
