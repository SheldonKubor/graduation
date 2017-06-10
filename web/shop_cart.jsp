<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/4/21
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车详情</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
<div><form action="settlement">
    <table>
        <thead><tr>
            <td></td><td>书名</td><td>数量</td><td>单价</td><td>操作</td>
        </tr></thead>

        <c:forEach items="${requestScope.shopCart}" var="shopCart">
            <tr>
                <td>
                    <input type="checkbox" name="checked_book" value="${shopCart.bookname}"/>
                </td>
                <td>
                        ${shopCart.bookname}
                </td>
                <td>
                        ${shopCart.number}
                </td>
                <td>
                        ${shopCart.price}
                </td>
                <td>
                    <a href="delete_shopcart?id=${shopCart.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <p>总价：${sessionScope.allPrice}</p>
    <p><input type="submit" value="去结算"/></p>
</form></div>
<br>

</body>
</html>
