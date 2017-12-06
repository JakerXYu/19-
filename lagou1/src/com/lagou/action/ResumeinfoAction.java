package com.lagou.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.ResumeinfoBIZ;
import com.lagou.domain.Expectjob;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("ResumeinfoAction")
@ParentPackage("struts-default")
@Namespace("/resumeinfo")
@Scope("prototype")
public class ResumeinfoAction {
	@Autowired@Qualifier("ResumeinfoBIZImp")
	private ResumeinfoBIZ resumeinfoBIZ;
	
	private Resumeinfo resumeinfo;
	private Userinfo userinfo;
	private Expectjob expectjob;
	/**
	 * 查找当前用户的简历信息
	 * @return success 跳转到简历的显示页面
	 */
	@Action(value="findByUser",results={
		@Result( name="success", location="/resumeinfo/show.jsp")
	})
	public String findByUser(){
		
		Map<String, Object> sess_map=(Map<String, Object>) ActionContext.getContext().getSession();
		//int userId=(int) sess_map.get("userId");
//		List<Resumeinfo> resumeinfoList=resumeinfoBIZ.findByUser(1);
		Userinfo userinfo = (Userinfo) sess_map.get("userinfo");
		int userid =  userinfo.getUserinfoId();
		List<Resumeinfo> resumeinfolist = resumeinfoBIZ.findByUser(userid);
		Resumeinfo  resumeinfo2 = null;
		for (Resumeinfo resumeinfo : resumeinfolist) {
			  resumeinfo2=resumeinfo;
			break;
		}
		Map<String, Object> req_map=(Map<String, Object>) ActionContext.getContext().get("request");
		req_map.put("resumeinfo", resumeinfo2);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 修改简历的个人信息
	 * @return
	 */
	@Action(value="updateUser",results={
			@Result(type="chain",params={"namespace","/resumeinfo","actionName","findByUser"})
	})
	public String updateUser(){
		resumeinfoBIZ.update(userinfo);
		return ActionSupport.SUCCESS;

	}
	
	/**
	 * 修改简历的期望工作信息
	 * @return
	 */
	@Action(value="updateExpectJob",results={
			@Result(type="chain",params={"namespace","/resumeinfo","actionName","findByUser"})
	})
	public String updateExpectJob(){
		resumeinfoBIZ.update(expectjob);
		return ActionSupport.SUCCESS;

	}
	
	
	
	public Resumeinfo getResumeinfo() {
		return resumeinfo;
	}

	public void setResumeinfo(Resumeinfo resumeinfo) {
		this.resumeinfo = resumeinfo;
	}

	public ResumeinfoBIZ getResumeinfoBIZ() {
		return resumeinfoBIZ;
	}

	public void setResumeinfoBIZ(ResumeinfoBIZ resumeinfoBIZ) {
		this.resumeinfoBIZ = resumeinfoBIZ;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Expectjob getExpectjob() {
		return expectjob;
	}

	public void setExpectjob(Expectjob expectjob) {
		this.expectjob = expectjob;
	}
	
	
}
