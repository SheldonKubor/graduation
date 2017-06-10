<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/6/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/hide.js"></script>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
    <button onclick="display('add_book')">新增图书</button><br>
    <div id="add_book">
        <form action="add_book" method="post" enctype="multipart/form-data">
            <div class="row">
                <label>书名:</label>
                <input type="text" name="book_name" id="add_book_name" placeholder="请输入书名称"/>
            </div>
            <div class="row">
                <label>作者:</label>
                <input type="text" name="author" id="add_book_author" placeholder="作者名称"/>
            </div>
            <%--<div class="row">--%>
                <%--<label>类别:</label>--%>
                <%--<input type="text" name="classify" id="add_book_classify" placeholder="类别..."/>--%>
            <%--</div>--%>
            <div class="row">
                <label>类别:</label>
                <select name="classify">
                    <c:forEach items="${requestScope.allClassify}" var="classify">
                        <option value="${classify.name}">${classify.name}</option>
                    </c:forEach>
                </select>
            </div>
           
            <div class="row">
                <label>进价:</label>
                <input type="text" name="in_price" id="add_book_in_price" placeholder="进价..."/>
            </div>
            <div class="row">
                <label>售价:</label>
                <input type="text" name="sale_price" id="add_book_sale_price" placeholder="售价..."/>
            </div>
            <div class="row"> 
                <label>图片:</label>
                <input class="" style="border:none" type="file" name="pic" id="add_book_pic"  />
            </div>
             <div class="row">
                <label class="details">简介:</label>
                <!--<input type="text" name="content" id="add_book_content"/>-->
                <textarea class="detailsR" name="content" rows="4" cols="" id="add_book_content" placeholder="简介信息"></textarea>
            </div>
            <input class="btn" type="submit"/>
        </form>
    </div>
    <div>
        <table cellpadding="0" cellspacing="0">
            <thead><tr><td>书名</td><td>作者</td><td>类别</td><td>操作</td></tr></thead>
            <c:forEach items="${sessionScope.book}" var="book">
                <tr>
                    <td>
                            ${book.bookName}
                    </td>
                    <td>
                            ${book.author}
                    </td>
                    <td>
                            ${book.classify}
                    </td>
                    <td>
                        <a href="book_id?id=${book.id}">修改</a>
                        <a href="delete_book?name=${book.bookName}" onclick="reLoad()">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script>
        function reLoad() {
            alert("删除成功");
            window.location.reload();
            return;
        }
    </script>
</body>
</html>
