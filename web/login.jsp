<%--
  Created by IntelliJ IDEA.
  User: Constantine
  Date: 2017/2/25
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>书城</title>
    <link rel="stylesheet" href="css/loginCss.css" type="text/css"/>
  </head>
  <body>

  <div class="container">
    <section>
      <div id="container_demo">
        <div id="wrapper">
          <div id="login" class="animate form">
            <form action="HelloWorld" method="post"><!-- form 表单的onsubmit方法，提交时使用-->
              <h1>请登录</h1>
              <p>
                <label>用户名</label>
                <input type="text" name="username"/>
              </p>
              <p>
                <label>密码</label>
                <input type="password" name="password"/><br>
              </p>
              <!--<p class="keeplogin">
                <input type="checkbox"/>
                <label>记住密码</label>
              </p>
              -->
              <p class="login button">
                <input type="submit" value="登陆"/>
              </p>
              <p class="change_link">
                <a href="register.jsp">没有账号？免费注册</a>
              </p>
            </form>

          </div>
        </div>
      </div>
    </section>
  </div>
  <!--
    <form action="HelloWorld" method="post">
      <h1>Log in</h1>
      <div class="inset">
        <p>
          <label>用户名</label>
          <input type="text" name="username"/>
        </p>
        <p>
          <label>密码</label>
          <input type="password" name="password"/><br>
        </p>

        <input type="submit" name="submit" value="登陆"/>
        <a href="register.jsp">没有账号？免费注册</a>
      </div>
    </form>
    -->
  </body>
</html>
