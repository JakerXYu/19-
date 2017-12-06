package com.lagou.dao;

import java.sql.Timestamp;
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

import com.lagou.domain.Auditioninfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Auditioninfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lagou.domain.Auditioninfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AuditioninfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AuditioninfoDAO.class);
	// property constants
	public static final String AUDITION_ADDRESS = "auditionAddress";
	public static final String AUDITION_DESCRIBE = "auditionDescribe";

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

	public void save(Auditioninfo transientInstance) {
		log.debug("saving Auditioninfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Auditioninfo persistentInstance) {
		log.debug("deleting Auditioninfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Auditioninfo findById(java.lang.Integer id) {
		log.debug("getting Auditioninfo instance with id: " + id);
		try {
			Auditioninfo instance = (Auditioninfo) getCurrentSession().get(
					"com.lagou.domain.Auditioninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Auditioninfo> findByExample(Auditioninfo instance) {
		log.debug("finding Auditioninfo instance by example");
		try {
			List<Auditioninfo> results = (List<Auditioninfo>) getCurrentSession()
					.createCriteria("com.lagou.domain.Auditioninfo")
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
		log.debug("finding Auditioninfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Auditioninfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Auditioninfo> findByAuditionAddress(Object auditionAddress) {
		return findByProperty(AUDITION_ADDRESS, auditionAddress);
	}

	public List<Auditioninfo> findByAuditionDescribe(Object auditionDescribe) {
		return findByProperty(AUDITION_DESCRIBE, auditionDescribe);
	}

	public List findAll() {
		log.debug("finding all Auditioninfo instances");
		try {
			String queryString = "from Auditioninfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Auditioninfo merge(Auditioninfo detachedInstance) {
		log.debug("merging Auditioninfo instance");
		try {
			Auditioninfo result = (Auditioninfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Auditioninfo instance) {
		log.debug("attaching dirty Auditioninfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Auditioninfo instance) {
		log.debug("attaching clean Auditioninfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AuditioninfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AuditioninfoDAO) ctx.getBean("AuditioninfoDAO");
	}
}