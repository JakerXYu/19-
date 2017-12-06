<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<link rel="stylesheet" type="text/css" href="manager/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="manager/themes/icon.css">
<script type="text/javascript" src="manager/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="manager/js/jquery.easyui.min.js"></script>
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
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>


  </head>
  
  <body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="manager/images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="manager/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="manager/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[系统数据管理]-[角色管理]-[保存新角色]</td>
              </tr>
            </table></td>
            <td width="54%">&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="amnager/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td>${requestScope.error}<form action="${pageContext.request.contextPath}/admin/goods/save.servlet" 
        		enctype="multipart/form-data"
         		method="post" name="savegoodsform" id="savegoodsform">
          <table width="400" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" >
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">角色名称：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
                <input type="text" name="roleName" id="roleName">
                <input name="submit" type="submit" value="保存" >
</span></div></td>
            </tr>
            <tr>
              <td width="34%" height="19" align="right"  bgcolor="#FFFFFF"><div align="right"><span class="STYLE1">设置权限：</span></div></td>
              <td width="66%" height="19" align="left"  bgcolor="#FFFFFF"><div align="left"><span class="STYLE1">
              	<ul id="roleTree" class="easyui-tree" 
              		url="admin/sys/fun/loadfuntree.servlet"
					checkbox="true">
				</ul>
              </span></div></td>
            </tr>
          </table>
        </form></td>
        <td width="8" background="manager/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="manager/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="manager/images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="16"><img src="manager/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
