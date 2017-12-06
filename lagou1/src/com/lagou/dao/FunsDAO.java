package com.lagou.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Funs;

/**
 * A data access object (DAO) providing persistence and search support for Funs
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.lagou.domain.Funs
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FunsDAO {
	private static final Logger log = LoggerFactory.getLogger(FunsDAO.class);
	// property constants
	public static final String FUN_NAME = "funName";
	public static final String FUN_URL = "funUrl";
	public static final String FUN_LEVEL = "funLevel";
	public static final String FUN_TARGET = "funTarget";

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
	
	//自己补的方法
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Funs> findBy(java.lang.Integer id) {
		log.debug("getting Funs instance with id: " + id);
		try {
			Funs instance = (Funs) getCurrentSession().get(
					"com.lagou.domain.Funs", id);
			return instance.getFunses();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * 根基等级查寻功能
	 * @param Level
	 * @return
	 */
	public List<Funs> findByLevel(Integer Level) {
		try {
			String queryString = "from Funs as model where model."
					+ this.FUN_LEVEL + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, Level);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	
	//
	public void save(Funs transientInstance) {
		log.debug("saving Funs instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Funs persistentInstance) {
		log.debug("deleting Funs instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Funs findById(java.lang.Integer id) {
		log.debug("getting Funs instance with id: " + id);
		try {
			Funs instance = (Funs) getCurrentSession().get(
					"com.lagou.domain.Funs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Funs> findByExample(Funs instance) {
		log.debug("finding Funs instance by example");
		try {
			List<Funs> results = (List<Funs>) getCurrentSession()
					.createCriteria("com.lagou.domain.Funs")
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
		log.debug("finding Funs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Funs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Funs> findByFunName(Object funName) {
		return findByProperty(FUN_NAME, funName);
	}

	public List<Funs> findByFunUrl(Object funUrl) {
		return findByProperty(FUN_URL, funUrl);
	}

	public List<Funs> findByFunLevel(Object funLevel) {
		return findByProperty(FUN_LEVEL, funLevel);
	}

	public List<Funs> findByFunTarget(Object funTarget) {
		return findByProperty(FUN_TARGET, funTarget);
	}

	public List findAll() {
		log.debug("finding all Funs instances");
		try {
			String queryString = "from Funs";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Funs merge(Funs detachedInstance) {
		log.debug("merging Funs instance");
		try {
			Funs result = (Funs) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Funs instance) {
		log.debug("attaching dirty Funs instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Funs instance) {
		log.debug("attaching clean Funs instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FunsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FunsDAO) ctx.getBean("FunsDAO");
	}
}