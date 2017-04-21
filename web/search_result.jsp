<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/4/21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/searchResultCss.css" type="text/css"/>
</head>
<body>
    <div id="hd">
        <div class="tools">
            <div class="top_link">
                <ul class="tools_list">
                    <li><a href="login.jsp">登录</a>&nbsp;&nbsp;</li>
                    <li><a href="#">个人中心</a>&nbsp;&nbsp;</li>
                    <li><a href="#" style="border: none">我的购物车</a></li>
                </ul>
            </div>
        </div>
        <div class="search_box">
            <div class="logo">
                <img src="http://img63.ddimg.cn/upload_img/00444/tupian/doodle.gif">
            </div>
            <div class="search">
                <form action="" name="searchform" id="form_search_new" method="GET">
                    <input type="text" placeholder="请输入图书分类，作者或书名" class="search_text"/>

                    <input type="button" class="search_button" onclick=""/>
                </form>
            </div>
        </div>
    </div>
    <div id="search_center">
        <div id="order">
            <ul class="order_item">
                <li>综合排序</li>
                <li>按价格排序</li>
                <li>按销量排序</li>
            </ul>
        </div>
        <div class="result_div">
            <ul class="result_item">
                <li>
                    <a href="#" class="pic" target="_blank"><img src="images/1.jpg"/></a>
                    <p class="name"><a>1213213</a></p>
                    <p class="jianjie">asdfafasfsdfasfaf</p>
                    <p class="price"><span>$45</span></p>
                    <p class="add_gouwuche">
                        <a class="add_product" href="">加入购物车</a>
                    </p>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>
