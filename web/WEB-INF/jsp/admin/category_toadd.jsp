<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别添加</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnadd").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/admin/category/doadd",
                    type:"post",
                    data:{
                        name:$("#name").val()
                    },
                    dataType:"json",
                    success:function (jsondata) {
                        if (jsondata.statusCode==0){

                            location.href="${pageContext.request.contextPath}/admin/category/manager";
                        }else {
                            alert(jsondata.msg);
                        }
                    }
                });
            })

        });
    </script>
</head>
<body>
<h3>类别添加</h3>
<form id="frmadd" method="post" >
      类别名称:<input type="text" id="name"/>
    <input id="btnadd" type="button" value="添加"/>
</form>
</body>
</html>
