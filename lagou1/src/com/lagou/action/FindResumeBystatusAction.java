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

import com.lagou.biz.ResumeinfoBIZ;
import com.lagou.dao.CompanyinfoDAO;
import com.lagou.dao.ResumeinfoDAO;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Resumeinfo;
import com.lagou.vo.ResumeSearchVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("FindResumeBystatusAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/findResumeBystatus")
public class FindResumeBystatusAction extends ActionSupport {
	@Autowired@Qualifier("ResumeinfoBIZImp")
	private ResumeinfoBIZ resumeinfoBIZ;
	//xxxxxxxxxxxxxxxxxxxxxxxxx登录后不需要这个注解
	/*@Autowired@Qualifier("CompanyinfoDAO")
	private CompanyinfoDAO companyinfoDAO;*/
	
	private int status;//接收页面参数(状态)
	
	private Integer jobexp;//接收页面参数(查询条件:工作经验)
	private Integer jobedu;//接收页面参数(查询条件:最低学历)
	        //学历
			/*1	大专
			2	本科
			3	硕士
			4	博士
			5	不限*/
			
			//工作经验
			/*1	不限
			2	应届毕业生
			3	1年以下
			4	1-3年
			5	3-5年
			6	5-10年
			7	10年以上
			8	未知*/
			
