<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--秒杀提交订单--%>
<html>
<head>
    <title>秒杀 </title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
</head>
<body>
<table class="table" id="goodlist">
    <tr>
        <td>商品名称</td>
        <td colspan="3">
            <div id="goodsname"></div>
        </td>
    </tr>
    <tr>
        <td>秒杀开始时间</td>
        <td>
            <div id="startdate"></div>
        </td>

        <td id="killTitle">
            <input type="hidden" id="remainSeconds">
            <div style="float: left" id="killstatus"></div>
            <div style="float: left;color: red" id="second"></div>
        </td>
        <td>
            <form id="killForm" method="post">
                <button type="button" id="buyButton">立即秒杀</button>
                <input id="killid" type="hidden" name="killid">
            </form>
        </td>
    </tr>
    <tr>
        <td>商品原价</td>
        <td colspan="3">
            <div id="price"></div>
        </td>
    </tr>
    <tr>
        <td>秒杀价</td>
        <td colspan="3">
            <div id="killprice"></div>
        </td>
    </tr>
    <tr>
        <td>库存数量</td>
        <td colspan="3">
            <div id="stockcount"></div>
        </td>
    </tr>
</table>
<script>
    $(document).ready(function () {
        initGoodsView()
        //控制按钮状态
        //实现倒计时的效果 setTimeOut
        $("#buyButton").click(function () {
            kill();
        });
    });


    function kill() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "${pageContext.request.contextPath}/killgoods/kill/" + ${requestScope.killid},
            success: function (result) {
                var res = result;
                switch (res) {
                    case 1:
                        alert("秒杀成功" + res);
                        break;
                    case 2:
                        alert("秒杀没开始" + res);
                        break;
                    case 3:
                        alert("秒杀已结束" + res);
                        break;
                    case 4:
                        alert("秒杀过了" + res);
                        break;
                    case 5:
                        alert("库存售完，秒杀已经结束" + res);
                        break;
                }
            }
        });
    }


    function initGoodsView() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "${pageContext.request.contextPath}/killgoods/view/" + ${requestScope.killid},
            success: function (jsonResult) {
                var jsondata = jsonResult.data;
                var killStatus = jsonResult.statusCode;
                var remainSeconds = parseInt(jsonResult.msg);
                initPage(jsondata, killStatus, remainSeconds);
                countDown(remainSeconds);

                console.log(jsondata);
                console.log(killStatus);
                console.log(remainSeconds);
            }
        });
    }

    function initPage(datas, killStatus, remainSeconds) {

        $("#goodsname").text(datas.name);
        $("#startdate").text(datas.startdate);
        // $("#remainSeconds").val(remainSeconds);
        //
        // if (killStatus === 0) {
        //     $("#killstatus").text("秒杀倒计时：");
        //     $("#countDown").text(remainSeconds);
        // } else if (killStatus === 1) {
        //     $("#killstatus").text("秒杀进行中");
        // } else {
        //     $("#killstatus").text("秒杀已结束");
        // }
        $("#countDown").text(remainSeconds);

        $("#killid").text(datas.killid);
        $("#price").text(datas.price);
        $("#killprice").text(datas.killprice);
        $("#stockcount").text(datas.stockcount);

    }

    function countDown(remainSeconds) {
        // var remainSeconds = $("#remainSeconds").val();

        var timeout;
        if (remainSeconds > 0) {
            //秒杀还没有开始
            $("#killstatus").text("秒杀倒计时");
            $("#buyButton").attr("disabled", true);
            timeout = setTimeout(function () {
                $("#remainSeconds").val(remainSeconds - 1);
                console.log(remainSeconds);
                $("#second").text(remainSeconds - 1);
                countDown(remainSeconds - 1);
            }, 1000);
        } else if (remainSeconds == 0) {
            console.log(remainSeconds);
            //秒杀开始
            $("#buyButton").attr("disabled", false);
            $("#killTitle").text("秒杀进行中");
            clearTimeout(timeout);
        } else {
            $("#buyButton").attr("disabled", true);
            $("#killTitle").text("秒杀结束");
        }
    }
</script>

</body>
</html>
