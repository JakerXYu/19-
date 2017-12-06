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

import com.lagou.domain.Jobstatus;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jobstatus entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Jobstatus
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobstatusDAO {
	private static final Logger log = LoggerFactory
			.getLogger(JobstatusDAO.class);
	// property constants
	public static final String STATUS_NAME = "statusName";

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

	public void save(Jobstatus transientInstance) {
		log.debug("saving Jobstatus instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobstatus persistentInstance) {
		log.debug("deleting Jobstatus instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobstatus findById(java.lang.Integer id) {
		log.debug("getting Jobstatus instance with id: " + id);
		try {
			Jobstatus instance = (Jobstatus) getCurrentSession().get(
					"com.lagou.domain.Jobstatus", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobstatus> findByExample(Jobstatus instance) {
		log.debug("finding Jobstatus instance by example");
		try {
			List<Jobstatus> results = (List<Jobstatus>) getCurrentSession()
					.createCriteria("com.lagou.domain.Jobstatus")
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
		log.debug("finding Jobstatus instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobstatus as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Jobstatus> findByStatusName(Object statusName) {
		return findByProperty(STATUS_NAME, statusName);
	}

	public List findAll() {
		log.debug("finding all Jobstatus instances");
		try {
			String queryString = "from Jobstatus";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobstatus merge(Jobstatus detachedInstance) {
		log.debug("merging Jobstatus instance");
		try {
			Jobstatus result = (Jobstatus) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobstatus instance) {
		log.debug("attaching dirty Jobstatus instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobstatus instance) {
		log.debug("attaching clean Jobstatus instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobstatusDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobstatusDAO) ctx.getBean("JobstatusDAO");
	}
}