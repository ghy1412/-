package com.bite.servetrequest;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *请求行相关的信息
 */

//1)tomcat服务器拿到请求数据
    //2)tomcat服务器将请求数据封装到HttpServletRequest对象里
    //3)调用doGet方法将request对象传递到servlet中


/**
 * get、post获取参数通用的方法
 *  getParameter(String name) ;
 *  getParamterNames() ;Enurmation
 */

public class RequestDemo1 extends HttpServlet {

    //默认get
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //4）通过request对象获取信息

        //获取请求行的信息：
        //1.请求方式public String getMethod()
        String method = request.getMethod();
        System.out.println(method);

        //2.请求uri、URL
        //public String getRequestURI()
        //public StringBuffer getRequestURL()
        System.out.println("URI:"+request.getRequestURI());
        System.out.println("URL:"+request.getRequestURL().toString());

        //3.http协议的版本  getProtocol()
        System.out.println(request.getProtocol()) ;
        System.out.println("--------------------------");
        //get方式获取前台页面表单出来的参数：
        //http://localhost:8080/requestMethod.html?username=xxx&password
        //public String getQueryString()
      /*  String params = request.getQueryString();
        System.out.println(params);*/

      //通用方法：通过name属性值获取参数内容
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);

    }

    //post方式

    /**
     * post方式提交
     *  请求行
     *  请求头
     *
     *  实体内容
     *  username=xxx&password
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println(request.getMethod()) ;
            //Post方式获取参数数据
            //使用InputStream 读出实体内容的参数
            InputStream in = request.getInputStream();
            //一次读取一个字节数组
            byte[] buff = new byte[1024] ;
            int len = 0 ;
            while((len=in.read(buff))!=-1){
                String content = new String(buff,0,len) ;
                System.out.println(content);
        }


    }
}
