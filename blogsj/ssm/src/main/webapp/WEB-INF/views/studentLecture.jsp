<%--
  Created by IntelliJ IDEA.
  User: zhongghongyao
  Date: 2018/6/16
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<td>
    <h2>${studentBean.cnname}</h2>

</td>
<c:forEach items="${studentBean.studentLectureList}" varStatus="i" var="item" >

    <td>
        <h2>${item.grade}</h2>
        <h2>${item.lectureBean.lecture_name}</h2>
    </td>
    </tr>
</c:forEach>

</body>
</html>
