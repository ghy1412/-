<%@ page import="com.ming.vo.Items" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>ShowItemsPageInformation</title>
</head>
<body>
    <table border="1" width="100%" align="center">
        <tr>
            <th>ItemsID</th>
            <th>ItemsName</th>
            <th>ItemsPrice</th>
        </tr>

        <c:forEach items="${itemsListKey}" var="myItems">
            <tr>
                <td>${myItems.itemsId}</td>
                <td>${myItems.itemsName}</td>
                <td>${myItems.itemsPrice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
