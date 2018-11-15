<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath %>My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
	<form action="dc/update" method="post">
		<input type="hidden" name="sqid" value="${daikuan.sqid }">
		贷款状态:<%-- <input type="text" name="state" value="${daikuan.wuziname }" ><p> --%>
				<select name="stateid">
	  					<c:forEach items="${statelist }" var ="sl">
	  						<option value="${sl.stateid }" ${daikuan.state.stateid==sl.stateid?"selected":"" } >${sl.statename}</option>
	  					</c:forEach>
	  			</select><p>
		贷款金额:<input type="text" name="price" value="${daikuan.price }"><p>
		贷款类型:<select name="daikuantypeid">
	  					<c:forEach items="${typelist }" var ="tp">
	  						<option value="${tp.daikuantypeid }" ${daikuan.type.daikuantypeid==tp.daikuantypeid?'selected':'' }> ${tp.daikuantype} </option>
	  					</c:forEach>
	  			</select>
		<input type="submit" value="确定修改">
	</form>
  </body>
</html>
