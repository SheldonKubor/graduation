<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
    <script src="js/jquery-1.11.3.js"></script>
</head>
<body>
    <h1>c修改密码</h1>
    <form>
        <div class="row">
            <label>请输入您的用户名:</label>
            <input type="text" name="username" id="username"/>
        </div>
        <div class="row">
            <label>请输入您的旧密码:</label>
            <input type="password" name="old_pw" id="old_pw"/>
        </div>
        <div class="row">
            <label>请输入您的新密码:</label>
            <input type="password" name="new_pw" id="new_pw"/>
        </div>
        <div class="row">
            <label>请确认您的新密码:</label>
            <input type="password" name="ck_new_pw" id="ck_new_pw"/>
        </div>
        <input class="btn" id="btn" type="button" value="提交"/>
    </form>
    <script>
        $("#btn").click(function () {
            var username=$("#username").val();
            var old_pw=$("#old_pw").val();
            var new_pw=$("#new_pw").val();
            var ck_new_pw=$("#ck_new_pw").val();
            if(new_pw!=ck_new_pw){
                alert("两次密码不一致");
                window.location.reload();
            }else {
                $.ajax({
                    url:"change_pw",
                    type:"POST",
                    data:{"username":username,
                           "old_pw":old_pw,
                            "new_pw":new_pw
                         },
                    success:function (data) {
                        if (data=="1"){
                            alert("修改成功");
                            window.location.reload();
                            return;
                        }else {
                            alert("旧密码错误");
                            window.location.reload();
                            return;
                        }
                    }
                })
            }

        })
    </script>
</body>
</html>
