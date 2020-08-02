<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <style>
      div {
        width: 500px;
        height: 500px;
        margin: 200px auto;
    }
    </style>
</head>
<body>
<div>

    <h3>登录${msg}</h3>
    <form name="frmlogin" method="post" action="${pageContext.request.contextPath}/dologin">
        用户名：<input name="username" value="root" type="text"/></br>
        密 码：<input name="password" value="123" type="password"/></br>
        <input name="resetbtn" type="reset" value="重置"/>
        <input name="loginbtn" type="submit" value="登录"/>
        <%=Thread.currentThread().getName()%>
    </form>

</div>


</body>
</html>
