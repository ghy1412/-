/*
package com.cn.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterServlet",
urlPatterns = "*.jsp")
public class FilterServlet implements Filter {
    public void destroy() {
        System.out.println("你要被销毁了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
       int index = requestURI.lastIndexOf("/");
       String endWith = requestURI.substring(index+1);
      if ("ha.jsp".equals(endWith)){
           response.sendRedirect("demo.jsp");
       } else {
          chain.doFilter(req, resp);
      }

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化去");
    }

}
*/
