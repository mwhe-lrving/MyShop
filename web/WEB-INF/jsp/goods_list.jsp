<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<head>
    <title>Title</title>
</head>
<body>
    <table class="table" id="goodslist">
        <tr>
            <td>商品名称</td>
            <td>商品图片</td>
            <td>商品原价</td>
            <td>秒杀价</td>
            <td>库存图片</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.killgoods}" var="goods">
            <tr> <td>${goods.name}</td>
                <td>图片</td>
                <td>${goods.price}</td>
                <td>${goods.killprice}</td>
                <td>${goods.stockcount}</td>
                <td><a href="${pageContext.request.contextPath}/killgoods/toview/${goods.killid}">详情</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
