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
    <script src="js/hide.js"></script>
</head>
<body>
    <h1>剩余量</h1>

    <%--<input type="text" name="book_name" id="book_name"/>--%>
    <%--<input type="button" value="确定" onclick="onClick('book_rest')">--%>
    <%----%>
    <form action="book_rest" method="post">
        <input type="text" name="book_name" id="book_name"/>
        <input type="submit" value="submit"/>
    </form>

    <table>
        <thead>
            <tr>
                <td>书名</td><td>剩余量</td><td>操作</td>
            </tr>
        </thead>
        <%--<tr>--%>
            <%--<td><c:out value="${sessionScope.bookRestResult.bookName}"/></td>--%>
            <%--<td><c:out value="${sessionScope.bookRestResult.bookNum}"/></td>--%>
        <%--</tr>--%>
        <c:forEach items="${requestScope.allRestResult}" var="book">
            <tr>
                <td>
                        ${book.bookName}
                </td>
                <td>
                        ${book.bookNum}
                </td>
                <td>
                    <a onclick="display('${book.id}')">添加库存</a><br>
                    <div id="${book.id}" hidden="display">
                        <form action="add_book_num" method="post">
                            数量<input type="text" width="10px" name="number"/>
                                <input type="hidden" value="${book.id}" name="id"/>
                                <input type="submit" value="提交">
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
