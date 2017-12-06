package com.lagou.dao;

import static org.hibernate.criterion.Example.create;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.utils.GetJobexId;
import com.lagou.vo.ResumeSearchVO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Resumeinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Resumeinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ResumeinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ResumeinfoDAO.class);
	// property constants
	public static final String RESUME_DESC = "resumeDesc";

	private SessionFactory sessionFactory;

	/**
	 * 通过用户Id查找该用户的简历信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 简历信息对象
	 */
	public List<Resumeinfo> findByUser(int userId) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"/applicationContext.xml");
//		 Session session=(Session) context.getBean("sessionFactory");
		Criteria criteria = getCurrentSession().createCriteria(Resumeinfo.class);
		criteria.createAlias("userinfo", "userinfo");
		criteria.add(Restrictions.eq("userinfo.userinfoId", userId));
		List<Resumeinfo> resumeInfo = (List<Resumeinfo>) criteria.list();
		for (Resumeinfo resumeinfo2 : resumeInfo) {
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println(resumeinfo2.getResumeDesc());
		}
		return resumeInfo;
	}
	/**
	 * 更新简历信息
	 * @param resumeInfo 简历信息对象
	 */
	public void update(Resumeinfo resumeInfo){
		log.debug("update Resumeinfo instance");
		try {
			getCurrentSession().update(resumeInfo);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
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
				if (jobdeliver.getResumeinfo().getUseredu().getJobedu().getEduId()<resumeSearchVO.getJobedu()) {
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
	
	protected void initDao() {
		// do nothing
	}

	public void save(Resumeinfo transientInstance) {
		log.debug("saving Resumeinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Resumeinfo persistentInstance) {
		log.debug("deleting Resumeinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Resumeinfo findById(java.lang.Integer id) {
		log.debug("getting Resumeinfo instance with id: " + id);
		try {
			Resumeinfo instance = (Resumeinfo) getCurrentSession().get(
					"com.lagou.domain.Resumeinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Resumeinfo> findByExample(Resumeinfo instance) {
		log.debug("finding Resumeinfo instance by example");
		try {
			List<Resumeinfo> results = (List<Resumeinfo>) getCurrentSession()
					.createCriteria("com.lagou.domain.Resumeinfo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Resumeinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Resumeinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Resumeinfo> findByResumeDesc(Object resumeDesc) {
		return findByProperty(RESUME_DESC, resumeDesc);
	}

	public List findAll() {
		log.debug("finding all Resumeinfo instances");
		try {
			String queryString = "from Resumeinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Resumeinfo merge(Resumeinfo detachedInstance) {
		log.debug("merging Resumeinfo instance");
		try {
			Resumeinfo result = (Resumeinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Resumeinfo instance) {
		log.debug("attaching dirty Resumeinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Resumeinfo instance) {
		log.debug("attaching clean Resumeinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResumeinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ResumeinfoDAO) ctx.getBean("ResumeinfoDAO");
	}
}