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

import com.lagou.domain.Cityinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cityinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Cityinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CityinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CityinfoDAO.class);
	// property constants
	public static final String CITY_NAME = "cityName";

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

	public void save(Cityinfo transientInstance) {
		log.debug("saving Cityinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cityinfo persistentInstance) {
		log.debug("deleting Cityinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cityinfo findById(java.lang.Integer id) {
		log.debug("getting Cityinfo instance with id: " + id);
		try {
			Cityinfo instance = (Cityinfo) getCurrentSession().get(
					"com.lagou.domain.Cityinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cityinfo> findByExample(Cityinfo instance) {
		log.debug("finding Cityinfo instance by example");
		try {
			List<Cityinfo> results = (List<Cityinfo>) getCurrentSession()
					.createCriteria("com.lagou.domain.Cityinfo")
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
		log.debug("finding Cityinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cityinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Cityinfo> findByCityName(Object cityName) {
		return findByProperty(CITY_NAME, cityName);
	}

	public List findAll() {
		log.debug("finding all Cityinfo instances");
		try {
			String queryString = "from Cityinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cityinfo merge(Cityinfo detachedInstance) {
		log.debug("merging Cityinfo instance");
		try {
			Cityinfo result = (Cityinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cityinfo instance) {
		log.debug("attaching dirty Cityinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cityinfo instance) {
		log.debug("attaching clean Cityinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CityinfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CityinfoDAO) ctx.getBean("CityinfoDAO");
	}
}