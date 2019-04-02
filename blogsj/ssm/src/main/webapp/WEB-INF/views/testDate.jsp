<%--
  Created by IntelliJ IDEA.
  User: zhongghongyao
  Date: 2018/6/16
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="<%=basePath%>static/js/jquery-2.1.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">

    $(function () {

        $.ajax({
            url:"<%=basePath%>/user/showUser",
            type:"post",
            async:false,
            dataType:json,
            success:function(data){
                alert(data);
                console.log(data)



            },
            //测试bug
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("错误");
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
        })


    })
</script>



</body>
</html>
