<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/4/21
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书详情页</title>
    <link rel="stylesheet" href="css/searchResultCss.css" type="text/css"/>
</head>
<body align="center">
<jsp:include page="index_top.jsp"/>
<div class="result_div">
    <ul class="result_item">

            <li>
                <a  class="pic" target="_blank"><img src="${requestScope.onebook.imgUrl}"/></a>
                <p class="name"><a >${requestScope.onebook.bookName}</a></p>
                <p class="jianjie">${requestScope.onebook.content}</p>
                <p class="price"><span>${requestScope.onebook.outPrice}</span></p>

                <form action="add_shopcart" method="post">
                    <input type="hidden" name="bookname" value="${requestScope.onebook.bookName}"/>
                    <input type="hidden" name="price" value="${requestScope.onebook.outPrice}"/>
                    <input type="text" name="num" />
                    <input type="submit" class="add_gouwuche" value="加入购物车">
                </form>


            </li>

    </ul>
</div>
</body>
</html>
