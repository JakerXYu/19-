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

import com.lagou.domain.Sal;

/**
 * A data access object (DAO) providing persistence and search support for Sal
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.lagou.domain.Sal
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SalDAO {
	private static final Logger log = LoggerFactory.getLogger(SalDAO.class);
	// property constants
	public static final String SAL_MAX = "salMax";
	public static final String SAL_MIN = "salMin";

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

	public void save(Sal transientInstance) {
		log.debug("saving Sal instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sal persistentInstance) {
		log.debug("deleting Sal instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sal findById(java.lang.Integer id) {
		log.debug("getting Sal instance with id: " + id);
		try {
			Sal instance = (Sal) getCurrentSession().get(
					"com.lagou.domain.Sal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sal> findByExample(Sal instance) {
		log.debug("finding Sal instance by example");
		try {
			List<Sal> results = (List<Sal>) getCurrentSession()
					.createCriteria("com.lagou.domain.Sal")
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
		log.debug("finding Sal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sal as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Sal> findBySalMax(Object salMax) {
		return findByProperty(SAL_MAX, salMax);
	}

	public List<Sal> findBySalMin(Object salMin) {
		return findByProperty(SAL_MIN, salMin);
	}

	public List findAll() {
		log.debug("finding all Sal instances");
		try {
			String queryString = "from Sal";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sal merge(Sal detachedInstance) {
		log.debug("merging Sal instance");
		try {
			Sal result = (Sal) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sal instance) {
		log.debug("attaching dirty Sal instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sal instance) {
		log.debug("attaching clean Sal instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalDAO) ctx.getBean("SalDAO");
	}
}