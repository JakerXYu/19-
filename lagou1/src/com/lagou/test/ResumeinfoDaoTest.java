package com.lagou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lagou.dao.ResumeinfoDAO;
import com.lagou.domain.Expectjob;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Useredu;
import com.lagou.domain.Userinfo;
import com.lagou.domain.Userworkexp;

public class ResumeinfoDaoTest {
	

	public static void main(String[] args) {
	System.out.println("kaishi");
	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
	ResumeinfoDAO resumeinfoDAO=(ResumeinfoDAO) context.getBean("ResumeinfoDAO");
	Resumeinfo resumeinfo=new Resumeinfo();
	Expectjob expectjob=new Expectjob();expectjob.setExpectJobId(1);
	Userworkexp userworkexp=new Userworkexp();userworkexp.setWorkexpId(1);
	Userinfo userinfo=new Userinfo();userinfo.setUserinfoId(1);
	Useredu useredu=new Useredu();useredu.setEduId(1);
	resumeinfo.setExpectjob(expectjob);
	resumeinfo.setUserworkexp(userworkexp);
	resumeinfo.setUserinfo(userinfo);
	resumeinfo.setUseredu(useredu);
	resumeinfo.setResumeId(5);
	resumeinfo.setResumeDesc("哒哒哒");
	resumeinfoDAO.update(resumeinfo);
	
	System.out.println("jieshu");
	}
	
}

