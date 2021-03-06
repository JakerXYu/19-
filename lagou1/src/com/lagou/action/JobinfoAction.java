package com.lagou.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.JobTypeBIZ;
import com.lagou.biz.JobdeliverBIZ;
import com.lagou.biz.JobeduBIZ;
import com.lagou.biz.JobexpBIZ;
import com.lagou.biz.JobinfoBIZ;
import com.lagou.biz.JobpropBIZ;
import com.lagou.biz.JobstatusBIZ;
import com.lagou.biz.ResumeinfoBIZ;
import com.lagou.biz.ResumestatusBIZ;
import com.lagou.bizImp.JobinfoBIZImp;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Resumestatus;
import com.lagou.domain.Userinfo;
import com.lagou.vo.JobSearchVO;
import com.lagou.vo.JobdeliverVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("JobinfoAction")
@ParentPackage("json-default")
@Scope("prototype")
@Namespace("/jobinfo")
public class JobinfoAction extends ActionSupport {
	private String jsonText;
	private Integer jobId;
	private Integer typeId;
	private JobdeliverVO jobdelivervo;
	
	private JobSearchVO jobvo;
	
	
	private Jobinfo jobinfo;
	private Integer jobtypeId;
	private Integer jobeduId;
	private Integer jobpropId;
	private Integer jobexpId;
	private Integer jobstatusId;
	
	@Autowired
	@Qualifier("JobinfoBIZImp")
	private JobinfoBIZ jobinfoBIZ;
	@Autowired@Qualifier("JobdeliverBIZImp")
	private JobdeliverBIZ jobdeliverBIZ;
	@Autowired@Qualifier("ResumestatusBIZImp")
    private ResumestatusBIZ resumesatusBIZ;
	@Autowired@Qualifier("ResumeinfoBIZImp")
	private ResumeinfoBIZ resumeinfoBIZ;
	
	@Autowired@Qualifier("JobeduBIZImp")
	private JobeduBIZ jobeduBIZ;
	@Autowired@Qualifier("JobpropBIZImp")
	private JobpropBIZ jobpropBIZ;
	@Autowired@Qualifier("JobTypeBIZImp")
	private JobTypeBIZ jobTypeBIZ;
	@Autowired@Qualifier("JobstatusBIZImp")
	private JobstatusBIZ jobstatusBIZ;
	@Autowired@Qualifier("JobexpBIZImp")
	private JobexpBIZ jobexpBIZ;
	/*
	 * 增加投递记录...............
	 */
	@Action(value="save" , results={
			@Result(name="success",type="redirectAction",params={"namespace","/jobdeliver","actionName","findByUser"}),
			@Result(name="nologin" , location="/commonJsp/login.jsp"),
			@Result(name="noresume" , location="/jobSeeker/myResume.jsp")
	})
	public String save(){
		Map<String,Object> sess = ActionContext.getContext().getSession();
		if(sess.isEmpty()){
			return "nologin";
			
		}else{
		Resumeinfo resumeinfo = null;
		System.out.println(jobdelivervo.getJobId

()+12+"==========================");
		System.out.println(jobdelivervo.getStatusId());
		int jobid = jobdelivervo.getJobId();
		Jobinfo jobinfo = jobinfoBIZ.findById(jobid);
		
		int status = jobdelivervo.getStatusId();
		Resumestatus resumestatus = resumesatusBIZ.findById(status);
		
		
		Userinfo userinfo = (Userinfo) sess.get("userinfo");
		List<Resumeinfo> resumeinfolist = resumeinfoBIZ.findByUser

(userinfo.getUserinfoId());
		
		for (Resumeinfo resume : resumeinfolist) {
			resumeinfo=resume;
		}
		if(resumeinfo==null){
			return "noresume";
		}else{
		

		Jobdeliver jobdeliver = new Jobdeliver();
		jobdeliver.setJobinfo(jobinfo);
		jobdeliver.setResumestatus(resumestatus);
		jobdeliver.setResumeinfo(resumeinfo);
		
		
		jobdeliver.setJobinfo(jobinfo);
		jobdeliverBIZ.save(jobdeliver);
		return ActionSupport.SUCCESS;
		}
			
		}
		
		
	}
	
