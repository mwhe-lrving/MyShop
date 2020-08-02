<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别添加</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
       //      console.log($("#frmedit").serialize());
            $("#btnedit").click(function () {
                $.ajax({
                    dataType: "json",
                    type: "post",
                    url: "${pageContext.request.contextPath}/admin/category/doedit",
                    data:   $("#frmedit").serialize(),
                    // {
                    //
                    //         name: $("#name").val(),
                    //         id: $("#id").val(),
                    //         goodsnum: $("#goodsnum").val()
                    //     },
                    success: function (jsondata) {
                        if (jsondata.statusCode == 0) {

                            location.href = "${pageContext.request.contextPath}/admin/category/manager";
                        } else {
                            alert(jsondata.msg);
                        }
                    }
                });
            })

        });
    </script>
</head>
<body>
<h3>类别修改</h3>
<form id="frmedit" method="post">
    <input name="id" type="hidden" value="${requestScope.category.id}" id="id"/>
    类别名称:<input name="name" type="text" value="${requestScope.category.name}" id="name"/>
    商品数量:<input name="goodsnum" type="text" value="${requestScope.category.goodsnum}" id="goodsnum"/>
    <input id="btnedit" type="button" value="修改"/>
</form>
</body>
</html>
