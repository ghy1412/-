<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>modALlItems</title>
</head>
<body>

<form action="queryItems" name="userinfoForm" method="post">
    商品列表
    <table width="100%" border="1px" cellspacing="0px">
        <tr>
            <td></td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
        </tr>
        <c:forEach items="${itemsList}" var="items" varStatus="status">
            <tr>
                <td><input type="hidden" name="itemsCustomList[${status.index}].id" value="${items.id}"/></td>
                <td><input type="text" name="itemsCustomList[${status.index}].name" value="${items.name}"/></td>
                <td><input type="text" name="itemsCustomList[${status.index}].price" value="${items.price}"/></td>
                <td><input type="text" name="itemsCustomList[${status.index}].createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
                <td><textarea name="itemsCustomList[${status.index}].detail">${items.detail}</textarea></td>
            </tr>
        </c:forEach>
    </table>
    <div align="right">
        <input type="submit" value="批量提交" name="modAll">
    </div>
</form>
</body>
</html>