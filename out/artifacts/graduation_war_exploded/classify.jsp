<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/6/2
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/hide.js"></script>
    <script src="js/jquery-1.11.3.js"></script>
    <link rel="stylesheet" type="text/css" href="css/book.css"/>
</head>
<body>
    <button onclick="display('delete_classify')">删除分类</button>
    <div id="delete_classify" hidden="display">
    <form>
        请输入要删除的分类<input type="text" name="classify" id="classify"/>
        <input type="button" id="btn" value="确定"/>
    </form>
</div>
    <button onclick="display('add_classify')">新增分类</button><br>
    <div id="add_classify" hidden="display">
    	<div class="row">
    		<label>请输入分类名称</label>
    		<input type="text" name="classifyName" id="classifyName"/>
        <button class="btn2" value="" onclick="onClick('add_classify')">提交</button></div>
    </div>
    <!--<div>-->
        <table cellpadding="0" cellspacing="0">
            <thead><tr><td>序号</td><td>类别</td><td>操作</td></tr></thead>
            <c:forEach items="${requestScope.allClassify}" var="classify">
                <tr>
                    <td>
                            ${classify.id}
                    </td>
                    <td>
                            ${classify.name}
                    </td>
                    <td>
                        <a href="delete_classify?name=${classify.name}" onclick="reLoad()">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <!--</div>-->



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
            var classifyName=document.getElementById("classifyName").value;

            if (req) {
                req.onreadystatechange =add_book_receiver;
                req.open("GET",url+"?classifyName="+classifyName, true);
                req.send();
            }
        }
        function add_book_receiver(){
            var ready=req.readyState;
            var data=null;
            if (ready==4&&req.status==200){
                data=req.responseText;
                if (data=="0") {
                    alert("添加失败");
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

        function reLoad() {
            alert("删除成功");
            window.location.reload();
            return;
        }

        $("#btn").click(function () {
            var classify=$("#classify").val();

            $.ajax({
                url:"delete_classify",
                type:"POST",
                data:{"name":classify},
                success:function (data) {
                    if (data=="1"){
                        reLoad();
                    }else {
                        alert("删除失败");
                        window.location.reload();
                        return;
                    }
                }
            })
        })
    </script>
</body>
</html>
