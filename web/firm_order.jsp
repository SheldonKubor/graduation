<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/6/12
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
    <div>
        <table cellpadding="0" cellspacing="0">
            <thead><tr><td>书名</td><td>数量</td></tr></thead>
            <c:forEach items="${requestScope.orderItem}" var="orderItem">
                <tr>
                    <td>
                            ${orderItem.bookname}
                    </td>
                    <td>
                            ${orderItem.number}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <label>总价：</label><span>${requestScope.order_info.price}</span>
    <div style="float: right">
        <div class="row">
            <label>收货人姓名：</label><span>${requestScope.order_info.name}</span>
        </div>
        <div class="row">
            <label>收货人电话：</label><span>${requestScope.order_info.phone}</span>
        </div>
        <div class="row">
            <label>收货人地址：</label><span>${requestScope.order_info.address}</span>
        </div>
    </div>
    <br/>
    <a href="add_order" style="float: right">支付</a>
</body>
</html>
