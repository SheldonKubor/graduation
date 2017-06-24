<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
    <h1>delete user</h1>
    <form>
        请输入要删除用户的账号<input type="text" name="del_username" id="del_username"/>
                           <input type="button" value="确定" onclick="onClick('delete_user')"/>
    </form>
    <div>
        <table cellpadding="0" cellspacing="0">
            <thead><tr><td>序号</td><td>用户名</td><td>操作</td></tr></thead>
            <c:forEach items="${requestScope.allCus}" var="cus">
                <tr>
                    <td>
                            ${cus.id}
                    </td>
                    <td>
                            ${cus.username}
                    </td>
                    <td>
                        <a href="delete_user?name=${cus.username}" onclick="reLoad()">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        var req=null;
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_delete_user(url);
        }
        function initXMLHttpRequestObj(){

            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_delete_user(url) {
            var username=document.getElementById("del_username").value;
            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
                var data={"username":username};
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
