<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>delete admin</h1>

    请输入要删除管理员的账号<input type="text" name="del_admin" id="del_admin"/>
    请输入要删除管理员的密码<input type="password" name="del_admin_pw" id="del_admin_pw"/>
                         <input type="button" value="确定" onclick="onClick('delete_admin')"/>

    <script>
        var req=null;
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_delete_admin(url);
        }
        function initXMLHttpRequestObj(){

            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_delete_admin(url) {
            var username=document.getElementById("del_admin").value;
            var password=document.getElementById("del_admin_pw").value;
            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
                var data={"username":username,"password":password};
                req.send(JSON.stringify(data));
            }
        }
        function add_book_receiver(){
            var ready=req.readyState;
            var data=null;
            if (ready==4&&req.status==200){
                data=req.responseText;
                if (data=="0") {
                    alert("删除失败，请检查用户名是否正确");
                    window.location.reload();
                    return;
                }
                if(data=="1"){
                    alert("删除成功");
                    window.location.reload();
                    return;
                }

            }
        }
    </script>
</body>
</html>
