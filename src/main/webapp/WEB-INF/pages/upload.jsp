<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <h1>springMVC字节流输入上传文件</h1>
    <form name="userForm1" action="/file/upload1" enctype="multipart/form-data" method="post">
        <div id="newUpload1">
            <input type="file" name="file">
        </div>
        <input type="submit" value="上传" >
    </form>

    <br>
    <h1>springMVC包装类上传文件</h1>
    <form name="userForm2" action="/file/upload2" enctype="multipart/form-data" method="post">
    <div id="newUpload2">
        <input type="file" name="file">
    </div>
    <input type="submit" value="上传" >
    </form>
</body>
</html>
