<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
  <h3>注册</h3>
  <form name="frmlreg" method="post" action="${pageContext.request.contextPath}/doreg">
    用户名：<input name="username" value="1" type="text"/></br>
    密 码：<input name="password" value="1" type="password"/></br>
    真实姓名：<input name="realname" value="1" type="text"/></br>
    <input name="resetbtn" type="reset" value="重置"/>
    <input name="registbtn" type="submit" value="注册"/>
    <%=Thread.currentThread().getName()%>
  </form>

  </body>
</html>
