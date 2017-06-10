<%@ page import="com.model.BookInfoBean" %><%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/5/5
  Time: 14:08
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

    <p><c:out value="${sessionScope.result.bookName}"/></p>
    <p><c:out value="${sessionScope.result.bookNum}"/></p>


</body>
</html>
