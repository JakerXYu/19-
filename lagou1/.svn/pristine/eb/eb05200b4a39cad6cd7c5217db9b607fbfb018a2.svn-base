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

import com.lagou.domain.Jobexp;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jobexp entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Jobexp
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobexpDAO {
	private static final Logger log = LoggerFactory.getLogger(JobexpDAO.class);
	// property constants
	public static final String EXP_NAME = "expName";

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

	public void save(Jobexp transientInstance) {
		log.debug("saving Jobexp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobexp persistentInstance) {
		log.debug("deleting Jobexp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobexp findById(java.lang.Integer id) {
		log.debug("getting Jobexp instance with id: " + id);
		try {
			Jobexp instance = (Jobexp) getCurrentSession().get(
					"com.lagou.domain.Jobexp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobexp> findByExample(Jobexp instance) {
		log.debug("finding Jobexp instance by example");
		try {
			List<Jobexp> results = (List<Jobexp>) getCurrentSession()
					.createCriteria("com.lagou.domain.Jobexp")
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
		log.debug("finding Jobexp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobexp as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Jobexp> findByExpName(Object expName) {
		return findByProperty(EXP_NAME, expName);
	}

	public List findAll() {
		log.debug("finding all Jobexp instances");
		try {
			String queryString = "from Jobexp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobexp merge(Jobexp detachedInstance) {
		log.debug("merging Jobexp instance");
		try {
			Jobexp result = (Jobexp) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobexp instance) {
		log.debug("attaching dirty Jobexp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobexp instance) {
		log.debug("attaching clean Jobexp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobexpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobexpDAO) ctx.getBean("JobexpDAO");
	}
}