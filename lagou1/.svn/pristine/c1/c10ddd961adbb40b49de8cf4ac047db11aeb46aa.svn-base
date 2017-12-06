<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns:wb="http://open.weibo.com/wb"><head>
<base href="<%=basePath%>">
</script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>职位订阅-拉勾网-最专业的互联网招聘平台</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网">
<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">http://www.lagou.com</div> -->
<script type="text/javascript">
var ctx = "http://www.lagou.com";
console.log(1);
</script>
<link href="http://www.lagou.com/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script></head>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a class="logo" href="/lagou/index.jsp">
    			<img width="229" height="43" alt="拉勾招聘-专注互联网招聘" src="style/images/logo.png">
    		</a>
    		<ul id="navheader" class="reset">
    			<li><a href="/lagou/index.jsp">首页</a></li>
    			<li><a href="companyinfo/findbysearch.action">公司</a></li>
    				    			<li><a rel="nofollow" href="myResume.jsp">我的简历</a></li>
	    						    		</ul>
        	        	<dl class="collapsible_menu">
            	<dt>
           			<span>jason&nbsp;</span> 
            		<span class="red dn" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
                                	<dd style="display: none;"><a rel="nofollow" href="myResume.jsp">我的简历</a></dd>
                	                	<dd style="display: none;"><a href="collectionsRes.jsp">我收藏的职位</a></dd>
                	                	                	<dd style="display: none;"><a href="deliveryResume.jsp">我投递的职位 <span id="noticeNo" class="red dn">(0)</span></a></dd>
                	                	<dd class="btm" style="display: none;"><a href="jobSeeker/findbyuser.action">我的订阅</a></dd>
                	<dd style="display: none;"><a href="/lagou/HR/createResume.jsp">我要招人</a></dd>
                                                <dd style="display: none;"><a href="/lagou/accountBind.jsp">帐号设置</a></dd>
                                <dd class="logout" style="display: none;"><a rel="nofollow" href="/lagou/commonJsp/login.jsp">退出</a></dd>
            </dl>
                                    <div class="dn" id="noticeTip">
            	<span class="bot"></span>
				<span class="top"></span>
				<a target="_blank" href="delivery.jsp"><strong>0</strong>条新投递反馈</a>
				<a class="closeNT" href="javascript:;"></a>
            </div>
                    </div>
    </div><!-- end #header -->
    <div id="container">
        	  	
        <div class="clearfix">
            <div class="content_l">
            	<h1>我的职位订阅</h1><c:forEach items="${requestScope.subscribelist }" var="sub">
            	            		                <div class="selected s1">
	                	<c:if test="${!(sub.jobtype eq null) }">
	                	<h2>${sub.jobtype.typeName }</h2></c:if>
	                	<div class="sbox">
	                    	<a rel="1" class="sclose" href="javascript:void(0)"></a>
	                    	<a rel="1" class="sedit" href="javascript:void(0)"></a>
	                    </div>
	                   	<span>
	                    <c:if test="${!(sub.cityinfo eq null) }">
	                    	${sub.cityinfo.cityName }</c:if><c:if test="${!(sub.companyfield eq null) }">
	                    	/	                    	${sub.companyfield.fieldName } </c:if><c:if test="${!(sub.companystage eq null) }">
	                    	/	                    	${sub.companystage.stageName }</c:if><c:if test="${!(sub.sal eq null) }"> 
	                    	/	                    	${sub.sal.salMin }k-${sub.sal.salMax }k</c:if>
	                    </span>
	                    <input type="hidden" id="oi1" name="orderId" value="61028">
	                    <input type="hidden" id="pn1" value="Java">
	                    <input type="hidden" id="ci1" value="上海">
	                    <input type="hidden" id="inf1" value="电子商务">
	                    <input type="hidden" id="fs1" value="成长型">
	                    <input type="hidden" id="sa1" value="5k-10k">
	                    <input type="hidden" id="smp1" value="3">
	                    <input type="hidden" id="em1" value="888888888@qq.com">
	                </div></c:forEach>
                	                	            
	           <!--  	                <a href="javascript:void(0)"  class="btn_big"  id="subBtn">新建订阅</a>
	                	                <div class="apply_num">共可创建 <span>2</span> 个，还可创建 <span>1</span> 个</div>
	                <input type="hidden" id="orderCount" value="1" />
	                -->
          		<input type="hidden" value="1" id="orderCount">
          	
                <form class="dn" id="subForm">
                	<input type="hidden" id="orderId" name="id" value="">
	                <div class="s_form">
	                	<p>筛选下面的职位订阅条件，实现精准匹配的个性化职位定制，我们帮你挑工作！</p>
	                	<script>
	                    function getweekday(li_obj){
	                    var input_obj=document.getElementById("weekday");
						input_obj.value=li_obj.value;
	                    }
	                    </script>
	                    <dl>
	                    	<dt>
	                        	<h3><i class="rss_circle"></i>&nbsp; 发送周期 <em></em><span>（必填）</span></h3>
	                        </dt>
	                        <dd>
	                            
	                        	<%-- <input type="text" value="${SessionScope.userinfo.userName }" placeholder="请输入接收邮箱" name="email" id="subEmail">	
	                        	<span style="display:none;" class="error" id="emailError">${SessionScope.userinfo.userName }</span> --%>
	                        </dd> 
	                        <dd>
	                        <input type="hidden" id="weekday" name="weekday" value="" /><!--隐藏域-->
	                        	<input type="hidden" value="" name="sendMailPer" id="select_day_hidden">
	                       		<ul class="s_radio clearfix">
	                       				                            		<li title="3" value="3" onclick="getweekday(this)">3天</li>
	                            		                            		<li title="7" value="7" onclick="getweekday(this)">7天</li>
	                            		                            </ul> 	
	                            <span style="display:none;" class="error" id="sendError">请选择发送周期</span>
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
	                     
	                            <span id="salaryError" class="error" style="display:none;">请选择月薪范围 </span>	
	                        </dd>
	                    </dl>
	                    
	                    
	                    <span style="display:none;" class="error" id="commonError">系统异常</span>
	                    <input type="submit" value="保 存" id="subSubmit" class="btn_big">
	                    <a class="btn_cancel" href="javascript:void(0)">取 消</a>
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
      <input type="hidden" id="userid" name="userid" value="314873">

