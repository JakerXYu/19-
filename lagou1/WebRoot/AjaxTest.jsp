<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AjaxTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		$("#haha").click(function() {
			$.ajax({
				type : "POST",/* post和get的区别就是get可能取到缓存数据 */
				url : "/lagou1/ajax/showuser.action",
				data : {
				name:"hehe",
				pass:123/* 所提交给action的数据 */
				},
				dataType : "json",/* 一般有json，text,xml等。。。。 */
				success : function(data) {/* data就是action传回的值 */
					alert("jsonText对象："+data);
					var msg=data.replace(/\\/g,'');
					alert(msg);
					$("#show").html(msg);
					/* var json=eval(data);
					alert(json); */
					/*  var show = document.getElementById("#show");
					 show.html(data); */
					/* show.innerText=; */
				}
			});
		});
	});
	</script>
	<script type="text/javascript">
		$(function(){
			$("#myBtn").click(function(){
				alert($(this).val());
				$("#show").html("???");
			});
		});
	</script>
  </head>
  
  <body>
  	<span id="show">${ sessionScope.userinfo.userinfoUsername }</span>
    <!-- input type="button" id="haha" value="显示当期用户"/><br> -->
    <span id="haha">显示当前用户</span>
    <br>
    <input type="button" value="点点点" id="myBtn">
  </body>
</html>
