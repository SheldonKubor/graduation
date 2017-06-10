<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:41
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
    <h1>add admin</h1>
    <button onclick="display('add_admin')">添加管理员</button>
    <%--<button onclick="display('delete_admin')">删除管理员</button>--%>
    <div id="add_admin">
        <div class="row">
            <label>管理员账号</label>
            <input type="text" name="admin_account" id="add_admin_account"/>
        </div>
        <div class="row">
            <label >  管理员密码</label>
            <input type="password" name="admin_pw" id="add_admin_pw"/>
        </div>
        <div class="row">
            <label>请确认密码</label>
            <input type="password" name="qr_admin_pw"/>
        </div>
        <input type="button" class="btn3" value="确定" onclick="onClick('add_admin')"/>
    </div>
    <%--<div id="delete_admin">--%>
        <%--请输入要删除管理员的账号<input type="text" name="del_admin" id="del_admin"/>--%>
        <%--请输入要删除管理员的密码<input type="password" name="del_admin_pw" id="del_admin_pw"/>--%>
        <%--<input type="button" value="确定" onclick="onDelClick('delete_admin')"/>--%>
    <%--</div>--%>
    <div>
        <table cellpadding="0" cellspacing="0">
            <thead><tr><td>序号</td><td>用户名</td><td>操作</td></tr></thead>
            <c:forEach items="${requestScope.allAdmin}" var="admin">
                <tr>
                    <td>
                            ${admin.id}
                    </td>
                    <td>
                            ${admin.username}
                    </td>
                    <td>
                        <a href="delete_admin?name=${admin.username}" onclick="reLoad()">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        var req=null;
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_add_admin(url);
        }
        function initXMLHttpRequestObj(){

            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_add_admin(url) {
            var username=document.getElementById("add_admin_account").value;
            var password=document.getElementById("add_admin_pw").value;

            if (req) {
                req.onreadystatechange =add_admin_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
                var data={"username":username,"password":password};
                req.send(JSON.stringify(data));
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
