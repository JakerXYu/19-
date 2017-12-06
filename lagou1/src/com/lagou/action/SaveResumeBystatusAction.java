package com.lagou.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.JobdeliverBIZ;
import com.lagou.biz.ResumestatusBIZ;
import com.lagou.bizImp.JobdeliverBIZImp;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Resumestatus;
import com.lagou.utils.EMailUtils;
import com.lagou.utils.Mail;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("SaveResumeBystatusAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/updateResumeBystatus")
public class SaveResumeBystatusAction extends ActionSupport {
	
	@Autowired@Qualifier("JobdeliverBIZImp")
	private JobdeliverBIZ jobdeliverBIZ;
	@Autowired@Qualifier("ResumestatusBIZImp")
	private ResumestatusBIZ resumestatusBIZ;
	private Integer status;//接收页面参数(状态)
	private Integer jobdeliverId;
			
			//简历状态
			/*1	全部
			2	投递成功(待处理)
			
			4	通过初筛(待定)
			5	通知面试
			6	不合适
			7	已删除*/
		/**
		 * 通过状态以及查询条件查找待处理简历
		 * sln
		 * @return
		 * 				

		 */
		@Action(value="canDealResumes",
				results={@Result(name="success", type="redirectAction" ,
				params={"namespace","/findResumeBystatus","actionName","canDealResumes"})
    
		})
		public String canDealResumes(){
			System.out.println(jobdeliverId+"=========================");
			System.out.println(status+"++++++++++++++++++++++++++++++");
			Jobdeliver jobdeliver = jobdeliverBIZ.findById(jobdeliverId);
			Resumestatus resumestatus = resumestatusBIZ.findById(status);
			
			jobdeliver.setResumestatus(resumestatus);
			jobdeliverBIZ.update(jobdeliver);

			return ActionSupport.SUCCESS;
		}
		
		
		@Action(value="canInterviewResumes",
				results={@Result(name="success", type="redirectAction" ,
				params={"namespace","/findResumeBystatus","actionName","canInterviewResumes"})
    
		})
		public String canInterviewResumes(){
			System.out.println(jobdeliverId+"=========================");
			System.out.println(status+"++++++++++++++++++++++++++++++");
			Jobdeliver jobdeliver = jobdeliverBIZ.findById(jobdeliverId);
			Resumestatus resumestatus = resumestatusBIZ.findById(status);
			
			jobdeliver.setResumestatus(resumestatus);
			jobdeliverBIZ.update(jobdeliver);

			return ActionSupport.SUCCESS;
		}
		
		@Action(value="haveNoticeResumes",
				results={@Result(name="success", type="redirectAction" ,
				params={"namespace","/findResumeBystatus","actionName","haveNoticeResumes"})
    
		})
		public String haveNoticeResumes(){
			System.out.println(jobdeliverId+"=========================");
			System.out.println(status+"++++++++++++++++++++++++++++++");
			Jobdeliver jobdeliver = jobdeliverBIZ.findById(jobdeliverId);
			Resumestatus resumestatus = resumestatusBIZ.findById(status);
			ActionContext actionContext=ActionContext.getContext();
			Map<String, Object> ses_map=(Map<String, Object>) actionContext.getSession();
			Companyinfo companyinfo=(Companyinfo) ses_map.get("companyinfo");
			
			jobdeliver.setResumestatus(resumestatus);
			/*通知面试发送邮件的接口ZH ----begin*/
			String receive=jobdeliver.getResumeinfo().getUserinfo().getUserinfoEmail();//接收者的email
			String send=companyinfo.getCompanyLogname();//发送者的email
			String sender=companyinfo.getCompanyName();//发送者的名字
			String receiver=jobdeliver.getResumeinfo().getUserinfo().getUserinfoUsername();
			String jobnameString=jobdeliver.getJobinfo().getJobName();
			String contentString="你好!"+receiver+"，我是"+sender+"的人事专员，欢迎应聘我公司的"+
					jobnameString+"职位，请于星期三下午来面试，面试地址为：北京市海淀区，东升大厦B座";
			Mail.send("smtp.163.com", "m17862921529@163.com", receive, "面试通知", contentString, "m17862921529@163.com", "lagou123456");		
			
			try {
				EMailUtils.sendMail(receive, "面试通知", contentString);
			} catch (Exception e) {
				System.out.println("发送面试通知时出错！");
				e.printStackTrace();
			}
			System.out.println(contentString);
			/*通知面试发送邮件的接口 ----end*/
			jobdeliverBIZ.update(jobdeliver);

			return ActionSupport.SUCCESS;
		}
		
		@Action(value="haveRefuseResumes",
				results={@Result(name="success", type="redirectAction" ,
				params={"namespace","/findResumeBystatus","actionName","findByResumeStatuss"})
    
		})
		public String haveRefuseResumes(){
			System.out.println(jobdeliverId+"=========================");
			System.out.println(status+"++++++++++++++++++++++++++++++");
			Jobdeliver jobdeliver = jobdeliverBIZ.findById(jobdeliverId);
			Resumestatus resumestatus = resumestatusBIZ.findById(status);
			
			jobdeliver.setResumestatus(resumestatus);
			jobdeliverBIZ.update(jobdeliver);

			return ActionSupport.SUCCESS;
		}

		public Integer getStatus() {
			return status;
		}



		public void setStatus(Integer status) {
			this.status = status;
		}



		public Integer getJobdeliverId() {
			return jobdeliverId;
		}

		public void setJobdeliverId(Integer jobdeliverId) {
			this.jobdeliverId = jobdeliverId;
		}

		public JobdeliverBIZ getJobdeliverBIZ() {
			return jobdeliverBIZ;
		}

		public void setJobdeliverBIZ(JobdeliverBIZ jobdeliverBIZ) {
			this.jobdeliverBIZ = jobdeliverBIZ;
		}



		public ResumestatusBIZ getResumestatusBIZ() {
			return resumestatusBIZ;
		}



		public void setResumestatusBIZ(ResumestatusBIZ resumestatusBIZ) {
			this.resumestatusBIZ = resumestatusBIZ;
		}
		
		
		
		
}
