<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/16
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
    <script>
        function onClick(url) {
            initXMLHttpRequestObj();
            send_ajax_update_book(url);
        }
        function initXMLHttpRequestObj() {
            if (window.XMLHttpRequest) {
                req = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        function send_ajax_update_book(url) {
            var bookid="${requestScope.bookid.id}";
            var bookname=document.getElementById("update_book_name").value;
            var author=document.getElementById("update_author").value;
            var classify=document.getElementById("update_classify").value;
            var in_price=document.getElementById("update_in_price").value;
            var out_price=document.getElementById("update_out_price").value;
            var content=document.getElementById("update_book_content").value;
            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
                var data={"id":bookid,"bookName":bookname,"author":author,"inPrice":in_price,"outPrice":out_price,"classify":classify,"content":content};
                console.log(data);
                req.send(JSON.stringify(data));
            }
        }
        function add_book_receiver(){
            var ready=req.readyState;
            var data=null;
            if (ready==4&&req.status==200){
                data=req.responseText;
                if (data=="0") {
                    alert("修改失败，请检查图书名字是否正确");
                    window.location.reload();
                    return;
                }
                if(data=="1"){
                    alert("修改成功");
                    window.location.reload();
                    return;
                }

            }
        }
        function selected() {
            //var obj=document.getElementById("update_classify");
            //var options=obj.childNodes;

            var options=document.getElementsByTagName("option");
            console.log("${requestScope.bookid.classify}");

            for (var i=0;i<options.length;i++){
                console.log(options[i].value);
                if(options[i].value == "${requestScope.bookid.classify}"){
                    options[i].selected=true;
                    alert("asdf");
                }
            }
        }
        window.onload=selected();
    </script>
</head>
<body>
    <h1>修改图书</h1>
        <div class="row">
            <label>书名</label>
            <input type="text" name="update_book_name" id="update_book_name" value="${requestScope.bookid.bookName}"/><br>
        </div>
        <div class="row">
            <label>作者</label>
            <input type="text" name="update_author" id="update_author" value="${requestScope.bookid.author}"/><br>
        </div>
        <div class="row">
            <label>进价</label>
            <input type="text" name="update_in_price" id="update_in_price" value="${requestScope.bookid.inPrice}"/><br>
        </div>
        <div class="row">
            <label>售价</label>
            <input type="text" name="update_out_price" id="update_out_price" value="${requestScope.bookid.outPrice}"/><br>
        </div>
        类型<select name="update_classify" id="update_classify">
                <c:forEach items="${requestScope.classify}" var="classify">
                    <option value="${classify.name}">${classify.name}</option>
                </c:forEach>
            </select>
        <div class="row">
            <label>简介</label>
            <textarea class="detailsR" name="content" rows="4" cols="" id="update_book_content" >${requestScope.bookid.content}</textarea>
        </div>
            <button onclick="onClick('update_book')">提交</button>


</body>
</html>
