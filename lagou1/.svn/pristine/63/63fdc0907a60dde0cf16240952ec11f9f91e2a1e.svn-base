<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<body>
     <form action="jobdeliver/findByResumeStatus.action" method="post">
		 状态编号:<input type ="text" name="status">
		<input type="submit" value="提交">
	









	<%-- <form action="jobdeliver/findById.action" method="post">
		用户编号：<input name="resumeinfo.resumeId">
		<input type="submit" value="提交">
	<table>
		<tr>
			<th>提交的简历编号</th>
			<th>提交的简历名称</th>
		</tr>
		<c:forEach items="${requestScope.jobdeliverList}" var="job">
		    <tr>
				<td>${job.deliverId }</td>
				<td>${job.resumestatus.statusName }</td>
			</tr>
		</c:forEach>
	</table>
 --%>
<%-- 	<form action="jobdeliver/findByResumeStatus.action" method="post">
		用户编号：<input name="userinfo.userinfoId">
		<input type="submit" value="提交">
	</form>
	<table>
		<tr>
			<th>提交的简历编号</th>
			<th>提交的简历名称</th>
		</tr>
		<c:forEach items="${requestScope.jobdeliverList}" var="job">
		    <tr>
				<td>${job.deliverId }</td>
				<td>${job.resumestatus.statusName }</td>
			</tr>
		</c:forEach>
	</table>
 --%>
	<!--      <form action="jobdeliver/save.action" method="post"  name="transientInstance.resumestatus.statusId?statusId=2">
       投递编号：<input name="transientInstance.resumeinfo.resumeId">
        投递者：<input name="transientInstance.jobinfo.jobId"> 
        <input type="hidden"  name="transientInstance.resumestatus.statusId" value="2">
       <input type="submit" value="保存">  
    </form>-->
</body>
</html>

		<!--      状态号：<input name="status"> -->