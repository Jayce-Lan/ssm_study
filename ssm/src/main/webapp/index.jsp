<%--
  Created by IntelliJ IDEA.
  User: Jayce
  Date: 2020-12-22
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/testGetAccountList">查询所有账户信息</a>

    <h3>测试保存</h3>
    <form action="account/testSaveAccount" method="post">
        姓名：<input type="text" name="name"/>
        <br/>
        金额：<input type="text" name="money"/>
        <br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>
