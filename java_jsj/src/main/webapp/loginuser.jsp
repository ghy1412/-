<%--
  Created by IntelliJ IDEA.
  User: someonexmh
  Date: 2019/8/27
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <style>
        #error_id{
           color: red;
        }
    </style>
</head>
<body>

<form action="queryUser" method="post">
    Id:
    <input type="text" name="id"/><br/>
    name:
    <input type="text" name="username"/><br/>
    <input type="submit" value="提交"><span id="error_id">${error}</span>
</form>
</body>
</html>
