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
    <style>
        .layout-side{
            background-color: #f2f2f2;
            color: #333;
            z-index: 999;
            border-right: 1px solid #ddd;
        }
        .menu-item-child {
            display: none;
            list-style: none;
            padding: 0;
            margin: 0;
            padding-left: 10px;
        }
        body{
            margin: 0;
        }
    </style>
</head>
<body>
    <div style="background-color: #f2f2f2;">
        <div>
            <div id="book" onclick="display('book_manager')">
                <span>图书管理</span>
            </div>
            <div id="book_manager">
                <ul>
                    &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="book" target="rightFrame">图书管理</a></li>
                    &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="classify" target="rightFrame">分类管理</a></li>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;<li><a href="add_book.jsp" target="rightFrame">新增图书信息</a></li>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;<li><a href="add_book.jsp" target="rightFrame">添加图书库存</a></li>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;<li><a href="delete_book.jsp" target="rightFrame">删除图书</a></li>--%>
                    <%--&nbsp;&nbsp;&nbsp;&nbsp;<li><a href="update_book.jsp" target="rightFrame">修改图书信息</a></li>--%>
                    &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="book_rest" target="rightFrame">图书剩余量</a></li>
                    &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="all_book" target="rightFrame">图书销售量</a></li>
                </ul>
            </div>
        </div>
        <div>
            <div id="account" onclick="display('account_manager')">
                <span>账号管理</span>
            </div>
            <div id="account_manager">
                <ul>
                &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="change_pw.jsp" target="rightFrame">修改密码</a></li>
                &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="admin" target="rightFrame">添加管理员</a></li>
                &nbsp;&nbsp;&nbsp;&nbsp;<li><a href="cus" target="rightFrame">删除注册用户</a></li>
                <!--&nbsp;&nbsp;&nbsp;&nbsp;<li><a href="delete_admin.jsp" target="rightFrame">删除管理员</a></li>-->
                </ul>
            </div>
        </div>
    </div>
<script>
    var req=null;
    function onClick() {
        initXMLHttpRequestObj();
        send_ajax_book_rest();
    }
    function initXMLHttpRequestObj(){

        if (window.XMLHttpRequest) {
            req = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    function send_ajax_book_rest() {
        if (req) {
            req.onreadystatechange =add_admin_receiver;
            req.open("POST", "book_rest", true);
            req.setRequestHeader("Content-type","application/json");
            req.send(null);
        }
    }
    function add_admin_receiver(){
        var ready=req.readyState;
        var data=null;
        if (ready==4&&req.status==200){
            data=req.responseText;
            if (data=="0") {
                alert("添加失败，请重试");
                window.location.reload();
                return;
            }
            if(data=="1"){
                alert("添加成功");
                window.location.reload();
                return;
            }

        }
    }
</script>
</body>
</html>
