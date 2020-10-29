<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/10/26
  Time: 下午 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/jq.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/layer/layer.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/jquery.validate.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/additional-methods.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/layer/layer.js"></script>
</head>
<body>
<form id = "fm" align="center">
    <table>
        <c:forEach items="${listUsers}" var="user">
            <tr>
               <td>用户名:${user.username}</td>
                <td>密码:${user.password}</td>
               <td> <input type = "button"  value="修改"  onclick="toUpdate(${user.id})" /></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
<script type="text/javascript">
    function toUpdate(id){
        layer.open({
            type: 2,
            title: '修改用户信息',
            shadeClose: true,
            shade: 0.8,
            area: ['680px', '70%'],
            content: '<%=request.getContextPath()%>/user/toUpdate/'+id
        });
    }
</script>
</html>

