package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 登陆业务
* 1)判断用户登陆是否成功
* 2)统计当前用户登陆的总次数
* */
public class LoginServlet extends HttpServlet {
    //初始化登陆的次数
    @Override
    public void init() throws ServletException {
        //获取群居管理者对象
        ServletContext servletContext =
                this.getServletContext();
        //给域中存储数据
        servletContext.setAttribute("count",0);
        System.out.println("登陆初始化成功....");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+" "+password);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }
}
