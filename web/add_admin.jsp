<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>add admin</h1>
    <form action="add_admin" method="post">
        管理员账号<input type="text" name="admin_account"/><br>
        管理员密码<input type="password" name="admin_pw"/><br>
        请确认密码<input type="password" name="qr_admin_pw"/><br>
        <input type="submit" value="提交"/>
        <input type="reset" value="重置"/>
    </form>
</body>
</html>
