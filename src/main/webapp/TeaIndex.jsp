<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="500px">
    <tr align="center">
        <td colspan="8">
            <a href="${pageContext.request.contextPath}">添加</a>
        </td>
    </tr>
    <tr align="center">
        <th>编号</th>
        <th>电话</th>
        <th>姓名</th>
        <th>职位编号</th>
        <th>操作</th>
    </tr>
    <tbody id="myPageShow">

    </tbody>
</table>
</body>
<script src="${pageContext.request.contextPath}/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/TeaIndex.js"></script>
</html>
