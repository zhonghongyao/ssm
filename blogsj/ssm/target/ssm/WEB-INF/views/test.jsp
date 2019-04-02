<%--
  Created by IntelliJ IDEA.
  User: zhongghongyao
  Date: 2018/6/16
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <script src="../static/js/jquery-2.1.1.min.js"></script>

</head>
<body>
<script type="text/javascript">

    $(document).ready(function(e) { alert('test jquery !'); });

</script>

</body>
</html>
