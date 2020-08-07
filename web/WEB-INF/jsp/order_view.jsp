<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--订单详情--%>
<html>
<head>
    <title>订单秒杀详情</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>

    <script>
        $(document).ready(function () {
            var killorderid=getkillorderid();
            searchOrderView(killorderid);
        });
        function getkillorderid() {
            var killorderid = prompt ("输入秒杀订单id: ", "");
            return killorderid;
        }

        function searchOrderView(killorderid) {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "${pageContext.request.contextPath}/killgoods/order/" + killorderid,
                success: function (jsonResult) {
                    var jsondata = jsonResult.data;
                    initPage(jsondata);
                }
            });

        }

        function initPage(datas) {
            $("#goodsName").text(datas.goodsname);
            $("#orderPrice").text(datas.goodsprice);
            $("#creatDate").text(datas.createdate);
            if (datas.orderstatus === '0') {
                $("#orderStatus").text("未支付");
            } else {
                $("#orderStatus").text("已支付");
            }
        }
    </script>
</head>
<body>
<div>订单秒杀详情</div>
<table id="goodslist">
    <tr>
        <td>商品名称</td>
        <td colspan="3">
            <div id="goodsName"></div>
        </td>
    </tr>
    <tr>
        <td>商品图片</td>
        <td colspan="2"><img src="${pageContext.request.contextPath}/static/images/6.jpg" id="goodsImg" width="100"
                             height="100"/></td>
    </tr>
    <tr>
        <td>订单价格</td>
        <td colspan="2">
            <div id="orderPrice"></div>
        </td>
    </tr>

    <tr>
        <td>下单时间</td>
        <td colspan="2">
            <div id="creatDate"></div>
        </td>
    </tr>
    <tr>
        <td>订单状态</td>
        <td>
            <div id="orderStatus"></div>

        </td>
        <td>
            <button type="submit" id="paybtn">立即支付</button>
        </td>
    </tr>
</table>
</body>
</html>
