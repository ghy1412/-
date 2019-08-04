<%@ page import="com.wang.entity.User1" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
JSTL  java 标准 标签 库
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>userid</td>
        <td>username</td>
        <td>password</td>
    </tr>
<%
    List<User1> list = (List<User1>)request.getSession().getAttribute("userListKey");
for (Iterator iterator = list.iterator();iterator.hasNext();){
    User1 user1 = (User1) iterator.next();
 %>
    <tr>
        <td>
            <%=user1.getUserid()%>
        </td>
        <td>
            <%=user1.getUsername()%>
        </td>
        <td>
            <%=user1.getPassword()%>
        </td>
    </tr>

<%}%>
</table>
</body>
</html>
