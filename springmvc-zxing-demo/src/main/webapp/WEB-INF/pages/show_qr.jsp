<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示二维码</title>
</head>
<body>
<div class="panel-heading"><h2>二维码与有Logo 的二维码</h2></div>
<div class="panel-body">
    <div class="col-md-6" align="center">
        <a href="qrcode?userId=${userId }">
            <img class="img-responsive img-rounded" src="${pageContext.request.contextPath}${qrImage}"/>
            <b class="btn btn-success" >我要解码</b>
        </a>
    </div>
    <div class="col-md-6" align="center">
        <a href="qrcode?userId=${userId }">
            <img class="img-responsive img-rounded" src="${pageContext.request.contextPath}${logoQRImage}"/>
            <b class="btn btn-success" >我要解码</b>
        </a>
    </div>
    <div class="col-md-12">
        <br>
        <a class="btn btn-warning" href="${pageContext.request.contextPath}users/15">返回</a>
    </div>
</div>
</body>
</html>
