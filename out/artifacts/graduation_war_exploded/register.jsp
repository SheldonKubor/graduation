<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/6
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎注册</title>
    <link rel="stylesheet" href="css/loginCss.css" type="text/css"/>
    <script>
        function checkPw() {
            var password=document.getElementById("password").value;
            var checkPw=document.getElementById("check_pw").value;
            if (password==checkPw){
                return true;
            }else{
                alert("两次密码不匹配");
                window.location.reload();
                return false;
            }

        }
    </script>
</head>
<body>
<div class="container">
    <section>
        <div id="container_demo">
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="user_register" method="post" onsubmit="return checkPw()">
                        <h1>注册账号</h1>
                        <p>
                            <label>用户名</label>
                            <input type="text" name="username"/>
                        </p>
                        <p>
                            <label>密码</label>
                            <input type="password" name="password" id="password"/><br>
                        </p>
                        <p>
                            <label>确认密码</label>
                            <input type="password" name="check_pw" id="check_pw"/><br>
                        </p>
                        <p class="login button">
                            <input type="submit" value="注册"/>
                        </p>

                    </form>
                </div>
            </div>
        </div>
    </section>
</div>


    <!--
    <form action="user_register" method="post">
        用户账号<input type="text" name="username"/><br>
        用户密码<input type="password" name="password"/><br>
        确认密码<input type="password" name="qr_password"/><br>
                <input type="submit" name="submit" value="注册"/>
                <input type="reset" name="reset" value="重置"/>
    </form>
    -->
</body>
</html>
