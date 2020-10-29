<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/res/jq.js"></script>
</head>
<body>
	欢迎${USER.username}北京点金教育平台，万元高薪，仅在点金
	<div id="dateTime"></div>
</body>
<script type="text/javascript">
$(function(){
	setInterval("$('#dateTime').html(new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay()));",1000);
	
})
</script>
</html>