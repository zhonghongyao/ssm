<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="GB18030"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'fileUploadResult.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<form action="<%=basePath%>upload/file" method="post" enctype="multipart/form-data">

    username: <input type="text" name="username" /><br>
    file:  <input type="file" name="uploadfile"><br>

    <input type="submit" value="上传文件">

</form>

</body>
</html>