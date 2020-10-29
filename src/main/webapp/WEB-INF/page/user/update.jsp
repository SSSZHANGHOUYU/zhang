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
    <script type="text/javascript">
        $(function(){
            $("#fm").validate({
                rules: {
                    username :{
                        required:true
                    },
                    password: {
                        required:true,
                        rangelength:[5,10]
                    },

                },
                messages:{
                    username: {
                        required:"账号不能为空"

                    },
                    password: {
                        required:"密码不能为空",
                        rangelength: "长度只能为5~10之间"
                    },

                },
                submitHandler:function(data){
                    $.post(
                        "<%=request.getContextPath()%>/user/update",
                        $("#fm").serialize(),
                        function(data){
                            if(data.code==200){
                                layer.msg(data.msg);
                                parent.location.href="<%=request.getContextPath()%>/toIndex"
                            }else{
                                layer.msg(data.msg);
                            }
                        }
                    )
                }
            })
        })
    </script>
    <style>
        .error{
            color: red;
        }
    </style>
<body>
<form id = "fm" align="center">
    <input type="hidden" name="id" value="${updUser.id}"/>
    用户名<input type = "text" name = "username" value="${updUser.username}"/><br/>
    密码<input type = "text" name = "password" value="${updUser.password}"/><br/>
    <input type = "submit" value= "确认修改" />
</form>
</body>
</html>

