package com.lagou.subdao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lagou.dao.ResumeinfoDAO;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;

public class SubResumeinfoDAO extends ResumeinfoDAO {
public List<Resumeinfo> findByResumeStatus(Jobinfo jobinfo,int status){
	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
	Session session=(Session) context.getBean("sessionFactory");
	String sql="select * from  jobdeliver where deliver_job in (select job_id from jobinfo where job_company ="
			+ jobinfo.getJobId()
			+") and  deliver_status ="
			+ status;
	SQLQuery sqlQuery=session.createSQLQuery(sql);
	sqlQuery.addEntity(Resumeinfo.class);
	List<Resumeinfo> resumeinfos=sqlQuery.list();
	return resumeinfos;
}

}
