<%--
  Created by IntelliJ IDEA.
  User: Jayce
  Date: 2020-12-22
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询所有账户信息</h3>
    <c:forEach items="${accountList}" var="account">
        ${account.id}
        ${account.name}
        ${account.money}
        <br/>
    </c:forEach>
</body>
</html>
