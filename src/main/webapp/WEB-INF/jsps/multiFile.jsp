<%--
  Created by IntelliJ IDEA.
  User: zhenglian
  Date: 2016/9/22
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springboot多文件上传测试</title>
</head>
<body>

    <form action="multiFileUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="file" name="file">
        <input type="file" name="file">
        <input type="submit" value="upload">
    </form>

</body>
</html>
