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
            var bookname=document.getElementById("update_book_name").value;
            var author=document.getElementById("update_author").value;
            var classify=document.getElementById("update_classify").value;
            var in_price=document.getElementById("update_in_price").value;
            var out_price=document.getElementById("update_out_price").value;
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
    </script>
</head>
<body>
    <h1>修改图书</h1>

        书名<input type="text" name="update_book_name" id="update_book_name"/><br>
        作者<input type="text" name="update_author" id="update_author"/><br>
        进价<input type="text" name="update_in_price" id="update_in_price"><br>
        售价<input type="text" name="update_out_price" id="update_out_price"/><br>
        类型<input type="text" name="update_classify" id="update_classify"><br>
        <button onclick="onClick('update_book')">提交</button>


</body>
</html>
