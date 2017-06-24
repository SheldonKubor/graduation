<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/15
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin_top</title>
    <style>
        .layout-admin {
            margin: 0 auto;
            font-size: 14px;
        }
        .layout-header {
            border-bottom: 0px solid #33AECC;
            background-color: #33AECC;
        }
        .header-logo {
            margin-left: 10px;
            color: #fff;
            line-height: 45px;
            font-size: 16px;
        }
        body{
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="layout-admin">
        <header class="layout-header">
            <span class="header-logo">管理</span>
            <a href="login.jsp" target="_blank" id="login" style="float: right">登录</a>
        </header>

    </div>
<script>
    function loginCheck() {


        var username="<%=session.getAttribute("user")%>";

        if(username=="null"){
            var obj=document.getElementById("login");
            obj.innerHTML="登陆";
        }else{

            var obj=document.getElementById("login");
            obj.innerHTML="欢迎您，${sessionScope.user}|注销";
            obj.setAttribute("href","logout")
        }
    }
    window.onload=loginCheck();
</script>
</body>
</html>
