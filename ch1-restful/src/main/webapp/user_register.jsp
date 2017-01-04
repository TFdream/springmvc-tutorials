<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submit Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form action="user/update" method="post">
    username: <input type="text" name="username"/>
    <br>
    password: <input type="password" name="password"/>
    <br>
    email: <input type="text" name="email"/>
    <br>
    age: <input type="text" name="age"/>
    <br>
    province: <input type="text" name="address.province"/>
    <br>
    city: <input type="text" name="address.city"/>
    <br>
    district: <input type="text" name="address.district"/>
    <br>
    detail: <input type="text" name="address.detail"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
