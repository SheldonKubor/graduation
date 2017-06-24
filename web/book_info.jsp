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

              <div>  <p class="name" style="margin-top: 50px;margin-left: -322px;"><a >${requestScope.onebook.bookName}</a></p>
                <p class="jianjie" style="margin-top: 50px; margin-left: -269px;"><span>${requestScope.onebook.content}</span></p>
                <p class="price" style="margin-top: 50px;margin-left: -340px;"><span>${requestScope.onebook.outPrice}</span></p></div>

                <form action="add_shopcart" method="post">
                    <input type="hidden" name="bookname" value="${requestScope.onebook.bookName}"/>
                    <input type="hidden" name="price" value="${requestScope.onebook.outPrice}"/>
                   <p  style="float: left;margin-left: 200px; margin-top: 30px;"><span>购买数量：</span><input type="text" name="num"/></p>
                    <input type="submit" class="add_gouwuche" value="加入购物车">
                </form>


            </li>

    </ul>
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