<!------------------------------------- 弹窗lightbox ----------------------------------------->
<div style="display:none;">	
	<!-- 
		登录帐号订阅成功
		1、已登录用户，且是自有用户，已验证，订阅职位<=1，提示订阅成功；接收邮箱默认为登录邮箱，可修改。
		2、已登录用户，但是第三方用户，订阅职位<=1，提示订阅成功；接收邮箱手动输入可修改。
		未登录帐号订阅成功 
		未登录用户，但填写的邮箱为已注册、已验证邮箱，且订阅职位<=1，订阅成功，点击确定显示登录框
	-->
		<div class="popup" id="subscribeSuccessLogined">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a>888888888@qq.com</a>，请注意查收。</p>
            <table width="100%">
            	<tbody><tr>
                	<td align="center"><a class="btn_s" href="subscribeJob.jsp">确&nbsp;定</a></td>
                </tr>
            </tbody></table>
        </div><!--/#subscribeSuccessLogined-->
   	
   	<!-- 
		未登录未注册帐号订阅成功
		提示注册框
	-->
		<div style="height:370px;" class="popup" id="subscribeSuccessRegister">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a><em></em></a>，请注意查收。</p>
        	<hr>
        	<p>现在只需设置密码就可成功注册拉勾，并可长期保存及管理订阅信息。</p>
        	<form id="registerPopForm">
	            <table width="100%">
	            	<tbody><tr>
	                	<td>注册邮箱 :</td>
	                	<td><em></em></td>
	                </tr>
	                <tr>
	                	<td valign="top">注册密码 :</td>
	                	<td>
	                		<input type="password" placeholder="请输入注册密码" id="psw" name="password" style="background-image: url(style/images/img/a6y3y0Wx5kbFHvGuXzkgf0xhKnPzA4UTyaTB8Ph8AvcHi3fnsrZ7Wore02YViqVOrRXXPhfqP8j6MYlawoAAAAASUVORK5CYII=quot); background-repeat: no-repeat; background-attachment: scroll; background-position: right center;">
	                		<span id="beError_register" style="display:none;" class="error"></span>
	                	</td>
	                </tr>
	                <tr>
	                	<td></td>
	                	<td>
	                		<label for="checkbox" class="fl">
	                			<input type="checkbox" class="checkbox valid" checked="" name="checkbox" id="checkbox">
	                			我已阅读并同意<a target="_blank" href="http://www.lagou.com/privacy.jsp">《拉勾用户协议》</a>
	                		</label>
	                	</td>
	                </tr>
	            	<tr>
	            		<td></td>
	                	<td>
	                		<input type="submit" value="注 册" class="btn_s">
	                	</td>
	                </tr>
	            </tbody></table>
	        </form>
        </div><!--/#subscribeSuccessRegister-->
        
     <!-- 
		未登录注册帐号订阅成功
		弹出框有登录按钮，提示登录
	-->
		<div class="popup" id="subscribeSuccessLogin">
        	<h4>职位订阅成功！</h4>
        	<p>我们将定期发送订阅邮件至：<a></a>，请注意查收。</p>
            <table width="100%">
            	<tbody><tr>
                	<td align="center"><a title="登录" class="btn inline cboxElement" href="#loginPop">登 录</a></td>
                </tr>
            </tbody></table>
        </div><!--/#subscribeSuccessLogin-->
		
     <!-- 登录框 -->
	<div style="height:240px;" class="popup" id="loginPop">
       	<form id="loginForm">
			<input type="text" placeholder="请输入登录邮箱地址" tabindex="1" name="email" id="email" style="background-image: url(style/images/img/0CQnd2Jos49xUAAAAASUVORK5CYII=quot); background-repeat: no-repeat; background-attachment: scroll; background-position: right center;">
			<input type="password" placeholder="请输入密码" tabindex="2" name="password" id="password" style="background-image: url(style/images/img/0CQnd2Jos49xUAAAAASUVORK5CYII=quot); background-repeat: no-repeat; background-attachment: scroll; background-position: right center;">
			<span id="beError" style="display:none;" class="error"></span>
		    <label for="remember" class="fl"><input type="checkbox" name="autoLogin" checked="checked" value="" id="remember"> 记住我</label>
		    <a target="_blank" class="fr" href="http://www.lagou.com/reset.jsp">忘记密码？</a>
		    <input type="submit" value="登 &nbsp; &nbsp; 录" id="submitLogin">
		</form>
		<div class="login_right">
			<div>还没有拉勾帐号？</div>
			<a class="registor_now" href="http://www.lagou.com/register.jsp">立即注册</a>
		    <div class="login_others">使用以下帐号直接登录:</div>
		    <a title="使用新浪微博帐号登录" class="icon_wb" target="_blank" href="http://www.lagou.com/ologin/auth/sina.jsp"></a>
		    <a title="使用腾讯QQ帐号登录" target="_blank" class="icon_qq" href="http://www.lagou.com/ologin/auth/qq.jsp"></a>
		</div>
    </div><!--/#loginPop-->
    
     <!--退订-->	
    <div class="popup" id="cancelSub">
       	<h4>确认要退订该订阅？</h4>
       	<table width="100%">
       		<tbody><tr>
       			<td align="center"><p>点击确认后你将不再收到拉勾为你提供的精准职位推送。</p></td>
       		</tr>
        	<tr>
            	<td align="center">
            		<input type="button" value="确认退订" id="confirmCancel" class="btn_s">
            		<a class="btn_s" href="javascript:void(0)">取消</a>
            	</td>
            </tr>
        </tbody></table>
    </div><!--/#cancelSub-->
