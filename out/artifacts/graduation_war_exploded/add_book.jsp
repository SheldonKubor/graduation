<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_add_book(url);
        }
        function initXMLHttpRequestObj(){
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_add_book(url) {
            var bookname=document.getElementById("add_book_name").value;
            var author=document.getElementById("add_book_author").value;
            var classify=document.getElementById("add_book_classify").value;
            var in_price=document.getElementById("add_book_in_price").value;
            var out_price=document.getElementById("add_book_sale_price").value;
            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
                var data={"bookName":bookname,"author":author,"inPrice":in_price,"outPrice":out_price,"classify":classify};
                req.send(JSON.stringify(data));
            }
        }
        function add_book_receiver(){
            var ready=req.readyState;
            var data=null;
            if (ready==4&&req.status==200){
                data=req.responseText;
                if (data=="0") {
                    alert("添加失败，请检查图书名字是否正确");
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
</head>
<body>
    <h1>新增图书</h1>

        书名<input type="text" name="book_name" id="add_book_name"/><br>
        作者<input type="text" name="author" id="add_book_author"/><br>
        类别<input type="text" name="classify" id="add_book_classify"/><br>
        进价<input type="text" name="in_price" id="add_book_in_price"/><br>
        售价<input type="text" name="sale_price" id="add_book_sale_price"/><br>

        <button onclick="onClick('add_book')">确定</button>
</body>
</html>
