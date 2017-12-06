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

import com.lagou.domain.Jobprop;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jobprop entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Jobprop
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobpropDAO {
	private static final Logger log = LoggerFactory.getLogger(JobpropDAO.class);
	// property constants
	public static final String PROP_NAME = "propName";

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

	public void save(Jobprop transientInstance) {
		log.debug("saving Jobprop instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobprop persistentInstance) {
		log.debug("deleting Jobprop instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobprop findById(java.lang.Integer id) {
		log.debug("getting Jobprop instance with id: " + id);
		try {
			Jobprop instance = (Jobprop) getCurrentSession().get(
					"com.lagou.domain.Jobprop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobprop> findByExample(Jobprop instance) {
		log.debug("finding Jobprop instance by example");
		try {
			List<Jobprop> results = (List<Jobprop>) getCurrentSession()
					.createCriteria("com.lagou.domain.Jobprop")
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
		log.debug("finding Jobprop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobprop as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Jobprop> findByPropName(Object propName) {
		return findByProperty(PROP_NAME, propName);
	}

	public List findAll() {
		log.debug("finding all Jobprop instances");
		try {
			String queryString = "from Jobprop";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobprop merge(Jobprop detachedInstance) {
		log.debug("merging Jobprop instance");
		try {
			Jobprop result = (Jobprop) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobprop instance) {
		log.debug("attaching dirty Jobprop instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobprop instance) {
		log.debug("attaching clean Jobprop instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobpropDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobpropDAO) ctx.getBean("JobpropDAO");
	}
}