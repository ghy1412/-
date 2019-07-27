package com.bite.servetrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 * user-agent:浏览器的类型
 */
public class RequetDemo2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取user-agent请求头
      String userAgent =   request.getHeader("user-agent") ;
        System.out.println(userAgent);
//        System.out.println(value);
        //Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
        // Chrome/72.0.3626.119 Safari/537.36
        //谷歌浏览器:Chrome
        //火狐浏览器：firefox
        //IE浏览器：Trident
        //判断使用的浏览器类型
        if(userAgent.contains("Chrome")){
            System.out.println("您当前使用的是谷歌浏览器");
        }else if(userAgent.contains("firefox")){
            System.out.println("您当前使用的是火狐浏览器");
        }else if(userAgent.contains("Trident")){
            System.out.println("您当前使用的是IE浏览器");
        }else{
            System.out.println("当前浏览器不能识别！！");
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
