<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>二维码与带Logo的二维码</title>
</head>
<body>
<div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/qr/decode/${userId }">
            <img class="img-responsive img-rounded" src="${pageContext.request.contextPath}${qrImage}"/>
            <b class="btn btn-success" >我要解码</b>
        </a>
    </div>
    <div align="center">
        <a href="${pageContext.request.contextPath}/qr/decode/${userId }">
            <img class="img-responsive img-rounded" src="${pageContext.request.contextPath}${logoQRImage}"/>
            <b class="btn btn-success" >我要解码</b>
        </a>
    </div>
</div>
</body>
</html>
