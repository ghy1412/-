<%--
  Created by IntelliJ IDEA.
  User: someonexmh
  Date: 2019/8/13
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <table border="1px" cellspacing="0" width="100%">
        <tr>
            <th>userId</th>
            <th>userName</th>
            <th>ubirthday</th>
            <th>userSex</th>
            <th>userAddr</th>
        </tr>
        <c:forEach items="${userListKey}" var="users">
            <tr>
                <td>${users.userId}</td>
                <td>${users.userName}</td>
                <td>${users.birthday}</td>
                <td>${users.userSex}</td>
                <td>${users.userAddr}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
