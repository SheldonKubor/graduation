<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/15
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adminLeft</title>
    <script src="js/hide.js"></script>
</head>
<body bgcolor="aqua">
    <div>
        <div>
            <div id="book" onclick="display('book_manager')">
                <span>图书管理</span>
            </div>
            <div id="book_manager">
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="add_book.jsp" target="rightFrame">新增图书信息</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="add_book.jsp" target="rightFrame">添加图书库存</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="delete_book.jsp" target="rightFrame">删除图书</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="update_book.jsp" target="rightFrame">修改图书信息</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="rest_book.jsp" target="rightFrame">统计图书剩余量</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="saled_book.jsp" target="rightFrame">统计图书销售量</a><br>
            </div>
        </div>
        <div>
            <div id="account" onclick="display('account_manager')">
                <span>账号管理</span>
            </div>
            <div id="account_manager">
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="change_pw.jsp" target="rightFrame">修改密码</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="add_admin.jsp" target="rightFrame">添加管理员</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="delete_user.jsp" target="rightFrame">删除注册用户</a><br>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="delete_admin.jsp" target="rightFrame">删除管理员</a><br>
            </div>
        </div>
    </div>
</body>
</html>
