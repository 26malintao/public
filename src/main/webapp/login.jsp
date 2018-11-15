<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>jquery-2.1.4/jquery.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#but").click(function(){
				//发送ajax请求
				$.ajax({
					url:"uc/ck",
					type:"post",
					dataType:"json",
					data:{"loginname":$("#loginname").val(),"loginpwd":$("#loginpwd").val()},
					success:function(data){
						if(data==true){
							//登录成功
							 location.href="dc/fy"; 
							
						}else{
							//登录失败
							$("#errorFont").html("用户名或则密码错误!!!");
							
						}
					}
				});
			});
		})
	</script>
  </head>
  <body>
		<font size="1" color="red" id="errorFont"></font>
		姓名:<input id="loginname" name="loginname" type="text"><p>
		密码:<input id="loginpwd" name="loginpwd" type="password">
		<button id="but">登录</button>
  </body>
</html>