	/**
	 * 根据id查职位信息
	 * 
	 * @return 返回Json格式的所有职位信息文本
	 * @author 姜翔宇
	 */
	@Action(value = "findbyid", results = { @Result(location = 

"/commonJsp/jobdetail.jsp") })
	public String findById() {
		Jobinfo jobinfo = this.jobinfoBIZ.findById(this.jobId);
		ActionContext context = ActionContext.getContext();
		Map<String, Object> req_map = (Map<String, Object>) context
				.get("request");
		
		req_map.put("jobinfo", jobinfo);
		return ActionSupport.SUCCESS;
	}
	/**
	 * 加载所有职位信息
	 * 
	 * @return 返回Json格式的所有职位信息文本
	 * @author 姜翔宇
	 */
	@Action(value = "findall", results = { @Result(location = "/jobinfo/test.jsp") 

})
	public String findAll() {
		List<Jobinfo> jobinfoList = this.jobinfoBIZ.findAll();
		ActionContext context = ActionContext.getContext();
		Map<String, Object> req_map = (Map<String, Object>) context
				.get("request");

		req_map.put("jobinfoList", jobinfoList);
		return ActionSupport.SUCCESS;
	}

	@Action(value = "findnew", results = { @Result(name = "success", type = "json", 

params = {
			"root", "jsonText" }) }, interceptorRefs = {
			@InterceptorRef("defaultStack"), @InterceptorRef("json") })
	/**
	 * 加载最新职位信息
	 * @author 姜翔宇
	 * @return 返回Json格式的最新职位列表文本
	 */
	public String findNew() {
		this.jsonText = this.jobinfoBIZ.findByNew();
		return ActionSupport.SUCCESS;
	}

