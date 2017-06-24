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
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
<h2>填写收货人信息</h2>
<form action="firm_order" method="post">
    <div class="row">
        <label>姓名:</label>
        <input type="text" name="name"/>
    </div>
    <div class="row">
        <label>电话:</label>
        <input type="text" name="phone"/>
    </div>
    <div class="row">
        <label>邮编:</label>
        <input type="text" name="mail"/>
    </div>
    <div class="row">
        <label>地址:</label>
        <input type="text" name="address"/>
    </div>
        <input type="submit" value="提交"/>
</form>
</body>
</html>
