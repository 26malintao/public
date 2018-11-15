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
    <title>咨询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	//获取二级分类
	$(function(){
		$("#p").change(function(){
			var classifyid=$("#p :selected").val();
			if(classifyid>0){
				$.ajax({
					url:"ca/tocst",
					type:"post",
					dataType:"json",
					data:{"classifyid":classifyid},
					success:function(data){
						$("#c option:gt(0)").remove();
						$.each(data,function(i,n){
							$("#c").append("<option value="+n.classifyid+">"+n.classifyname+"</option>");
						});
					}
				});
			}
		});
	});
	</script>
  </head>
  <body>
		<h2>客户服务中心</h2>
		<a href="">投诉</a> &nbsp;<a href="ca/gofy.action">咨询</a>&nbsp;<a href="">建议</a>&nbsp;<a href="">分类管理</a>&nbsp;<a href="">用户管理</a>&nbsp;<a href="">站内信管理</a></br>
	<form action="ca/gofy.action" method="post">
		用户编号:<input type="text" name="cc.cuserId" value="${fy.cc.cuserId }"/> 
			  
		时间:<select id="time" name="cc.timeId"  >
					<option value="0">---时间----</option>
				
					<option value="1" ${fy.cc.timeId==1?"selected":"" }>--提交时间--</option>
					<option value="2" ${fy.cc.timeId==2?"selected":"" }>--回复时间--</option>&nbsp;&nbsp;&nbsp;&nbsp;
					
					<input type="date" name="sTime" value="<fmt:formatDate value='${fy.cc.sTime }' pattern='yyyy-MM-dd'/>">--
					<input type="date" name="eTime" value="<fmt:formatDate value='${fy.cc.eTime }' pattern='yyyy-MM-dd'/>">
			</select>  	
			
		状态:<select id="state" name="cc.cstateId">
					<option value="0">--状态--</option>
					<c:forEach items="${stateList}"  var="sl">
						<option value="${sl.stateId }" ${sl.stateId==fy.cc.cstateId?'selected':'' }>${sl.stateContent}</option>									
					</c:forEach> 
			  </select>
		来源渠道:<select id="canal" name="cc.ccanalId"  >
					<option value="0">--请选择--</option>
					<c:forEach items="${channelList}"  var="ch">
						<option value="${ch.channelid }" ${ch.channelid==fy.cc.ccanalId?'selected':'' }>${ch.cname}</option>			
						
					</c:forEach> 
			  </select> 
		一级分类:&nbsp;<select id="p" name="cc.cclassifyid">
							<option value="">--一级分类--</option>
							<c:forEach items="${cstClassifyList}" var="c">
								<option value="${c.classifyid }" <c:if test="${c.classifyid==fy.cc.cclassifyid }">selected='selected'</c:if>>${c.classifyname }</option>
							</c:forEach>
					</select> 
								
		二级分类:&nbsp;<select id="c" name="cc.cclassifyid1">
						<option value="">--二级分类--</option>
					</select>
			  
		<input type="submit" value="筛选"> 
	</form>
	
	
	<table id="tb" bordercolor="gray" border="1" width="80%" cellspacing="0" >
		<tr align="center">
			<td>选择</td>
			<td>序号</td>
			<td>标题</td>
			<td>状态</td>
			<td>来源渠道</td>
			<td>咨询分类</td>
			<td>提交用户</td>
			<td>提交时间</td>	 
			<td>最后回复时间</td>					 
		<c:if test="${empty consultlist}">
				<tr>
					<td colspan="9">没有查询到数据</td>
				</tr>	
		</c:if>
					
		<c:if test="${consultlist!=null }">		
  			<c:forEach items="${consultlist }" var="ct">		
				<tr align="center">	
					<td><input type="checkbox" value="${ct.consultId}" class="check" name="box"></td>
					<td>${ct.consultId}</td>
					<td><a href="ca/gopage?consultId=${ct.consultId}&channelid=${ct.channelid}&stateId=${ct.stateId}&userid=${ct.userid}">${ct.consultTitle}</a></td>	
					<td>${ct.state.stateContent} </td>					
					<td>${ct.channel.cname}</td>		
					<td>${ct.classify.classifyname}</td>
					<td>${ct.customer.realname}</td>	 	
					<td>
						<fmt:formatDate value="${ct.consultTime}" pattern="yyyy-MM-dd HH-mm-ss" />
					 </td>	
					<td>
						<fmt:formatDate value="${ct.replayTime}" pattern="yyyy-MM-dd HH-mm-ss" />
					 </td>				
				</tr>
			</c:forEach>
		</c:if>  
		 
	</table>
	<c:url var="Url" value="ca/gofy.action">
		<c:param name="cc.cuserId" value="${fy.cc.cstateId }"></c:param>
				<c:param name="cc.cstateId" value="${fy.cc.cstateId }"></c:param>
				<c:param name="cc.ccanalId" value="${fy.cc.ccanalId }"></c:param>
				
				<c:param name="cc.cclassifyid" value="${fy.cc.cclassifyid}"></c:param>
				
			<%-- <c:param name="cc.sTime">
					<fmt:formatDate value='${fy.cc.sTime }' pattern='yyyy-MM-dd HH-mm-ss'/>
				</c:param>
				<c:param name="cc.eTime">
					<fmt:formatDate value='${fy.cc.eTime }' pattern='yyyy-MM-dd HH-mm-ss'/>
				</c:param> --%>
				
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