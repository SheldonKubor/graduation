<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:36
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
    <h1>销售量</h1>


    <table>
        <thead><tr><td>书名</td><td>销售量</td></tr></thead>
        <c:forEach items="${requestScope.bookSaledResult}" var="book">
            <tr>
                <td>
                        ${book.bookName}
                </td>
                <td>
                        ${book.saledNum}
                </td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
