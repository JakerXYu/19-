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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>
<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
	<script type="text/javascript">
		function toPages(pages){ 
        	document.searchForm.pages.value = pages;
        	document.searchForm.submit();
        }
		function deleteGds(page,goodsId){
			if(confirm("是否确认删除？")){
				location.href="deleteGds.servlet?page="+page+"&goodsId="+goodsId;
			}
		}
		function toPage(p){ 
        	document.searchForm.page.value = p;
        	document.searchForm.submit();
        }
        	
        function getValue(){
             var pageValue  = document.getElementById("textfield").value;
             toPage(pageValue);
        }
        function checkAll(opt_check){
        	var checkOnly = document.getElementsByName("check_only");
        	for(var i=0;i<checkOnly.length;i++){
        		checkOnly[i].checked = opt_check.checked;
        	}
        }
	</script>
  </head>
  
  <body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[基础数据管理]-[商品类型管理]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">
              <tr>
                <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox62" id="check_all" value="checkbox" onclick="javascript:checkAll(this)"/>
                    </div></td>
                    <td class="STYLE1"><div align="center" >全选</div></td>
                  </tr>
                </table></td>
                <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center"><a href="#">新增</a></div></td>
                  </tr>
                </table></td>
                
                <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="images/11.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><div align="center">删除</div></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="images/tab_12.gif">&nbsp;</td>
        <td><span class="STYLE1">
        <form action="${ pageContext.request.contextPath }/admin/type/findAll.servlet" 
        name="searchForm" method="post">
		<input type="hidden" name="page" id="page" value="1">
		
		商品类型编号：<input name="typeId" type="text" value="${ param.typeId }" size="16">
		商品类型名称：<input name="typeName" type="text" value="${ param.typeName }" size="20"> &nbsp; 
		<input type="submit" name="button" id="button" value="查询"></form></span>
        <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
        	
          <tr>
            <td width="3%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox" value="checkbox" onclick="javascript:checkAll(this)"/>
            </div></td>
            <td width="03%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">序号</span></div></td>
            <td width="12%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">商品类型编号</span></div></td>
            <td width="14%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">商品类型名称</span></div></td>
            <td width="15%" height="19" background="images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">基本操作</span></div></td>
          </tr>
		<c:forEach items="${ requestScope.pageVO.list }" var="type" varStatus="status">
          <c:choose>
          	<c:when test="${empty requestScope.pageVO.list}">
          		<p>此次查询无商品</p>
          	</c:when>
          	<c:otherwise>
          		<tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center">
              <input type="checkbox" name="checkbox2" id="check_only" value="checkbox" />
            </div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <div align="center">
              ${ status.count }
              </div>
            </div></td>
           
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${ type.typeId }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">${ type.typeName }</span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE4"><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; 
            &nbsp;<img src="images/del.gif" width="16" height="16" /><a href="javascript:deleteGds(${requestScope.pageVO.page },${ goods.goodsId })">删除</a></span></div></td>
          </tr>
          	</c:otherwise>
          </c:choose>
          
          </c:forEach>
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;共有 ${requestScope.pageVO.recordCount }条记录，当前第 
				${requestScope.pageVO.page }/${requestScope.pageVO.pageCount }页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img src="images/first.gif" width="37" height="15" onclick="javascript:toPage(1)"/></td>
                  <td width="45"><c:choose>
                  	<c:when test="${requestScope.pageVO.page eq 1 }">
                  		<img src="images/back.gif" width="43" height="15" />
                  	</c:when>
                  	<c:otherwise>
                  		  <img src="images/back.gif" width="43" height="15" onclick="javascript:toPage(${requestScope.pageVO.page-1 })"/>
                  	</c:otherwise>
                  </c:choose></td>
                  <td width="45"><c:choose>
                  	<c:when test="${requestScope.pageVO.page eq requestScope.page.pageCount }">
                  		<img src="images/next.gif" width="43" height="15" />
                  	</c:when>
                  	<c:otherwise>
                  		<img src="images/next.gif" width="43" height="15" onclick="javascript:toPage(${requestScope.pageVO.page+1})" />
                  	</c:otherwise>
                  </c:choose></td>
                  <td width="40"><a href="javascript:toPage(${requestScope.pageVO.pageCount })"><img src="images/last.gif" width="37" height="15"/></a></td>
                  <td width="100">
                  	<div align="center"><span class="STYLE1">转到第<input name="textfield" id="textfield" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" /> 
                 	   页 </span></div></td>
                  <td width="40"><a href="javascript:getValue()"><img src="images/go.gif" width="37" height="15"  /></a></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
