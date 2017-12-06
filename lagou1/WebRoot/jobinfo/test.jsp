<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#myBtn").click(function() {
			$.ajax({
				type : "POST",
				url : "jobinfo/findnew.action",
				data : {
				},
				dataType : "json",
				success : function(data) {
					alert(data);
					var msg = eval("("+data+")");
					 var data_body = document.getElementById("data_body");
					$("#data_body").html("");
					for (var i = 0; i < msg.length; i++) {
						var new_row = data_body.insertRow();
						
						var new_cell_2 = new_row.insertCell();
						var new_cell_3 = new_row.insertCell();
						var new_cell_4 = new_row.insertCell();
						var new_cell_5 = new_row.insertCell();
						var new_cell_6 = new_row.insertCell();
						var new_cell_7 = new_row.insertCell();
						var new_cell_8 = new_row.insertCell();
						var new_cell_9 = new_row.insertCell();
						var new_cell_10 = new_row.insertCell();
						var new_cell_11 = new_row.insertCell();
						var new_cell_12 = new_row.insertCell();
						var new_cell_13 = new_row.insertCell();
						var new_cell_14 = new_row.insertCell();
						var new_cell_15 = new_row.insertCell();
						
						new_cell_2.innerHTML = msg[i].jobedu.eduName;
						new_cell_3.innerHTML = msg[i].jobtype.typeName;
						new_cell_4.innerHTML = msg[i].jobstatus.statusName;
						new_cell_5.innerHTML = msg[i].jobprop.propName;
						new_cell_6.innerHTML = msg[i].jobexp.expName;
						new_cell_7.innerHTML = msg[i].jobLowsal;
						new_cell_8.innerHTML = msg[i].jobHighsal;
						new_cell_9.innerHTML = msg[i].jobName;
						new_cell_10.innerHTML = msg[i].jobDepartment;
						new_cell_11.innerHTML = msg[i].jobCity;
						new_cell_12.innerHTML = msg[i].jobAdvantage;
						new_cell_13.innerHTML = msg[i].jobDescripe;
						new_cell_14.innerHTML = msg[i].jobAddress;
						new_cell_15.innerHTML = msg[i].jobEmail;
						
					} 
				}
			});
		});
	});
</script>
</head>
</head>

<body>
	全部职位信息
	<br>
	<table border="1px">

		<tr>
			<td>Id</td>
			<td>eduName</td>
			<%-- <td> companyinfo;</td> --%>
			<td>typeName</td>
			<td>statusName</td>
			<td>propName</td>
			<td>expName</td>
			<td>Lowsal</td>
			<td>Highsal</td>
			<td>Name</td>
			<td>Department</td>
			<td>City</td>
			<td>Advantage</td>
			<td>Descripe</td>
			<td>Address</td>
			<td>Email</td>
		</tr>
		<c:forEach items="${requestScope.jobinfoList}" var="jobinfo">
			<tr>
				<td>${jobinfo.jobId}</td>
				<td>${jobinfo.jobedu.eduName}</td>

				<td>${jobinfo.jobtype.typeName}</td>
				<td>${jobinfo.jobstatus.statusName}</td>
				<td>${jobinfo.jobprop.propName}</td>
				<td>${jobinfo.jobexp.expName}</td>
				<td>${jobinfo.jobLowsal}</td>
				<td>${jobinfo.jobHighsal}</td>
				<td>${jobinfo.jobName}</td>
				<td>${jobinfo.jobDepartment}</td>
				<td>${jobinfo.jobCity}</td>
				<td>${jobinfo.jobAdvantage}</td>
				<td>${jobinfo.jobDescripe}</td>
				<td>${jobinfo.jobAddress}</td>
				<td>${jobinfo.jobEmail}</td>
				<!--  <td> Timestamp jobStartTime;</td>
	 <td> Timestamp jobEndTime;</td> -->

			</tr>
		</c:forEach>
	</table>

	<hr>
	<input type="button" value="最新" id="myBtn">
	<br> 最新职位信息
	<br>
	<table border="1px" >
	<thead>
		<tr>
			<td>eduName</td>
			<%-- <td> companyinfo;</td> --%>
			<td>typeName</td>
			<td>statusName</td>
			<td>propName</td>
			<td>expName</td>
			<td>Lowsal</td>
			<td>Highsal</td>
			<td>Name</td>
			<td>Department</td>
			<td>City</td>
			<td>Advantage</td>
			<td>Descripe</td>
			<td>Address</td>
			<td>Email</td>
		</tr>
	</thead>
	<tbody id="data_body">
	</tbody>
	</table>
</body>
</html>