			//简历状态
			/*1	全部
			2	投递成功(待处理)
			
			4	通过初筛(待定)
			5	通知面试
			6	不合适
			7	已删除*/
	
	
	//<a href="haveNoticeResumes.jsp">已通知面试简历</a>
	/**
	 * 通过状态以及查询条件查找已通知面试简历
	 * sln
	 * @return
	 */
	@Action(value="haveNoticeResumes",
			results={@Result(name="success",location="/HR/haveNoticeResumes.jsp")})
	public String haveNoticeResumes(){
		System.out.println("88888888888888888888接收页面参数(状态)为"+status);
		System.out.println("88888888888888888888接收页面参数(查询条件:工作经验)"+jobexp);
		System.out.println("88888888888888888888接收页面参数(查询条件:最低学历)"+jobedu);
		System.out.println("开始aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> resume_map=(Map<String, Object>) actionContext.get("request");
		//ResumeSearchVO(工作经验, 最低学历)
		ResumeSearchVO rSearchVO=new ResumeSearchVO(jobexp, jobedu);
		
		Map<String, Object> manager_map=actionContext.getSession();
		Companyinfo companyinfo=(Companyinfo) manager_map.get("companyinfo");
		/*Companyinfo companyinfo =new Companyinfo();//xxxxxxxxxxxxxxxxxxxxx登录成功后要从session中获得
		companyinfo=companyinfoDAO.findById(1);*/
		
		
		List<Jobdeliver> list=resumeinfoBIZ.findByResumeStatuss(companyinfo, 5, rSearchVO);
		resume_map.put("resumeList", list);//放入request中
		if(list.size()==0){
			System.out.println("查询无结果77777777777777777777777777777777777777777777777777");
		}
		for (Jobdeliver jobdeliver : list) {
			System.out.println("用户头像:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoImg());
			System.out.println("用户姓名:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoUsername());
			System.out.println("用户性别:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoSex());
			//jobdeliver.getJobinfo().getJobexp().getExpId()
			System.out.println("工作经验:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu()+"年");
			System.out.println("期望工作城市:"+jobdeliver.getResumeinfo().getExpectjob().getCityinfo().getCityName());
			System.out.println("期望工作:"+jobdeliver.getResumeinfo().getExpectjob().getExpectJobDept());
			System.out.println("投递公司:"+companyinfo.getCompanyName());
			System.out.println("用户学历:"+jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduName());
			System.out.println("用户毕业院校:"+jobdeliver.getResumeinfo().getUseredu().getEduSchool());
			System.out.println("用户应聘职位:"+jobdeliver.getJobinfo().getJobName());
			System.out.println("======================");
			
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajieshu");
		return ActionSupport.SUCCESS;
	}
	
	//<a href="canDealResumes.jsp">待处理简历</a>
	/**
	 * 通过状态以及查询条件查找待处理简历
	 * sln
	 * @return
	 */
	@Action(value="canDealResumes",
			results={@Result(name="success",location="/HR/canDealResumes.jsp")})
	public String canDealResumes(){
		System.out.println("88888888888888888888接收页面参数(状态)为"+status);
		System.out.println("88888888888888888888接收页面参数(查询条件:工作经验)"+jobexp);
		System.out.println("88888888888888888888接收页面参数(查询条件:最低学历)"+jobedu);
		System.out.println("开始aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> resume_map=(Map<String, Object>) actionContext.get("request");
		//ResumeSearchVO(工作经验, 最低学历)
		ResumeSearchVO rSearchVO=new ResumeSearchVO(jobexp, jobedu);
		
		Map<String, Object> manager_map=actionContext.getSession();
		Companyinfo companyinfo=(Companyinfo) manager_map.get("companyinfo");
		/*Companyinfo companyinfo =new Companyinfo();//xxxxxxxxxxxxxxxxxxxxx登录成功后要从session中获得
		companyinfo=companyinfoDAO.findById(1);*/
		
		
		List<Jobdeliver> list=resumeinfoBIZ.findByResumeStatuss(companyinfo, 2, rSearchVO);
		resume_map.put("resumeList", list);//放入request中
		if(list.size()==0){
			System.out.println("查询无结果77777777777777777777777777777777777777777777777777");
		}
		for (Jobdeliver jobdeliver : list) {
			System.out.println("jdID:"+jobdeliver.getDeliverId());
			System.out.println("用户头像:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoImg());
			System.out.println("用户姓名:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoUsername());
			System.out.println("用户性别:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoSex());
			//jobdeliver.getJobinfo().getJobexp().getExpId()
			System.out.println("工作经验:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu()+"年");
			System.out.println("期望工作城市:"+jobdeliver.getResumeinfo().getExpectjob().getCityinfo().getCityName());
			System.out.println("期望工作:"+jobdeliver.getResumeinfo().getExpectjob().getExpectJobDept());
			System.out.println("投递公司:"+companyinfo.getCompanyName());
			System.out.println("用户学历:"+jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduName());
			System.out.println("用户毕业院校:"+jobdeliver.getResumeinfo().getUseredu().getEduSchool());
			System.out.println("用户应聘职位:"+jobdeliver.getJobinfo().getJobName());
			
			System.out.println("======================");
			
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajieshu");
		return ActionSupport.SUCCESS;
	}
	
	//<a href="canInterviewResumes.jsp">待定简历</a>
	/**
	 * 通过状态以及查询条件查找待定简历
	 * sln
	 * @return
	 */
	@Action(value="canInterviewResumes",
			results={@Result(name="success",location="/HR/canInterviewResumes.jsp")})
	public String canInterviewResumes(){
		System.out.println("88888888888888888888接收页面参数(状态)为"+status);
		System.out.println("88888888888888888888接收页面参数(查询条件:工作经验)"+jobexp);
		System.out.println("88888888888888888888接收页面参数(查询条件:最低学历)"+jobedu);
		System.out.println("开始aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> resume_map=(Map<String, Object>) actionContext.get("request");
		//ResumeSearchVO(工作经验, 最低学历)
		ResumeSearchVO rSearchVO=new ResumeSearchVO(jobexp, jobedu);
		
		Map<String, Object> manager_map=actionContext.getSession();
		Companyinfo companyinfo=(Companyinfo) manager_map.get("companyinfo");
		
		/*Companyinfo companyinfo =new Companyinfo();//xxxxxxxxxxxxxxxxxxxxx登录成功后要从session中获得
		companyinfo=companyinfoDAO.findById(1);*/
		
		
		List<Jobdeliver> list=resumeinfoBIZ.findByResumeStatuss(companyinfo, 4, rSearchVO);
		resume_map.put("resumeList", list);//放入request中
		if(list.size()==0){
			System.out.println("查询无结果77777777777777777777777777777777777777777777777777");
		}
		for (Jobdeliver jobdeliver : list) {
			System.out.println("用户头像:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoImg());
			System.out.println("用户姓名:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoUsername());
			System.out.println("用户性别:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoSex());
			//jobdeliver.getJobinfo().getJobexp().getExpId()
			System.out.println("工作经验:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu()+"年");
			System.out.println("期望工作城市:"+jobdeliver.getResumeinfo().getExpectjob().getCityinfo().getCityName());
			System.out.println("期望工作:"+jobdeliver.getResumeinfo().getExpectjob().getExpectJobDept());
			System.out.println("投递公司:"+companyinfo.getCompanyName());
			System.out.println("用户学历:"+jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduName());
			System.out.println("用户毕业院校:"+jobdeliver.getResumeinfo().getUseredu().getEduSchool());
			System.out.println("用户应聘职位:"+jobdeliver.getJobinfo().getJobName());
			System.out.println("======================");
			
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajieshu");
		return ActionSupport.SUCCESS;
	}
	
	//<a href="haveRefuseResumes.jsp">不合适简历</a>
	/**
	 * 通过状态以及查询条件查找不合适的简历
	 * sln
	 * @return
	 */
	@Action(value="findByResumeStatuss",
			results={@Result(name="success",location="/HR/haveRefuseResumes.jsp")})
	public String findByResumeStatuss(){
		System.out.println("88888888888888888888接收页面参数(状态)为"+status);
		System.out.println("88888888888888888888接收页面参数(查询条件:工作经验)"+jobexp);
		System.out.println("88888888888888888888接收页面参数(查询条件:最低学历)"+jobedu);
		System.out.println("开始aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> resume_map=(Map<String, Object>) actionContext.get("request");
		//ResumeSearchVO(工作经验, 最低学历)
		ResumeSearchVO rSearchVO=new ResumeSearchVO(jobexp, jobedu);
		
		Map<String, Object> manager_map=actionContext.getSession();
		Companyinfo companyinfo=(Companyinfo) manager_map.get("companyinfo");
		/*Companyinfo companyinfo =new Companyinfo();//xxxxxxxxxxxxxxxxxxxxx登录成功后要从session中获得
		companyinfo=companyinfoDAO.findById(1);*/
		
		
		List<Jobdeliver> list=resumeinfoBIZ.findByResumeStatuss(companyinfo, 6, rSearchVO);
		resume_map.put("resumeList", list);//放入request中
		if(list.size()==0){
			System.out.println("查询无结果77777777777777777777777777777777777777777777777777");
		}
		for (Jobdeliver jobdeliver : list) {
			System.out.println("jdID:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoImg());
			System.out.println("用户头像:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoImg());
			System.out.println("用户姓名:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoUsername());
			System.out.println("用户性别:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoSex());
			//jobdeliver.getJobinfo().getJobexp().getExpId()
			System.out.println("工作经验:"+jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu()+"年");
			System.out.println("期望工作城市:"+jobdeliver.getResumeinfo().getExpectjob().getCityinfo().getCityName());
			System.out.println("期望工作:"+jobdeliver.getResumeinfo().getExpectjob().getExpectJobDept());
			System.out.println("投递公司:"+companyinfo.getCompanyName());
			System.out.println("用户学历:"+jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduName());
			System.out.println("用户毕业院校:"+jobdeliver.getResumeinfo().getUseredu().getEduSchool());
			System.out.println("用户应聘职位:"+jobdeliver.getJobinfo().getJobName());
			System.out.println("======================");
			
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaajieshu");
		return ActionSupport.SUCCESS;
	}
    
	/*public CompanyinfoDAO getCompanyinfoDAO() {
		return companyinfoDAO;
	}

	public void setCompanyinfoDAO(CompanyinfoDAO companyinfoDAO) {
		this.companyinfoDAO = companyinfoDAO;
	}*/

	public ResumeinfoBIZ getResumeinfoBIZ() {
		return resumeinfoBIZ;
	}

	public void setResumeinfoBIZ(ResumeinfoBIZ resumeinfoBIZ) {
		this.resumeinfoBIZ = resumeinfoBIZ;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getJobexp() {
		return jobexp;
	}

	public void setJobexp(Integer jobexp) {
		this.jobexp = jobexp;
	}

	public Integer getJobedu() {
		return jobedu;
	}

	public void setJobedu(Integer jobedu) {
		this.jobedu = jobedu;
	}

	
	

}
