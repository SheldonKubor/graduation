<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/5/20
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写订单</title>
</head>
<body>
<h2>填写收货人信息</h2>
<form action="add_order" method="post">
    姓名<input type="text" name="name"/>
    电话<input type="text" name="phone"/>
    邮编<input type="text" name="mail"/>
    地址<input type="text" name="address"/>
        <input type="submit" value="提交"/>
</form>
</body>
</html>
