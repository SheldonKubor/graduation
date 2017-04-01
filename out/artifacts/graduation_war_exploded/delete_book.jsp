<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var g_url="http://localhost:8080/graduation/";
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_delete_book(url);
        }
        function initXMLHttpRequestObj(){
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_delete_book(url) {
            url=g_url+url;
            var bookname=document.getElementById("del_book_by_name").value;
            if (req) {
                req.onreadystatechange =del_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json;charset=utf-8");
                var obj={"bookName":bookname};
                req.send(JSON.stringify(obj));
            }
        }
        function del_book_receiver(){
            var ready=req.readyState;
            var data=null;
            if (ready==4 && req.status==200){
                data=req.responseText;
                if (data=="0") {
                    alert("删除失败，请检查图书名字是否正确");
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
</head>
<body>
    <h1>删除图书</h1>
    请输入要删除图书的名字<input type="text" name="book_name" id="del_book_by_name"/>
    <button onclick="onClick('delete_book')">提交</button>

</body>
</html>
