<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/5/5
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr><td>书名</td><td>销售量</td></tr>
    <c:forEach items="${sessionScope.bookSaledResult}" var="book">
        <tr>
            <td>
                ${book.bookName}
            </td>
            <td>
                ${book.bookNum}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
