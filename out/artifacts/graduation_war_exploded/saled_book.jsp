<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:36
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
    <h1>销售量</h1>
    <form action="all_book" method="post">
        <input type="text" name="bookname" id="bookname"/>
        <input type="submit" value="submit"/>
    </form>

    <table>
        <thead><tr><td>书名</td><td>销售量</td></tr></thead>
        <c:forEach items="${requestScope.bookSaledResult}" var="book">
            <tr>
                <td>
                        ${book.bookName}
                </td>
                <td>
                        ${book.bookNum}
                </td>
            </tr>
        </c:forEach>
    </table>
    <script>
        var req=null;
        function onLoad() {
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
                req.open("POST", "all_book", true);
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
        window.onload=function () {
            onLoad();
        };
    </script>
</body>
</html>