	@Action(value = "findhot", results = { @Result(name = "success", type = "json", 

params = {
			"root", "jsonText" }) }, interceptorRefs = {
			@InterceptorRef("defaultStack"), @InterceptorRef("json") })
	/**
	 * 加载热门职业信息
	 * @author 姜翔宇
	 * @return 返回Json格式的最热门职位列表文本
	 */
	public String findHot() {
		this.jsonText = this.jobinfoBIZ.findByHot();
		return ActionSupport.SUCCESS;
	}
	/**
	 * 根据个人的职位订阅信息来查询职位
	 * 
	 * @return
	 *
	 * @author 姜翔宇
	 */
	@Action(value = "findsubs", results = { @Result(name = "success", type = "json", params = {
			"root", "jsonText" })}, interceptorRefs = {
			@InterceptorRef("defaultStack"), @InterceptorRef("json") })
	public String findByUserSubscribe() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> ses_map = (Map<String, Object>) actionContext
				.get("session");
		Userinfo userinfo = (Userinfo) ses_map.get("userinfo");
		if (userinfo.getSubscribes() != null
				&& userinfo.getSubscribes().size() != 0) {
			this.jsonText = this.jobinfoBIZ.findBySubscribe(userinfo
					.getSubscribes());
		} else {
			this.jsonText =new String("<li>对不起,您还没有订阅职位!<*li>");
		}
		return ActionSupport.SUCCESS;
	}
	/**
	 * 根据多条件搜索职位信息
	 * @return 
	 */
	@Action(value = "search", results = { @Result(location = "/commonJsp/jobList.jsp") })
	public String  findBySearch(){
		ActionContext context = ActionContext.getContext();
		Map<String, Object> ses_map = (Map<String, Object>) context
				.get("session");
		Map<String, Object> req_map = (Map<String, Object>) context
				.get("request");
		JobSearchVO jVo=(JobSearchVO)ses_map.get("jVO");
		if(this.jobvo==null){
			this.jobvo=new JobSearchVO();
		}
		if (jVo==null) {
			jVo=this.jobvo;
		}
		if(this.typeId!=null){
			jVo.setTypeId(typeId);
		}
		jVo=jVo.update(this.jobvo, jVo);
		List<Jobinfo> jobinfoList = this.jobinfoBIZ.findBySearch(jVo);
		req_map.put("jobinfoList", jobinfoList);
		ses_map.put("jVO", jVo);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 发布职位
	 * @return
	 */
	@Action(value = "releasePosition", results = {@Result(name="success",location = "/index.jsp")})
	public String releasePosition(){
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> sess_map = actionContext.getSession();
		Companyinfo companyinfo=(Companyinfo) sess_map.get("companyinfo");
		
		jobinfo.setCompanyinfo(companyinfo);
		
		jobinfo.setJobtype(jobTypeBIZ.findById(jobtypeId));
		
		jobinfo.setJobedu(jobeduBIZ.findById(jobeduId));
		
		jobinfo.setJobprop(jobpropBIZ.findById(jobpropId));
		
		jobinfo.setJobexp(jobexpBIZ.findById(jobexpId));
		
		jobinfo.setJobstatus(jobstatusBIZ.findById(jobstatusId));
		Timestamp ts=new Timestamp(new Date().getTime());
		jobinfo.setJobStartTime(ts);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(ts);
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		jobinfo.setJobEndTime(ts.valueOf(sdf.format(calendar.getTime())));
		jobinfoBIZ.releasePosition(jobinfo);
		return ActionSupport.SUCCESS;
		
	}
	
	
	public Integer getJobexpId() {
		return jobexpId;
	}

	public void setJobexpId(Integer jobexpId) {
		this.jobexpId = jobexpId;
	}

	public Integer getJobstatusId() {
		return jobstatusId;
	}

	public void setJobstatusId(Integer jobstatusId) {
		this.jobstatusId = jobstatusId;
	}

	public JobstatusBIZ getJobstatusBIZ() {
		return jobstatusBIZ;
	}

	public void setJobstatusBIZ(JobstatusBIZ jobstatusBIZ) {
		this.jobstatusBIZ = jobstatusBIZ;
	}

	public JobexpBIZ getJobexpBIZ() {
		return jobexpBIZ;
	}

	public void setJobexpBIZ(JobexpBIZ jobexpBIZ) {
		this.jobexpBIZ = jobexpBIZ;
	}

	public JobSearchVO getJobvo() {
		return jobvo;
	}

	public void setJobvo(JobSearchVO jobvo) {
		this.jobvo = jobvo;
	}
	
	public String getJsonText() {
		return jsonText;
	}

	public void setJsonText(String jsonText) {
		this.jsonText = jsonText;
	}

	public JobinfoBIZ getJobinfoBIZ() {
		return jobinfoBIZ;
	}

	public void setJobinfoBIZ(JobinfoBIZImp jobinfoBIZ) {
		this.jobinfoBIZ = jobinfoBIZ;
	}
	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	//
	public Jobinfo getJobinfo() {
		return jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}
	


	public JobdeliverVO getJobdelivervo() {
		return jobdelivervo;
	}

	public void setJobdelivervo(JobdeliverVO jobdelivervo) {
		this.jobdelivervo = jobdelivervo;
	}

	public JobdeliverBIZ getJobdeliverBIZ() {
		return jobdeliverBIZ;
	}

	public void setJobdeliverBIZ(JobdeliverBIZ jobdeliverBIZ) {
		this.jobdeliverBIZ = jobdeliverBIZ;
	}

	public ResumestatusBIZ getResumesatusBIZ() {
		return resumesatusBIZ;
	}

	public void setResumesatusBIZ(ResumestatusBIZ resumesatusBIZ) {
		this.resumesatusBIZ = resumesatusBIZ;
	}

	public ResumeinfoBIZ getResumeinfoBIZ() {
		return resumeinfoBIZ;
	}

	public void setResumeinfoBIZ(ResumeinfoBIZ resumeinfoBIZ) {
		this.resumeinfoBIZ = resumeinfoBIZ;
	}

	public void setJobinfoBIZ(JobinfoBIZ jobinfoBIZ) {
		this.jobinfoBIZ = jobinfoBIZ;
	}

	public Integer getJobtypeId() {
		return jobtypeId;
	}

	public void setJobtypeId(Integer jobtypeId) {
		this.jobtypeId = jobtypeId;
	}

	public Integer getJobeduId() {
		return jobeduId;
	}

	public void setJobeduId(Integer jobeduId) {
		this.jobeduId = jobeduId;
	}

	public Integer getJobpropId() {
		return jobpropId;
	}

	public void setJobpropId(Integer jobpropId) {
		this.jobpropId = jobpropId;
	}

	public JobeduBIZ getJobeduBIZ() {
		return jobeduBIZ;
	}

	public void setJobeduBIZ(JobeduBIZ jobeduBIZ) {
		this.jobeduBIZ = jobeduBIZ;
	}

	public JobpropBIZ getJobpropBIZ() {
		return jobpropBIZ;
	}

	public void setJobpropBIZ(JobpropBIZ jobpropBIZ) {
		this.jobpropBIZ = jobpropBIZ;
	}

	public JobTypeBIZ getJobTypeBIZ() {
		return jobTypeBIZ;
	}

	public void setJobTypeBIZ(JobTypeBIZ jobTypeBIZ) {
		this.jobTypeBIZ = jobTypeBIZ;
	}
	
	
	

}
