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

import com.lagou.domain.Companysize;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companysize entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lagou.domain.Companysize
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanysizeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanysizeDAO.class);
	// property constants
	public static final String SIZE_NAME = "sizeName";

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

	public void save(Companysize transientInstance) {
		log.debug("saving Companysize instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companysize persistentInstance) {
		log.debug("deleting Companysize instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companysize findById(java.lang.Integer id) {
		log.debug("getting Companysize instance with id: " + id);
		try {
			Companysize instance = (Companysize) getCurrentSession().get(
					"com.lagou.domain.Companysize", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Companysize> findByExample(Companysize instance) {
		log.debug("finding Companysize instance by example");
		try {
			List<Companysize> results = (List<Companysize>) getCurrentSession()
					.createCriteria("com.lagou.domain.Companysize")
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
		log.debug("finding Companysize instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Companysize as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Companysize> findBySizeName(Object sizeName) {
		return findByProperty(SIZE_NAME, sizeName);
	}

	public List findAll() {
		log.debug("finding all Companysize instances");
		try {
			String queryString = "from Companysize";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Companysize merge(Companysize detachedInstance) {
		log.debug("merging Companysize instance");
		try {
			Companysize result = (Companysize) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companysize instance) {
		log.debug("attaching dirty Companysize instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companysize instance) {
		log.debug("attaching clean Companysize instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanysizeDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanysizeDAO) ctx.getBean("CompanysizeDAO");
	}
}