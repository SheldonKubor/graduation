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
    <style>
        label {
            float: left;
            color: #666666;
        }

        .row{
            float: left;
        }
        input{
            width: 300px;
            height: 22px;
            border: 1px solid #95E0EF;
            background-color: #f3fcfe;
            border-left-width: 2px;
            padding: 5px 0 0 2px;
            float: left;
        }
    </style>
    <script>
        var req=null;
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
                req.open("POST", url,true);
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
    <div>
        <form action="add_book" method="post" enctype="multipart/form-data">
        <div class="row">
            <label>书名</label>
            <input type="text" name="book_name" id="add_book_name"/>
        </div>
        <div class="row">
            <label>作者</label>
            <input type="text" name="author" id="add_book_author"/>
        </div>
        <div class="row">
            <label>类别</label>
            <input type="text" name="classify" id="add_book_classify"/>
        </div>
            <div class="row">
                <label>类别</label>
                <input type="text" name="content" id="add_book_content"/>
            </div>
        <div class="row">
            <label>进价</label>
            <input type="text" name="in_price" id="add_book_in_price"/>
        </div>
        <div>
            <label>售价</label>
            <input type="text" name="sale_price" id="add_book_sale_price"/>
        </div>
            <div>
                <label>图片</label>
                <input type="file" name="pic" id="add_book_pic"/>
            </div>
            <%--图片<input type="file" name="image" id="image" accept="image/jpeg"/>--%>
        <%--<div class="row">--%>
            <%--<button onclick="onClick('add_book')">确定</button>--%>
        <%--</div>--%>
            <input type="submit"/>
        </form>
    </div>
</body>
</html>
