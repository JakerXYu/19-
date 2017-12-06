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
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Subscribe;
import com.lagou.domain.Userinfo;


/**
 * A data access object (DAO) providing persistence and search support for
 * Subscribe entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Subscribe
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SubscribeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SubscribeDAO.class);
	// property constants
	public static final String SUB_WEEKDAY = "subWeekday";

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
	
	public void update(){
		
	}
	
	public List<Subscribe> findByUser(Userinfo userinfo) {
		log.debug("finding Subscribe instance by userinfo");
		try {
			List<Subscribe> results = (List<Subscribe>) getCurrentSession()
					.createCriteria("com.lagou.domain.Subscribe").createCriteria("userinfo") 
					.add(Restrictions.eq("userinfoId", userinfo.getUserinfoId())).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	

	public void save(Subscribe subscribe) {
		log.debug("saving Admins instance");
		try {
			getCurrentSession().save(subscribe);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Subscribe persistentInstance) {
		log.debug("deleting Subscribe instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Subscribe findById(java.lang.Integer id) {
		log.debug("getting Subscribe instance with id: " + id);
		try {
			Subscribe instance = (Subscribe) getCurrentSession().get(
					"com.lagou.domain.Subscribe", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Subscribe> findByExample(Subscribe instance) {
		log.debug("finding Subscribe instance by example");
		try {
			List<Subscribe> results = (List<Subscribe>) getCurrentSession()
					.createCriteria("com.lagou.domain.Subscribe")
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
		log.debug("finding Subscribe instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Subscribe as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Subscribe> findBySubWeekday(Object subWeekday) {
		return findByProperty(SUB_WEEKDAY, subWeekday);
	}

	public List findAll() {
		log.debug("finding all Subscribe instances");
		try {
			String queryString = "from Subscribe";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Subscribe merge(Subscribe detachedInstance) {
		log.debug("merging Subscribe instance");
		try {
			Subscribe result = (Subscribe) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Subscribe instance) {
		log.debug("attaching dirty Subscribe instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Subscribe instance) {
		log.debug("attaching clean Subscribe instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SubscribeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SubscribeDAO) ctx.getBean("SubscribeDAO");
	}
}