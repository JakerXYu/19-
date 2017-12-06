package com.lagou.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.utils.GetJobexId;
import com.lagou.vo.ResumeSearchVO;

public class Test {

	/**
	 * 通过简历状态(待处理,待定等)以及简历查询条件(工作经验,最低学历)查询投递到该公司的简历
	 * 
	 * @param companyinfo
	 *            公司信息表
	 * @param status
	 *            状态(可传待处理简历,待定简历,已通知面试等状态)
	 * @param resumeSearchVO
	 *            简历查询条件(工作经验,最低学历)
	 * @return
	 */
	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo,
			int status, ResumeSearchVO resumeSearchVO) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Criteria criteria1 = session.createCriteria(Jobinfo.class);

		// 跟据jobinfo表中的job_company字段查询出该公司发布的职位

		/**
		 * 查询出所有当前公司的职业信息记录，并取得的职业信息的ID 存到一个jobidList中。
		 */

		criteria1.createAlias("companyinfo", "companyinfo");
		Criterion criterion1 = Restrictions.eq("companyinfo.companyId",
				companyinfo.getCompanyId());
		criteria1.add(criterion1);
		List<Jobinfo> jobList = criteria1.list();// 该公司发布的职位集合
		List<Integer> jobidList = new ArrayList<Integer>();
		for (Jobinfo jobinfo2 : jobList) {
			jobidList.add(jobinfo2.getJobId());// 职位ID集合
		}

		/**
		 * 再查询出投递简历记录表(jobdeliver)中投递的职位在jobidlist中的所有记录,
		 * 以及状态为传递进来的Status的简历
		 *
		 *
		 * resumestatus简历投递状态表(待处理,待定等状态)
		 */
		Criteria criteria2 = session.createCriteria(Jobdeliver.class);
		criteria2.createAlias("jobinfo", "jobinfo");
		criteria2.createAlias("resumestatus", "resumestatus");
		Criterion criterion2 = Restrictions.in("jobinfo.jobId", jobidList);
		Criterion criterion4 = Restrictions.eq("resumestatus.statusId", status);
		criteria2.add(criterion2).add(criterion4);
		criteria2.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//去重
		List<Jobdeliver> jobdelivers = criteria2.list();
		
		
		// 再根据简历查询条件(工作经验,最低学历)查询符合条件的简历
		
		if (resumeSearchVO.getJobedu() != null) {
			Iterator<Jobdeliver> iterator=jobdelivers.iterator();
			while (iterator.hasNext()) {
				Jobdeliver jobdeliver=iterator.next();
				if (jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduId()!=resumeSearchVO.getJobedu()) {
					System.out.println(jobdeliver.getDeliverId()+"getJobedu----------------------------------------");
					iterator.remove();
				
				}
				
			}
		}
		if (resumeSearchVO.getJobexp() != null) {
			Iterator<Jobdeliver> iterator=jobdelivers.iterator();
			while (iterator.hasNext()) {
				Jobdeliver jobdeliver=iterator.next();
				System.out.println("1111111111111111111111111111111111111111用户填的工作经验:"+
						jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu());
				int i=GetJobexId.getJobexId(jobdeliver.getResumeinfo().getUserinfo().getUserinfoEdu());
				System.out.println("1111111111111111111111111111111111111111111111在Jobex表中的Id为:"+i);
				if(i!=resumeSearchVO.getJobexp()&&resumeSearchVO.getJobexp()!=1){
					System.out.println(jobdeliver.getDeliverId()+"getJobexp---------------------------------------");
					
					iterator.remove();
				}
				
			}
			
		}
		return jobdelivers;
	}

	/**
	 * 是上面findByResumeStatuss方法的重载
	 * 
	 * @param companyinfo
	 * @param status
	 * @return
	 */
	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo,
			int status) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Criteria criteria1 = session.createCriteria(Jobinfo.class);

		// 跟据jobinfo表中的job_company字段查询出该公司发布的职位

		/**
		 * 查询出所有当前公司的职业信息记录，并取得的职业信息的ID 存到一个jobidList中。
		 */

		criteria1.createAlias("companyinfo", "companyinfo");
		Criterion criterion1 = Restrictions.eq("companyinfo.companyId",
				companyinfo.getCompanyId());
		criteria1.add(criterion1);
		List<Jobinfo> jobList = criteria1.list();// 该公司发布的职位集合
		List<Integer> jobidList = new ArrayList<Integer>();
		for (Jobinfo jobinfo2 : jobList) {
			jobidList.add(jobinfo2.getJobId());// 职位ID集合
		}

		/**
		 * 再查询出投递简历记录表(jobdeliver)中投递的职位在jobidlist中的所有记录,
		 * 以及状态为传递进来的Status的简历
		 *
		 *
		 * resumestatus简历投递状态表(待处理,待定等状态)
		 */
		Criteria criteria2 = session.createCriteria(Jobdeliver.class);
		criteria2.createAlias("jobinfo", "jobinfo");
		criteria2.createAlias("resumestatus", "resumestatus");
		Criterion criterion2 = Restrictions.in("jobinfo.jobId", jobidList);
		Criterion criterion4 = Restrictions.eq("resumestatus.statusId", status);
		criteria2.add(criterion2).add(criterion4);
		criteria2.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//去重
		List<Jobdeliver> jobdelivers = criteria2.list();
		return jobdelivers;
	}

}
