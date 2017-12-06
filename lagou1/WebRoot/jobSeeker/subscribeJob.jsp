﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<base href="<%=basePath%>">
<!--  
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
-->
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>职位订阅-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">
<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
function getfiledId(){
var a = "aaaaaaaaaaaaaaaa";
/* var fdiv=document.getElementById("fieldId"); */
 alert(a);
}
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<link rel="stylesheet" type="text/css" href="style/css/external.min.css"/>
<link rel="stylesheet" type="text/css" href="style/css/popup.css"/>
 <script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<!-- <script type="text/javascript" src="style/js/jquery.lib.min.js"></script> -->
<!-- <script src="style/js/ajaxfileupload.js" type="text/javascript"></script>  -->

<!-- <script type="text/javascript" src="style/js/additional-methods.js"></script>
 -->
 <!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 

<script type="text/javascript" src="style/js/conv.js"></script>
</head>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a href="/lagou1/index.jsp" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
    			<li><a href="/lagou1/index.jsp">首页</a></li>
    			<li><a href="companyinfo/findbysearch.action">公司</a></li>
    				    			<li><a rel="nofollow" href="myResume.jsp">我的简历</a></li>
	    							    			<li ><a href="/lagou1/HR/createResume.jsp" rel="nofollow">发布职位</a></li>
	    		    		</ul>
        	            <ul class="loginTop">
            	<li><a href="/lagou1/commonJsp/login.jsp" rel="nofollow">登录</a></li> 
            	<li>|</li>
            	<li><a href="/lagou1/commonJsp/register.jsp" rel="nofollow">注册</a></li>
            </ul>
                                </div>
    </div><!-- end #header -->
    <div id="container">
        	  	
        <div class="clearfix">
            <div class="content_l">
            	<h1>我的职位订阅</h1>
            	            		            
	           <!--      -->
          		<input type="hidden" id="orderCount" value="0" />
          	
                <form id="subForm" action="/lagou1/jobSeeker/save.action"  method="post">
                	<input type="hidden" value="" name="id" id="orderId" />
	                <div class="s_form">
	                	<p>筛选下面的职位订阅条件，实现精准匹配的个性化职位定制，我们帮你挑工作！</p>
	                    <dl>
	                    	<dt>
	                        	<h3> <i class="rss_circle"></i>&nbsp; 发送周期 <em></em><span>（必填）</span></h3>
	                        </dt>
	                        <!-- <dd>
	                        	<input type="text" id="subEmail" name="email" placeholder="请输入接收邮箱" value="" />	
	                        	<span id="emailError" class="error" style="display:none;">请输入接收邮箱</span>
	                           
	                        </dd> -->
	                        
	                         <script>
	                    function getweekday(li_obj){
	                    var input_obj=document.getElementById("weekday");
						input_obj.value=li_obj.value;
	                    }
	                    </script>
	                        <dd>
	                        <input type="hidden" id="weekday" name="weekday" value="" /><!--隐藏域-->
	                        	<input type="hidden" id="select_day_hidden" name="sendMailPer" value="" />
	                       		<ul class="s_radio clearfix">
	                       				                            		<li title="3" value="3" onclick="getweekday(this)">3天</li>
	                            		                            		<li title="7" value="7" onclick="getweekday(this)">7天</li>
	                            		                            </ul> 	
	                            <span id="sendError" class="error" style="display:none;">请选择发送周期</span>
	                        </dd>
	                    </dl>
	                      <script>
	                    function getjobtypeId(li_obj){
	                    var input_obj=document.getElementById("jobtypeId");
						input_obj.value=li_obj.value;
	                    }
	                    </script>
	                    <dl>
	                    	<dt>
	                        	<h3>职位名称 <em></em><span>（必填）</span></h3>	
	                        <input type="hidden" id="jobtypeId" name="jobtypeId" value="" /><!--隐藏域-->
	                        	
	                        </dt>
	                        <dd>
	                        	<input type="hidden" id="select_job_hidden" name="positionName" value="" />
	                       		<input type="button" class="select" id="select_job" value="请选择职位名称" />
	                       		
	                            <div id="sub_box_job" class="dn">

		                            		                            	
		                           <c:forEach items="${applicationScope.typelvlist }" var="lvlist">
		                                    <dl>
			                                	<dt>${lvlist.typeName }</dt>
			                                	<dd>
			                                    	<ul class="reset job_main">
	              										<li> ${lvlist.typeName } <ul class="reset job_sub dn" >
	               				                               <c:forEach items="${lvlist.jobtypes }" var="path">
	               												<li value="${path.typeId }" onclick="getjobtypeId(this)">${path.typeName }</li>
	               												</c:forEach>
	                                                           </ul>
	                   			                         </li>
				                                    </ul>         			                                   
				                                                			                                 
			                                    </dd>
			                                    
			                                </dl>
		                              </c:forEach>
		                            	                            </div>
	                            <span id="positionError" class="error" style="display:none;">请选择职位类型 </span>		
	                        </dd>
	                    </dl>
	                    
	                    
	                    <script>
	                    function getcityId(li_obj){
	                    var input_obj=document.getElementById("cityId");
						input_obj.value=li_obj.value;
	                    }
	                    </script>
		                            	                         
	                    <dl>
	                    	<dt>
	                        	<h3>工作地点 <em></em><span>（必填）</span></h3>
	                        	<input type="hidden" id="cityId" name="cityId" value="" /><!--隐藏域-->
	                        	
	                        </dt>
	                        <dd>
	                        	<input type="hidden" id="select_city_hidden" name="city" value="" />
	                            <ul class="s_radio clearfix">
	                            		            <li title="北京" value="1" onclick="getcityId(this)">北京</li>
      			                            		<li title="上海" value="30" onclick="getcityId(this)">上海</li>
      			                            		<li title="成都" value="3" onclick="getcityId(this)">成都</li>
      			                            		<li title="广州" value="12" onclick="getcityId(this)">广州</li>
      			                            		<li title="深圳" value="34" onclick="getcityId(this)">深圳</li>
	                            			        <li title="杭州" value="16" onclick="getcityId(this)">杭州</li>
	                            			                            		                            </ul> 	
	                            <span id="cityError" class="error" style="display:none;">请选择工作地点 </span>	
	                        </dd>
	                    </dl>
	                    
	                    
	                    <script>
	                    function getstageId(li_obj){
	                    var input_obj=document.getElementById("stageId");
						input_obj.value=li_obj.value;
	                    }
	                    </script>

	                    <dl>
	                    	<dt>
	                        	<h3>发展阶段 <em></em></h3>
	                        <input type="hidden" id="stageId" name="stageId" value="" /><!--隐藏域-->
	                        	
	                        </dt>
	                        <dd>
	                        	<input type="hidden" id="select_stage_hidden" name="financeStage" value="" />
	                        	<ul class="s_tips clearfix s_radio_sp">
	                        	<c:forEach items="${applicationScope.stagelist }" var="stage">
	                            		                            		<li value="${stage.stageId }" onclick="getstageId(this)">${stage.stageName }</li>
	                            		                            		</c:forEach>
	                            		                            	
	                            		                            </ul> 
	                            <span id="stageError" class="error" style="display:none;">请选择发展阶段 </span>		
	                        </dd>
	                    </dl>
	                    
	                    <script type="text/javascript">
						function getfieldId(li_obj){
						
						var input_obj = document.getElementById("fieldId");
						input_obj.value = li_obj.value;
				
						}
						</script>
	                    <dl>
	                    	<dt>
	                        	<h3>行业领域 <em></em></h3>
	                        	<input type="hidden" id="fieldId" name="fieldId" value="" /><!--隐藏域-->
	                        </dt>
	                        <dd>
	                        	<input type="hidden" id="select_industry_hidden" name="industryField" value="" />
	                            <input type="button" class="select" id="select_industry" value="请选择行业领域" />
	                            <div id="box_industry" class="dn">
	                          		
	                            	<ul class="reset"><c:forEach items="${applicationScope.fieldlist }" var="field">
	                                		                                		<li value=${field.fieldId } onclick="getfieldId(this)">${field.fieldName }</li></c:forEach>
	                                		                              
	                                		                                </ul>
	                            </div>
	                            <span id="fieldError" class="error" style="display:none;">请选择行业领域 </span>	
	                        </dd>
	                    </dl>
	                    
	                    <script>
	                    function getsalId(li_obj){
	                    var input_obj = document.getElementById("salId");
	                    input_obj.value = li_obj.value;
	                    }
	                    </script>
	                    <dl>
	                    	<dt>
	                        	<h3>月薪范围 <em></em></h3>
	                      	<input type="hidden" id="salId" name="salId" value="" /><!--隐藏域-->
	                        	
	                        </dt>
	                        <dd>
	                        	<input type="hidden" id="select_salary_hidden" name="salary" value="" />
	                            <input type="button" class="select" id="select_salary" value="请选择月薪范围" />
	                            <div id="box_salary" class="dn">
	                            	<ul class="reset"><c:forEach items="${applicationScope.sallist }" var="sal">
	                                		                                		<li value="${sal.salId }" onclick="getsalId(this)">${sal.salMin }k-${sal.salMax }k</li></c:forEach>
	                                		                        
	                                		                                </ul>
	                            </div>
	                       		<!-- <div>
	                                <input type="text" name="salaryMin" id="salary_low" placeholder="最低月薪" /> 
	                                <span>k</span>
	                            </div>
	                       		<div>
	                                <input type="text" name="salaryMax" id="salary_high" placeholder="最高月薪" /> 
	                                <span>k</span>
	                            </div>
	                            <span>请输入整数，如：4</span> -->
	                            <span id="salaryError" class="error" style="display:none;">请选择月薪范围 </span>	
	                        </dd>
	                    </dl>
	                    <span id="commonError" class="error" style="display:none;">系统异常</span>
	                    <input type="submit" class="btn_big" id="subSubmit" value="保 存" />
	                    <a href="javascript:void(0)" class="btn_cancel">取 消</a>
	                </div>
	        	</form>
            </div>	
            <div class="content_r">
            	<div class="subscribe_side mb20 c5">
                    <div class="why">我们为什么强烈推荐你</div>
                    <h2>订阅</h2>
                    <ul class="reset">
                    	<li class="sub1">帮助你节省浏览和筛选时间，快速找到适合的职位信息。</li>
                    	<li class="sub2">我们会严格按照你订阅的频次和条件给你发送邮件，并对你的个人信息绝对保密。</li>
                    </ul>
                </div>
            </div>
       	</div>
      <input type="hidden" value="" name="userid" id="userid" />