</div>
<!------------------------------------- end ----------------------------------------->

<script src="style/js/sub.min.js"></script>
<!-- 退订 | 从邮箱进来订阅页  -->

<!-- 订阅成功弹出注册框 | 从邮箱进来订阅页  -->

<!-- 订阅成功弹出登录框 | 从邮箱进来订阅页  -->

<!-- 从激活页点换个邮箱进入订阅页 -->
			<div class="clear"></div>
			<input type="hidden" value="37509432fb9e453a815da48821b7bf01" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="/lagou/commonJsp/about.jsp">联系我们</a>
		    <a target="_blank" href="http://www.lagou.com/af/zhaopin.jsp">互联网公司导航</a>
		    <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
		    <a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>

<!--  -->

<script type="text/javascript">
$(function(){
	$('#noticeDot-1').hide();
	$('#noticeTip a.closeNT').click(function(){
		$(this).parent().hide();
	});
});
var index = Math.floor(Math.random() * 2);
var ipArray = new Array('42.62.79.226','42.62.79.227');
var url = "ws://" + ipArray[index] + ":18080/wsServlet?code=314873";
var CallCenter = {
		init:function(url){
			var _websocket = new WebSocket(url);
			_websocket.onopen = function(evt) {
				console.log("Connected to WebSocket server.");
			};
			_websocket.onclose = function(evt) {
				console.log("Disconnected");
			};
			_websocket.onmessage = function(evt) {
				//alert(evt.data);
				var notice = jQuery.parseJSON(evt.data);
				if(notice.status[0] == 0){
					$('#noticeDot-0').hide();
					$('#noticeTip').hide();
					$('#noticeNo').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.jsp');
					$('#noticeNoPage').text('').show().parent('a').attr('href',ctx+'/mycenter/delivery.jsp');
				}else{
					$('#noticeDot-0').show();
					$('#noticeTip strong').text(notice.status[0]);
					$('#noticeTip').show();
					$('#noticeNo').text('('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.jsp');
					$('#noticeNoPage').text(' ('+notice.status[0]+')').show().parent('a').attr('href',ctx+'/mycenter/delivery.jsp');
				}
				$('#noticeDot-1').hide();
			};
			_websocket.onerror = function(evt) {
				console.log('Error occured: ' + evt);
			};
		}
};
CallCenter.init(url);
</script>

<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div></body></html>