<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>delete admin</h1>
    <form action="delete_admin" method="post">
    请输入要删除管理员的账号<input type="text" name="del_admin" id="del_admin"/>
    请输入要删除管理员的密码<input type="password" name="del_admin_pw" id="del_admin_pw"/>
                         <input type="submit" value="提交"/>
    </form>
</body>
</html>