<!------------------------------------- 弹窗lightbox ----------------------------------------->
<div style="display:none;">	
	<!-- 
		登录帐号订阅成功
		1、已登录用户，且是自有用户，已验证，订阅职位<=1，提示订阅成功；接收邮箱默认为登录邮箱，可修改。
		2、已登录用户，但是第三方用户，订阅职位<=1，提示订阅成功；接收邮箱手动输入可修改。
		未登录帐号订阅成功 
		未登录用户，但填写的邮箱为已注册、已验证邮箱，且订阅职位<=1，订阅成功，点击确定显示登录框
	-->
		<div id="subscribeSuccessLogined" class="popup">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a></a>，请注意查收。</p>
            <table width="100%">
            	<tr>
                	<td align="center"><a href="subscribeJob.jsp" class="btn_s">确&nbsp;定</a></td>
                </tr>
            </table>
        </div><!--/#subscribeSuccessLogined-->
   	
   	<!-- 
		未登录未注册帐号订阅成功
		提示注册框
	-->
		<div id="subscribeSuccessRegister" class="popup" style="height:370px;">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a><em></em></a>，请注意查收。</p>
        	<hr>
        	<p>现在只需设置密码就可成功注册拉勾，并可长期保存及管理订阅信息。</p>
        	<form id="registerPopForm">
	            <table width="100%">
	            	<tr>
	                	<td>注册邮箱 :</td>
	                	<td><em></em></td>
	                </tr>
	                <tr>
	                	<td valign="top">注册密码 :</td>
	                	<td>
	                		<input type="password" name="password" id="psw"  placeholder="请输入注册密码" />
	                		<span class="error" style="display:none;" id="beError_register"></span>
	                	</td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td>
	                		<label class="fl" for="checkbox">
	                			<input type="checkbox" id="checkbox" name="checkbox" checked  class="checkbox valid" />
	                			我已阅读并同意<a href="h/privacy.jsp" target="_blank">《拉勾用户协议》</a>
	                		</label>
	                	</td>
	                </tr>
	            	<tr>
	            		<td></td>
	                	<td>
	                		<input type="submit" class="btn_s" value="注 册" />
	                	</td>
	                </tr>
	            </table>
	        </form>
        </div><!--/#subscribeSuccessRegister-->
        
     <!-- 
		未登录注册帐号订阅成功
		弹出框有登录按钮，提示登录
	-->
		<div id="subscribeSuccessLogin" class="popup">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a></a>，请注意查收。</p>
            <table width="100%">
            	<tr>
                	<td align="center"><a href="#loginPop" class="btn inline" title="登录">登 录</a></td>
                </tr>
            </table>
        </div><!--/#subscribeSuccessLogin-->
		
     <!-- 登录框 -->
	<div id="loginPop" class="popup" style="height:240px;">
       	<form id="loginForm">
			<input type="text" id="email" name="email" tabindex="1" placeholder="请输入登录邮箱地址" />
			<input type="password" id="password" name="password" tabindex="2" placeholder="请输入密码" />
			<span class="error" style="display:none;" id="beError"></span>
		    <label class="fl" for="remember"><input type="checkbox" id="remember" value="" checked="checked" name="autoLogin" /> 记住我</label>
		    <a href="/lagou1/commonJsp/updatePwd.jsp" class="fr" target="_blank">忘记密码？</a>
		    <input type="submit" id="submitLogin" value="登 &nbsp; &nbsp; 录" />
		</form>
		<div class="login_right">
			<div>还没有拉勾帐号？</div>
			<a href="/lagou1/commonJsp/register.jsp" class="registor_now">立即注册</a>
		    <div class="login_others">使用以下帐号直接登录:</div>
		    <a href="h/ologin/auth/sina.jsp" target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>
		    <a href="h/ologin/auth/qq.jsp" class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录"></a>
		</div>
    </div><!--/#loginPop-->
    
     <!--退订-->	
    <div id="cancelSub" class="popup">
       	<h4>确认要退订该订阅？</h4>
       	<table width="100%">
       		<tr>
       			<td align="center"><p>点击确认后你将不再收到拉勾为你提供的精准职位推送。</p></td>
       		</tr>
        	<tr>
            	<td align="center">
            		<input type="button" class="btn_s" id="confirmCancel" value="确认退订" />
            		<a href="javascript:void(0)" class="btn_s">取消</a>
            	</td>
            </tr>
        </table>
    </div><!--/#cancelSub-->
</div>
<!------------------------------------- end ----------------------------------------->

<script src="style/js/sub.min.js"></script>
<!-- 退订 | 从邮箱进来订阅页  -->

<!-- 订阅成功弹出注册框 | 从邮箱进来订阅页  -->

<!-- 订阅成功弹出登录框 | 从邮箱进来订阅页  -->

<!-- 从激活页点换个邮箱进入订阅页 -->
			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="f828aecf8b80414491d138ca1190fb6d" />
	    	<a id="backtop" title="回到顶部" rel="nofollow"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a href="lagou1/commonJsp/about.jsp" target="_blank" rel="nofollow">联系我们</a>
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