<%--
  Created by IntelliJ IDEA.
  User: someonexmh
  Date: 2019/7/6
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<hr>
<form action="/LoginServlet" method="post">
    用户名:<input type="text" name="username"/>
    密码<input type="password" name="password"/>
    <input type="submit" />
</form>
</body>
</html>
