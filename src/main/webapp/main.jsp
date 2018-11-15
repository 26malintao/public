<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<!-- 	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
	<script type="text/javascript">

	//全选 和反选
	function selectAll(obj){
		var celist=$(".ce");
		$.each(celist,function(i,n){
			if(obj.innerHTML=="全选"){
				n.checked=true;
			}else{
				if(n.checked){
					n.checked=false;
				}else{
					n.checked=true;
				}
			}
		});
	} 
	
	 function deleteInfo(){
		var celist=$(".ce");
		var str="";
		$.each(celist,function(i,n){
			if(n.checked){
				var td=$(n).parent();
				var typeid=td.next().next().html();
				str+=typeid+","; 
			}
		})
		 if(str==null ||str==""){
			alert("删除至少得选中一条数据");
			return;
		}
		location ="dc/delete?str="+str;
	} 
	
	</script>  -->
  </head>
  <body>
  		<form action="dc/fy" method="post"  name="splitform">
	  			客户姓名:<input type="text" name="query.qhostname" value="${fy.query.qhostname }">
	  			贷款类型:<select name="query.qdaikuantypeid">
	  					<option value="">--请选择--</option>
	  					<c:forEach items="${tpList }" var ="tp">
	  						<option value="${tp.daikuantypeid }" ${fy.query.qdaikuantypeid==tp.daikuantypeid?'selected':'' }> ${tp.daikuantype} </option>
	  					</c:forEach>
	  				</select>
	  			金额间隔:<input type="text" name="query.lowprice"   value="${fy.query.lowprice }" >
	  			<input type="text" name="query.highprice"   value="${fy.query.highprice }" >
	  			
	  			<input type="submit" value="搜索">
	  		</form>

		<h1>欢迎&nbsp;&nbsp;${loginUser.realname }&nbsp;&nbsp;登录</h1>
		<form action="dc/dt" method="post" >
		<table id="tb" bordercolor="gray" border="1" width="50%" cellspacing="0" >
		<tr align="center">
			<td>选项</td>
			<td>贷款申请编号</td>
			<td>客户名称</td>
			<td>贷款类型</td>
			<td>贷款金额</td>
			<td>贷款申请日期</td>
			<td>贷款状态</td>		 
			<td>修改</td>
			<td>删除</td>	  				
	  	</tr>
	    	<c:if test="${empty dkList}">
				<tr>
					<td colspan="9">没有查询到数据</td>
				</tr>	
		</c:if> 				
		<c:if test="${dkList!=null }">		
  			<c:forEach items="${dkList }" var="dk">		
				<tr align="center">	
					<td><input type="checkbox" value="${dk.sqid}" class="check" name="box"></td> 					
					<td>${dk.sqid}</td>
					<td>${dk.hostname} </td>	
					<td>${dk.type.daikuantype} </td>					
					<td>${dk.price}</td>
					<td>
						<fmt:formatDate value="${dk.sqdate}" pattern="yyyy年MM月dd日" />
					 </td>	
					<td>${dk.state.statename}</td>											
					<td>
						<a href="dc/update?sqid=${dk.sqid}">修改</a>
					</td>
					<td>
						<a href="dc/delete?sqid=${dk.sqid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>  
		
	</table>
	<input type="submit" value="批量删除"> 
	</form>
		<!-- <input type="button" value="删除"  onclick="deleteInfo()"> </td> -->
<!-- 	 <table>
		<tr>
		 <td><a href="javascript:void(0);" onclick="selectAll(this);">全选</a> </td>
		<td><a href="javascript:void(0);" onclick="selectAll(this)">反选</a></td>
		<td><input type="button" value="删除"  onclick="deleteInfo()"> </td>  
		 
 	</tr>
 </table>  -->	
			<c:url var="Url" value="dc/fy">
				<c:param name="query.qhostname" value="${fy.query.qhostname }"></c:param>
				<c:param name="query.qdaikuantypeid" value="${fy.query.qdaikuantypeid }"></c:param>				
				<c:param name="query.highprice"  value="${fy.query.highprice }"></c:param>				
				<c:param name="query.lowprice"  value="${fy.query.lowprice }"></c:param>
	
			</c:url>

			<a href="${Url }&page=1">首页</a>
			<c:choose>
				<c:when test="${fy.page==1 }">
					上一页
				</c:when>
				<c:otherwise>
					<a href="${Url }&page=${fy.page-1}">上一页</a>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${fy.page==fy.pageCount }">
					下一页
				</c:when>
				<c:otherwise>
					<a href="${Url }&page=${fy.page+1}">下一页</a>
				</c:otherwise>
			</c:choose>
			<a href="${Url }&page=${fy.pageCount}">尾页</a>
  
  </body>
</html>