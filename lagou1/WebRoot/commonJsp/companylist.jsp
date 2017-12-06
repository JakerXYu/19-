﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<base href="<%=basePath%>">
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>全国-公司列表-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="全国condition-condition-公司列表-拉勾网-最专业的互联网招聘平台" name="description">
<meta content="全国condition-公司列表-拉勾网-最专业的互联网招聘平台" name="keywords">
<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<link rel="stylesheet" type="text/css" href="style/css/external.min.css"/>
<link rel="stylesheet" type="text/css" href="style/css/popup.css"/>
<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script src="style/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/additional-methods.js"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>
<body>
<div id="body"><form></form>
	<div id="header">
    	<div class="wrapper">
    		<a href="index.jsp" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
    			<li ><a href="/lagou1/index.jsp">首页</a></li>
    			<li class="current"><a href="companyinfo/findbysearch.action" >公司</a></li>
    			<c:if test="${not empty sessionScope.userinfo }">
    			<li ><a href="jobSeeker/myResume.jsp" rel="nofollow">我的简历</a></li>
    			</c:if>
    				    			<c:if test="${not empty sessionScope.companyinfo }">
	    							    			<li ><a href="HR/createResume.jsp" rel="nofollow">发布职位</a></li></c:if>
	    		    		</ul>
        	            <ul class="loginTop">
            	<li>
            	<c:choose>
            	<c:when test="${  sessionScope.userinfo eq null and sessionScope.companyinfo eq null}">
            	<a href="commonJsp/login.jsp" rel="nofollow">登录</a>
            	<a href="commonJsp/register.jsp" rel="nofollow">注册</a>
            	</c:when>
            	<%-- <c:when test="true"> test="${  sessionScope.userinfo is not empty or sessionScope.companyinfo is not empty}">
            	<span>
            	${ sessionScope.userinfo.userinfoUsername }${ sessionScope.companyinfo.companyName }，欢迎你！
            	</span>
            	</c:when> --%>
            	<c:otherwise>
            	${ sessionScope.userinfo.userinfoUsername }${ sessionScope.companyinfo.companyName }，欢迎你
            	|<a href="jobSeeker/exit.action" rel="nofollow">退出</a>
            	</c:otherwise>
            	</c:choose></li> 
            	<!-- <li>|</li>
            	<li><a href="commonJsp/register.jsp" rel="nofollow">注册</a></li> -->
            </ul>
                                </div>
    </div><!-- end #header -->
    <div id="container">
        
        <div class="clearfix">
            <div class="content_l">
            	<form id="companyListForm" name="companyListForm" method="get" action="h/c/companylist.jsp">
	                <input type="hidden" id="city" name="city" value="全国" />
	                <input type="hidden" id="fs" name="fs" value="" />
	                <input type="hidden" id="ifs" name="ifs" value="" />
	                <input type="hidden" id="ol" name="ol" value="" />
	                <dl class="hc_tag">
	                    <dt>
	                       <!--  <h2 class="fl">热门公司</h2> -->
	                   
                                	                                <dl>
	                            <dt>地点：</dt>
	                            <dd><c:forEach items="${applicationScope.citylist }" var="city">
	                                	                                			                                <a href="companyinfo/findbysearch.action?cityId=${city.cityName }">${city.cityName }</a>
		                                	                                	                                			                             
		                                	                                	                           </c:forEach> 		                            
		                                	                                	                            </dd>
		                                	                                	                            </form>
	                        </dl>
	             
	                     </dd>
	                                                           
	                
	                    <dd>
	                        <dl>
	                            <dt>发展阶段：</dt>
	                            <dd><c:forEach items="${applicationScope.stagelist }" var="stage">
	                            			                            			                                <a href="companyinfo/findbysearch.action?stageId=${stage.stageId }">${stage.stageName }</a>
		                                	                                		                            			                           
		                                	       
		                                	       </c:forEach>
		                                	                                	                            </dd>
	                        </dl>
	                        <dl>
	                            <dt>行业领域：</dt>
	                            <dd><c:forEach items="${applicationScope.fieldlist }" var="field">
	                                	                                			                                <a href="companyinfo/findbysearch.action?fieldId=${field.fieldId }">${field.fieldName }</a>
		                                	                                	                                			                             
		                                	                                	                           </c:forEach>     			                            
		                                	                                	                            </dd>
		                                	                                	                            </form>
	                        </dl>
	             
	                     </dd>
		                      
		                      <c:forEach items="${requestScope.companylist }" var="company">	                    		                       
		                        	 <li >
			                        <a href="${company.companysize }" target="_blank">
			                        	<h3 title="${company.companyName }">${company.companyName }</h3>
			                        	
				                        	<ul>
				                        		<li>${company.companyfield.fieldName }</li>
				                        		<li>${company.companyAddress },${company.companystage.stageName }</li>
				                        	
			                        	
			                        </a><c:forEach items="${company.jobinfos }" var="job">
			                        			                        	<li><a href="h/jobs/148976.jsp" target="_blank">${job.jobName }</a>
			                        			                        	
			                        			                        	</c:forEach></ul>

			                    
			                    </li></c:forEach>
		                        		                    		                             
		                       
		                		              
		                		               	<div class="Pagination"></div>
		               		                               
           
            </div>
            	
            <div class="content_r">
            	<div class="subscribe_side">
	            	<a href="" target="_blank">
	                    <div class="subpos"><span>订阅</span> 职位</div>
	                    <div class="c7">拉勾网会根据你的筛选条件，定期将符合你要求的职位信息发给你
	                    </div>
	                    <div class="count">已有
	                    		                    		<em>3</em>
	                    		                    		<em>4</em>
	                    		                    		<em>2</em>
	                    		                    		<em>1</em>
	                    		                    		<em>0</em>
	                    		                    	人订阅
	                    </div>
	                    <i><a href="jobSeeker/findsession.action">我也要订阅职位</a></i>
	            	</a>
	            </div> 
                <div class="greybg qrcode mt20">
                	<img src="style/images/companylist_qr.png" width="242" height="242" alt="拉勾微信公众号二维码" />
                    <span class="c7">扫描拉勾二维码，微信轻松搜工作</span>
                </div>
               	<!-- <a href="h/speed/speed3.jsp" target="_blank" class="adSpeed"></a> -->
                <a href="h/subject/jobguide.jsp" target="_blank" class="eventAd">
               		<img src="style/images/subject280.jpg" width="280" height="135" />
               	</a>
               	<a href="h/subject/risingPrice.jsp" target="_blank" class="eventAd">
               		<img src="style/images/rising280.png" width="280" height="135" />
               	</a>
            </div>
       	</div>
   	
   	<input type="hidden" value="" name="userid" id="userid" />
      
<script type="text/javascript" src="style/js/company_list.min.js"></script>
<script>
$(function(){
	/*分页 */
 	 	 				 		$('.Pagination').pager({
	      currPage: 1,
	      pageNOName: "pn",
	      form: "companyListForm",
	      pageCount: 20,
	      pageSize: 5
	});	
})
</script>       	
			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="" />
	    	<a id="backtop" title="回到顶部" rel="nofollow"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a href="h/about.jsp" target="_blank" rel="nofollow">联系我们</a>
		    <a href="h/af/zhaopin.jsp" target="_blank">互联网公司导航</a>
		    <a href="http://e.weibo.com/lagou720" target="_blank" rel="nofollow">拉勾微博</a>
		    <a class="footer_qr" href="javascript:void(0)" rel="nofollow">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a target="_blank" href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script type="text/javascript" src="style/js/core.min.js"></script>
<script type="text/javascript" src="style/js/popup.min.js"></script>

<!--  -->

</body>
</html>