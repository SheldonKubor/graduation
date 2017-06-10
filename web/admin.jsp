<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/3/15
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<%--<%--%>
    <%--Object isLogin=session.getAttribute("isLogin");--%>
    <%--if(null==isLogin){--%>
        <%--response.sendRedirect("login.jsp");--%>
    <%--}--%>
<%--%>--%>
<frameset rows="7%,*">
    <frame src="admin_top.jsp" name="topFrame"/>

    <frameset cols="20%,*">
        <frame src="admin_left.jsp" name="leftFrame"/>

        <frame src="admin_right.jsp" name="rightFrame"/>
    </frameset>

</frameset>
<body>

    <div>

    </div>
</body>

</html>
