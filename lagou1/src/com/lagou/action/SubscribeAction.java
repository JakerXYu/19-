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

import com.lagou.biz.JobTypeBIZ;
import com.lagou.domain.Jobtype;
import com.lagou.domain.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("SubscribeAction")
@ParentPackage("struts-default")
@Namespace("/jobSeeker")
@Scope("prototype")

public class SubscribeAction extends ActionSupport {
	@Autowired@Qualifier("JobTypeBIZImp")
	private JobTypeBIZ jobtypeBIZ;
	@Action(value="findsession",results={
			@Result(name="isempty",location="/commonJsp/login.jsp"),
			@Result(location="/jobSeeker/subscribeJob.jsp")
	})
	public String findsession(){
		Map<String,Object> sess = ActionContext.getContext().getSession();
//		Userinfo userinfo = new Userinfo();
//		userinfo.setUserinfoUsername("479474232@qq.com");
//		userinfo.setUserinfoPassword("123456");
//		sess.put("li", userinfo);
//		System.out.println(sess.get("userinfo"));
		if(sess.isEmpty()){
			return "isempty";
		}else{
			
			return ActionSupport.SUCCESS;
		}
		
	}
	public JobTypeBIZ getJobtypeBIZ() {
		return jobtypeBIZ;
	}
	public void setJobtypeBIZ(JobTypeBIZ jobtypeBIZ) {
		this.jobtypeBIZ = jobtypeBIZ;
	}
	


}
