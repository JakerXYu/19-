package com.lagou.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.JobdeliverBIZ;
import com.lagou.biz.ResumeinfoBIZ;
import com.lagou.bizImp.JobdeliverBIZImp;
import com.lagou.dao.ResumeinfoDAO;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Jobstatus;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Resumestatus;
import com.lagou.domain.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("JobdeliverAction")
@Scope("prototype")
@Namespace("/jobdeliver")
@ParentPackage("struts-default")
public class JobdeliverAction extends ActionSupport{
	@Autowired@Qualifier("JobdeliverBIZImp")//依赖注入 
	private JobdeliverBIZ jobdeliverBIZ;
	@Autowired@Qualifier("ResumeinfoBIZImp")
	private ResumeinfoBIZ resumeinfoBIZ;
	private Integer status;
	private Jobdeliver transientInstance;
	private Userinfo userinfo;
	private Resumeinfo resumeinfo;
	private String resumeinfoid;
	/**
	 * 
	 * @return
	 */
//	@Action(value="save",results={@Result(location="/jobSeeker/deliveryResume.jsp")})
	@Action(value="save",results={@Result(name="success",location="/index.jsp")})
	
	public String save(){
		jobdeliverBIZ.save(transientInstance);
		return ActionSupport.SUCCESS;
	}
	
	
	/**
	 * 查询当前用户所有处于该状态的投递信息
	 * @param userinfo 用户对象
	 * @param status 简历状态id
	 */
	@Action(value="findByResumeStatus",results={
			@Result(name="success2",location="/jobSeeker/deliveryResume2.jsp"),
			@Result(name="success3",location="/jobSeeker/deliveryResume3.jsp"),
			@Result(name="success4",location="/jobSeeker/deliveryResume4.jsp"),
			@Result(name="success5",location="/jobSeeker/deliveryResume5.jsp"),
			@Result(name="success6",location="/jobSeeker/deliveryResume6.jsp"),
			@Result(name="none",location="/jobSeeker/deliveryResume1.jsp")
			})
	public String findByResumeStatus(){
		int resumeid =0;
		Map<String, Object> map=ActionContext.getContext().getSession();//得到session
		
//		Userinfo user = new Userinfo();
//		user.setUserinfoId(1);
//		map.put("userinfo", user);
		
		
		Userinfo userinfo=(Userinfo) map.get("userinfo");//通过map集合的key从session中获得useinfo对象
		//通过用户查找得到简历信息
		List<Resumeinfo> resumeinfoList=resumeinfoBIZ.findByUser(userinfo.getUserinfoId());
		//遍历简历信息得到简历id
		for (Resumeinfo resumeinfo : resumeinfoList) {
			resumeid = resumeinfo.getResumeId();
		}
		System.out.println(resumeid+"++++++++++++++++++++++++++++++++++");
		System.out.println(status+"===================================");
	
	    List<Jobdeliver> jobdeliverList=this.jobdeliverBIZ.findByResumeStatus(resumeid, status);
	    Map<String, Object> map_req=(Map<String, Object>) ActionContext.getContext().get("request");
	    map_req.put("jobdeliverList", jobdeliverList);
	    switch(status){
	    case 2:
	    	return "success2";
	    case 3:
	    	return "success3";
	    case 4:
	    	return "success4";
	    case 5:
	    	return "success5";
	    case 6:
	    	return "success6";
	    }
		return "none";
	}
	/**
	 * 查找所有简历
	 * @return
	 * 
	 *  
	 *  
	 *  
	 */
	
	@Action(value="findByUser",
			results={@Result(location="/jobSeeker/deliveryResume1.jsp")
			})
	public String findByUser(){
		int resumeinfo1=0;
		int resumeinfo2;
		Map<String, Object> map=ActionContext.getContext().getSession();
		
//		Userinfo user = new Userinfo();
//		user.setUserinfoId(1);
//		map.put("userinfo", user);
		
		
		Userinfo userinfo=(Userinfo) map.get("userinfo");
		List<Resumeinfo> resumeinfoList=resumeinfoBIZ.findByUser(userinfo.getUserinfoId());
		for (Resumeinfo resumeinfo : resumeinfoList) {
			resumeinfo1=resumeinfo.getResumeId();
		}
		int resumeinfoid2=resumeinfo1;
		System.out.println(resumeinfoid2+"----------------------------------------");
		List<Jobdeliver> jobdeliverList2=this.jobdeliverBIZ.findByUser(resumeinfoid2);
		for (Jobdeliver jobdeliver : jobdeliverList2) {
			System.out.println(jobdeliver.getDeliverId());
		}
		
		Map<String, Object> map2=(Map<String, Object>) ActionContext.getContext().get("request");
		map2.put("jobdeliverList", jobdeliverList2);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	
	@Action(value="findJobDeliver",results={
			@Result(name="success",location="/Test1.jsp")
			})
	public String findJobDeliver(){
		List<Jobinfo> jobinfoList=this.jobdeliverBIZ.findJobDeliver(userinfo);
		Map<String, Object> map_req=(Map<String, Object>) ActionContext.getContext().get("request");
		map_req.put("jobinfoList", jobinfoList);
		return ActionSupport.SUCCESS;
	}


	
	



	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public JobdeliverBIZ getJobdeliverBIZ() {
		return jobdeliverBIZ;
	}



	public void setJobdeliverBIZ(JobdeliverBIZ jobdeliverBIZ) {
		this.jobdeliverBIZ = jobdeliverBIZ;
	}


	public Jobdeliver getTransientInstance() {
		return transientInstance;
	}

	public void setTransientInstance(Jobdeliver transientInstance) {
		this.transientInstance = transientInstance;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public Resumeinfo getResumeinfo() {
		return resumeinfo;
	}


	public void setResumeinfo(Resumeinfo resumeinfo) {
		this.resumeinfo = resumeinfo;
	}

	
    

}
