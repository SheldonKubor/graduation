<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/23
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
    
    <div class="top" id="item4" style="background-color: brown;overflow:auto">
        <div class="container clearfix">
            <h2 style="float: left">欢迎来到XX网</h2>
            <ul style="float: right">
                <li style="float: left;list-style: none"><a href="login.jsp">登录</a>&nbsp;&nbsp;</li>
                <li style="float: left;list-style: none"><a href="#">个人中心</a>&nbsp;&nbsp;</li>
                <li style="float: left;list-style: none"><a href="#" style="border: none">我的购物车</a></li>
            </ul>
        </div>
    </div>
    <div id="index_left" style="float: left;background-color: aqua;overflow:auto;width: 15%;height:100%">
        left
    </div>
    <div id="index_center" style="overflow:auto;width: 85%;height: 100%">
        <ul>
            <li style="float: left;list-style: none"><a href="login.jsp">按价格排序</a>&nbsp;&nbsp;</li>
            <li style="float: left;list-style: none"><a href="login.jsp">按销量排序</a>&nbsp;&nbsp;</li>
        </ul>
    </div>
    <div id="index_bottom" style="background-color: blue;overflow:auto;clear: both">
        bottom
    </div>
</body>
</html>
