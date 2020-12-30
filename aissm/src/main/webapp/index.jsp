<%--
  Created by IntelliJ IDEA.
  User: 小小帕金森
  Date: 2020-12-28
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="account">
        ${account.id}--${account.name}--${account.money}
    </c:forEach>
</body>
</html>
