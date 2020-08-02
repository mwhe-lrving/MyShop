<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎</title>
    <style>
      div{
        width: 500px;
        height: 500px;
       margin: 200px auto;
      }

    </style>
  </head>
  <body>
  <div>
    <h3>登录</h3><a style="color: red">${msg}</a>
    <form name="frmlogin" method="post" action="${pageContext.request.contextPath}/dologin">
      用户名：<input name="username" value="root" type="text"/></br>
      密 码：<input name="password" value="123" type="password"/></br>
      <input name="resetbtn" type="reset" value="重置"/>
      <input name="loginbtn" type="submit" value="登录"/>
      <%=Thread.currentThread().getName()%>
    </form>
  </div>

<%--  <a href="/login">登录</a>--%>
<%--  <a href="/admin/goods/getall">测试JSON</a>--%>
<%--  <a href="/regist">注册</a>--%>
<%--  <a href="admin/category/view/toadd">添加类别</a>--%>
<%--  <a href="/admin/category/search">search</a>--%>
<%--  <a href="/admin/category/manager">manager</a>--%>
  </body>
</html>
