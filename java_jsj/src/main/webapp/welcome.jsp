<%--
  Created by IntelliJ IDEA.
  User: someonexmh
  Date: 2019/8/27
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${username}欢迎您!登陆成功!<br/>

<table border="1px" width="100%" cellspacing="0">
    <tr>
        <th>序号</th>
        <th>userName</th>
        <th>id</th>
        <th>orderName</th>
        <th>detail</th>
    </tr>
    <c:forEach items="${ordersList}" var="order" varStatus="status">
        <tr>
            <th>${status.index}</th>
            <th>${username}</th>
            <th>${order.id}</th>
            <th>${order.ordername}</th>
            <th>${order.detail}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
