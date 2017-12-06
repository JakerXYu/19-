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

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.biz.JobinfoBIZ;
import com.lagou.biz.UserinfoBIZ;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("ConpanyJobinfoAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/companyjobinfo")
public class ConpanyJobinfoAction extends ActionSupport {
	@Autowired@Qualifier("JobinfoBIZImp")
	private JobinfoBIZ jobinfoBIZ;
	
	private Integer status;
    
	@Action(value="find",results={@Result(name="success",location="/HR/existPositions.jsp")})
	public String find(){
		ActionContext context=ActionContext.getContext();
		Map<String, Object> ses_map=(Map<String, Object> )context.getSession();
		Map<String, Object> req_map=(Map<String, Object> )context.get("request");
		Companyinfo companyinfo=(Companyinfo) ses_map.get("companyinfo");
		int companyinfoId=companyinfo.getCompanyId();
		List<Jobinfo> jobinfolist=jobinfoBIZ.findByUser(companyinfoId, status);	
		req_map.put("jobinfolist", jobinfolist);
		return ActionSupport.SUCCESS;
	}

	public JobinfoBIZ getJobinfoBIZ() {
		return jobinfoBIZ;
	}

	public void setJobinfoBIZ(JobinfoBIZ jobinfoBIZ) {
		this.jobinfoBIZ = jobinfoBIZ;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
  