<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/6/3
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/indexCss.css" type="text/css"/>
</head>
<body>
<div id="hd">
    <div class="tools">
        <div class="top_link">
            <ul class="tools_list">
                <li><a href="login.jsp" id="login">登录</a>&nbsp;&nbsp;</li>
                <%--<li><a href="personal_info.jsp" target="_blank">个人中心</a>&nbsp;&nbsp;</li>--%>
                <li><a href="my_shopcart" target="_blank">我的购物车</a></li>
            </ul>
        </div>
    </div>
    <div class="search_box">
        <div class="logo">
            <img src="images/dangdang.gif">
        </div>
        <div class="search">
            <form action="search_book" name="searchform" id="form_search_new" method="GET">
                <input type="text" placeholder="请输入图书分类，作者或书名" class="search_text" name="search_info"/>

                <input type="submit" class="search_button" value=""/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
