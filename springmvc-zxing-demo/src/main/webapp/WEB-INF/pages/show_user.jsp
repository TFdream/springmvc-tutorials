<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
<div>
    用户id: ${user.id} <br>
    用户姓名: ${user.name} <br>
    用户年龄: ${user.age} <br>
    <div>
        <a href="${pageContext.request.contextPath}/qr/encode/${user.id}" >生成二维码</a>
    </div>
</div>
</body>
</html>
