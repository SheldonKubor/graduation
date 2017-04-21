<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/25
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("POST", url, true);
                req.setRequestHeader("Content-type","application/json");
//                var data={"bookName":bookname,"author":author,"inPrice":in_price,"outPrice":out_price,"classify":classify};
                var data={"bookname":"asdf"};
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
    <form action="add_book_num" method="post">
        请输入图书的名字<input type="text" name="book_name" id="book_name"/>
        请输入添加图书数量<input type="text" name="book_num" id="book_num"/>
        <input type="file" name="book_img" id="book_img"/>
        <input type="submit" value="提交"/>
        <button>提交</button>

    </form>
</body>
</html>
