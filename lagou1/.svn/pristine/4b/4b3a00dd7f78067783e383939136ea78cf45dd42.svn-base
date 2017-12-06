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

<title>My JSP 'show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px;
	text-align: left;
}

.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}

.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" background="images/tab_05.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="30"><img src="images/tab_03.gif"
							width="12" height="30" /></td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td width="46%" valign="middle"><table width="100%"
											border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="5%"><div align="center">
														<img src="images/tb.gif" width="16" height="16" />
													</div></td>
												<td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[基础数据管理]-[<a
													href="${pageContext.request.contextPath }/admin/goods/findbypage.do">商品管理</a>]-[保存新商品]</td>
											</tr>
										</table></td>
									<td width="54%">&nbsp;</td>
								</tr>
							</table></td>
						<td width="16"><img src="images/tab_07.gif" width="16"
							height="30" /></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="8" background="images/tab_12.gif">&nbsp;</td>
						<td>
						<!-- 需去掉enctype="multipart/form-data"属性，该属性为上传文件时需添加的 -->
						${ requestScope.error }
						<form action="${pageContext.request.contextPath }/admin/goods/saveGds.servlet"
								 method="post" name="savegoodsform" enctype="multipart/form-data"
								id="savegoodsform">
								<table width="400" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="b5d6e6">
									<tr>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF">
											<div align="right">
												<span class="STYLE1">商品名称：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF">
											<div align="left">
												<span class="STYLE1"> 
													<input type="text" name="goodsName" id="goodsName">
												</span>
											</div></td>
									</tr>
									<tr>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF">
											<div align="right">
												<span class="STYLE1">商品价格：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF">
											<div align="left">
												<span class="STYLE1"> 
													<input type="text" name="goodsPrice" id="goodsPrice">
												</span>
											</div></td>
									</tr>
									<tr>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF">
											<div align="right">
												<span class="STYLE1">商品数量：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF">
											<div align="left">
												<span class="STYLE1"> 
													<input type="text" name="goodsNum" id="goodsNum">
												</span>
											</div></td>
									</tr>
									<tr>
									<script type="text/javascript">
										$(function(){
											//页面加载成功后加载一级类型
											$.ajax({
												data : {
													"typeLv" : "1"
												},
												dataType : "json",
												success : function(msg){
													alert(msg);
													var goodsType_f = document.getElementById("goodsType_f");
													for(var i=0;i<msg.length;i++){
														var opt = new Option();
														opt.value = msg[i].typeId;
														opt.text = msg[i].typeName;
														goodsType_f.options.add(opt);
													}
													
													
													
													$("#goodsType_f").change();
												},
												type : "post",
												url : "typeFindByLv.servlet"
											});
											
											
											
											//一级类型改变时加载二级类型
											$("#goodsType_f").change(function(){
												$.ajax({
													data : {
														"typePid" : $("#goodsType_f").val()
													},
												dataType : "json",
												success : function(msg){
													alert(msg);
													var goodsType_s = document.getElementById("goodsType_s");
													for(var i=0;i<msg.length;i++){
														var opt = new Option();
														opt.value = msg[i].typeId;
														opt.text = msg[i].typeName;
														goodsType_s.options.add(opt);
													}
												},
												type : "post",
												url : "typeFindByPid.servlet"
												});
											});
											
											
										});
									</script>
									
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF">
											<div align="right">
												<span class="STYLE1">商品类型（一级）：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF">
											<div align="left">
												<span class="STYLE1"> 
												
												<select name="goodsType" id="goodsType_f">
													<!--<c:forEach items="${applicationScope.typeList }" var="type">
														<option value="${type.typeId }">${type.typeName }</option>
													</c:forEach>-->
													
												</select>
												</span>
											</div></td>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF">
											<div align="right">
												<span class="STYLE1">商品类型（二级）：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF">
											<div align="left">
												<span class="STYLE1"> 
												
												<select name="goodsType" id="goodsType_s">
													<!--<c:forEach items="${applicationScope.typeList }" var="type">
														<option value="${type.typeId }">${type.typeName }</option>
													</c:forEach>-->
												</select>
												</span>
											</div></td>
									</tr>
									<tr>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF"><div
												align="right">
												<span class="STYLE1">商品图片：</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF"><div
												align="left">
												<span class="STYLE1"> <input type="file"
													name="goodsImg" id="goodsImg">
												</span>
											</div></td>
									</tr>
									<tr>
										<td width="34%" height="19" align="right" bgcolor="#FFFFFF"><div
												align="right">
												<span class="STYLE1">&nbsp;</span>
											</div></td>
										<td width="66%" height="19" align="left" bgcolor="#FFFFFF"><div
												align="left">
												<span class="STYLE1"> <input type="submit" value="保存">
												</span> <input type="reset" name="button" id="button" value="重置">
											</div></td>
									</tr>
								</table>
							</form></td>
						<td width="8" background="images/tab_15.gif">&nbsp;</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="35" background="images/tab_19.gif"><table
					width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="12" height="35"><img src="images/tab_18.gif"
							width="12" height="35" /></td>
						<td><table width="100%" border="0" cellspacing="0"
								cellpadding="0">
								<tr>
									<td class="STYLE4">&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</table></td>
						<td width="16"><img src="images/tab_20.gif" width="16"
							height="35" /></td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
