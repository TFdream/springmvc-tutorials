<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<div class="panel-heading"><h2>用户信息</h2></div>
<div class="panel-body">
    用户id: ${user.id} <br>
    用户name: ${user.name} <br>
    用户age: ${user.age} <br>
    <div>
        <a href="${pageContext.request.contextPath}/qr/encode/${user.id}" >生成二维码</a>
    </div>
</div>
</body>
</html>
