<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>类别管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script type="text/javascript">

        //启动完毕后，初始化以及为按钮绑定函数
        $(document).ready(function () {
            $("#btnsearch").click(function () {
                pageindex = 1;
                search();
            });
            search();
        });
        var pageindex = 1;
        var pagecount = 0;
        var pagesize = 3;

        function search() {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "${pageContext.request.contextPath}/admin/category/search",
                data: {
                    pageindex: pageindex,
                    pagesize: pagesize,
                    name: $("#name").val()
                },
                success: function (jsonresult) {
                    var jsondata = jsonresult.data;
                    pagecount = jsondata.pages;
                    loadDatas(jsondata);
                    initPage(jsondata);
                },
                error: function (xmlHttpRequest) {
                    alert(xmlHttpRequest.responseText);
                }
            });
        }

        function loadDatas(jsondata) {
            var datas = jsondata.list;
            $("#categorydatas").html("");
            for (var i = 0; i < datas.length; i++) {
                var category = datas[i];
                $("#categorydatas").append(`<tr>
                                            <td>\${category.id}</td>
                                            <td>\${category.name}</td>
                                            <td>\${category.goodsnum}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/admin/category/toedit/\${category.id}">修改</a>
                                                <a href="javascript:delCategory(\${category.id})">删除</a>
                                             </td>
                                         </tr>
                                        `);
            }
        }


        function initPage(jsondata) {

            $("#categorypage").html(`<tr> <td colspan="4">
            \${function () {
                if (pageindex > 1) {
                    return `<a href="javascript:readdata(1)">首页</a>
                <a href="javascript:readdata(\${pageindex - 1})">上一页</a>`;
        } else {
            return "首页 上一页";
        }
        }()}

        \${function () {
                       if (pageindex < pagecount) {
                           return `<a href="javascript:readdata(\${pageindex + 1})">下一页</a>
        <a href="javascript:readdata(\${pagecount})">末页</a>`;

        } else {
            return "下一页 末页";
        }
        }()}
        </td>
        </tr>
            `);

        }

        function readdata(curpage) {
            pageindex = curpage;
            search();
        }


        function delCategory(categoryid) {
            if (confirm("是否删除？")) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/admin/category/del/" + categoryid,
                    type: "post",
                    dataType: "json",
                    success: function (jsondata) {
                        if (jsondata.statusCode == 0) {
                          search();
                        } else {
                            alert(jsondata.msg);
                        }

                    }
                });
            }
        }

    </script>
</head>
<body>

<form id="frmsearch">
    关键字：<input type="text" id="name">
    <input id="btnsearch" type="button" value="搜索">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>类别名称</th>
        <th>商品数量</th>
        <th>操作</th>
    </tr>
    </thead>

    <tbody id="categorydatas">

    </tbody>
    <tfoot id="categorypage">

    </tfoot>
</table>

</body>
</html>
