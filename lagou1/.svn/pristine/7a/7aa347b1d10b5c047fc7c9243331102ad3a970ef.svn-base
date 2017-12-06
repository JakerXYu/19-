package com.lagou.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





import com.lagou.bizImp.ResumeinfoBIZImp;
import com.lagou.dao.CompanyinfoDAO;
import com.lagou.dao.ResumeinfoDAO;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Resumeinfo;
import com.lagou.vo.ResumeSearchVO;

public class SubResumeinfoDaoTest {
	

	public static void main(String[] args) {
	System.out.println("kaishi");
//	ResumeinfoDAO subResumeinfoDAO=new ResumeinfoDAO();
//	ResumeSearchVO rSearchVO=new ResumeSearchVO(1, 1, 1);
//	Companyinfo companyinfo =new Companyinfo();
//	companyinfo.setCompanyId(1);
//	List<Resumeinfo> list=subResumeinfoDAO.findAll();
////	List<Resumeinfo> list=subResumeinfoDAO.findByResumeStatuss(companyinfo, 1, rSearchVO);
//	System.out.println(list);
//	Resumeinfo resumeinfo=new Resumeinfo();
//	resumeinfo.setResumeId(1);
//	resumeInfoBIZ.SaveResume(resumeinfo);
	
	
//	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
//	ResumeinfoDAO resumeinfoDAO=(ResumeinfoDAO) context.getBean("ResumeinfoDAO");
//	ResumeInfoBIZ resumeInfoBIZ=new ResumeInfoBIZ();
//	resumeInfoBIZ.setResumeinfoDAO(resumeinfoDAO);
//	List<Resumeinfo> list=resumeInfoBIZ.findall();
	
	
	
	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
	//ResumeinfoDAO resumeinfoDAO=(ResumeinfoDAO) context.getBean("ResumeinfoDAO");
	//ResumeinfoBIZImp resumeInfoBIZ=(ResumeinfoBIZImp) context.getBean("ResumeinfoBIZImp");
	CompanyinfoDAO companyinfoDAO=(CompanyinfoDAO) context.getBean("CompanyinfoDAO");
	//resumeInfoBIZ.setResumeinfoDAO(resumeinfoDAO);
	
	Test test=new Test();
	ResumeSearchVO rSearchVO=new ResumeSearchVO(6, 2);
	Companyinfo companyinfo =new Companyinfo();
	companyinfo=companyinfoDAO.findById(1);
	List<Jobdeliver> list=test.findByResumeStatuss(companyinfo, 1, rSearchVO);
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
	
	System.out.println("jieshu");
	}
	
}

