package com.lagou.dao;

import java.util.List;










import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Userinfo;


/**
 * A data access object (DAO) providing persistence and search support for
 * Jobdeliver entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Jobdeliver
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobdeliverDAO {
	/**
	 *把一个简历对象保存到简历投递表里
	 * @param 投递记录
	 * @author 陶雅楠
	 */
	public void save(Jobdeliver transientInstance) {
		log.debug("saving Jobdeliver instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
/**
 * 更新投递记录表
 * @param Jobdeliver
 * @author ZH
 *
 */
	
	public void update(Jobdeliver jobdeliver){
		log.debug("update Jobdeliver instance");
		try {
			getCurrentSession().update(jobdeliver);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	    
	    /**
	     * 查询当前用户所有处于该状态的投递信息
	     * @param userinfo 用户对象
	     * @param status 投递状态
	     * @return 投递记录的集合
	     */
	     public List<Jobdeliver> findByResumeStatus(int resumeid,int status){
			
			Session session = getCurrentSession();
			Criteria criteria=session.createCriteria(Jobdeliver.class);
			criteria.createAlias("resumestatus", "resumestatus");
			criteria.createAlias("resumeinfo", "resumeinfo");
			/* criteria.createAlias("jobinfo", "jobinfo");*/
			criteria.add(Restrictions.eq("resumestatus.statusId", status));
			criteria.add(Restrictions.eq("resumeinfo.resumeId", resumeid));
			
			return criteria.list();
	} 
	     
	     /**
	      * 查找所有简历
	      * @param resumeinfoid1
	      * @return
	      */
			
	     public List<Jobdeliver> findByUser(int resumeinfoid){
	    	 Session session=getCurrentSession();
	    	 Criteria criteria=session.createCriteria(Jobdeliver.class);
	    	 criteria.createAlias("resumeinfo", "resumeinfo");
	    	 /*criteria.createAlias("jobinfo", "jobinfo");*/
	    	 /*criteria.createAlias("resumestatus", "resumestatus");*/
	    	 Criterion criterion=Restrictions.eq("resumeinfo.resumeId", resumeinfoid);
	    	 
	    	 criteria.add(criterion);
	    	 
	    	 return criteria.list();
	     }
	     /**
		  * 查看我投递的职位
		  * @param userinfo
		  * @return 职位信息集合
		  */
		 public List<Jobinfo> findJobDeliver(Userinfo userinfo){
		     Session session=getCurrentSession();
		     Criteria criteria=session.createCriteria(Jobdeliver.class);
		     criteria.createAlias("jobinfo", "jobinfo");
		     criteria.createAlias("resumeinfo", "resumeinfo");
		     Criterion criterion=Restrictions.eq("resumeinfo.resdumeId",userinfo);
		     criteria.add(criterion);
			 return criteria.list();
		 }

	
	
	
	
	private static final Logger log = LoggerFactory
			.getLogger(JobdeliverDAO.class);
	// property constants

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

//	public void save(Jobdeliver transientInstance) {
//		log.debug("saving Jobdeliver instance");
//		try {
//			getCurrentSession().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
//	}

	public void delete(Jobdeliver persistentInstance) {
		log.debug("deleting Jobdeliver instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobdeliver findById(java.lang.Integer id) {
		log.debug("getting Jobdeliver instance with id: " + id);
		try {
			Jobdeliver instance = (Jobdeliver) getCurrentSession().get(
					"com.lagou.domain.Jobdeliver", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobdeliver> findByExample(Jobdeliver instance) {
		log.debug("finding Jobdeliver instance by example");
		try {
			List<Jobdeliver> results = (List<Jobdeliver>) getCurrentSession()
					.createCriteria("com.lagou.domain.Jobdeliver")
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
		log.debug("finding Jobdeliver instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobdeliver as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Jobdeliver instances");
		try {
			String queryString = "from Jobdeliver";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobdeliver merge(Jobdeliver detachedInstance) {
		log.debug("merging Jobdeliver instance");
		try {
			Jobdeliver result = (Jobdeliver) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobdeliver instance) {
		log.debug("attaching dirty Jobdeliver instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobdeliver instance) {
		log.debug("attaching clean Jobdeliver instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobdeliverDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobdeliverDAO) ctx.getBean("JobdeliverDAO");
	}
}