<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/4/21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索结果</title>
    <link rel="stylesheet" href="css/searchResultCss.css" type="text/css"/>
</head>
<body>
    <jsp:include page="index_top.jsp"/>
    <div id="search_center">
        <div id="order">
            <ul class="order_item">
                <%--<li>综合排序</li>--%>
                <%--<li>按价格排序</li>--%>
                <%--<li>按销量排序</li>--%>
            </ul>
        </div>
        <div class="result_div">
            <ul class="result_item">
                <c:forEach items="${requestScope.searchResult}" var="book">
                    <li>
                        <a href="bookinfo?bookname=${book.bookName}" class="pic" target="_blank"><img src="${book.imgUrl}"/></a>
                        <p class="name"><a href="bookinfo?bookname=${book.bookName}">${book.bookName}</a></p>
                        <p class="jianjie">${book.content}</p>
                        <p class="price"><span>${book.outPrice}</span></p>
                        <p class="add_gouwuche">
                            <a class="add_product" href="add_shopcart?bookname=${book.bookName}&price=${book.outPrice}&num=1">加入购物车</a>
                        </p>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <script>

        function loginCheck() {


            var username="<%=session.getAttribute("user")%>";

            if(username=="null"){
                var obj=document.getElementById("login");
                obj.innerHTML="登陆";
            }else{

                var obj=document.getElementById("login");
                obj.innerHTML="欢迎您，${sessionScope.user}|注销";
                obj.setAttribute("href","logout")
            }
        }
        window.onload=loginCheck();
    </script>
</body>
</html>
