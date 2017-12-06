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

import com.lagou.domain.Companycheck;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companycheck entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lagou.domain.Companycheck
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanycheckDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanycheckDAO.class);
	// property constants
	public static final String COMPANY_CHECK_STATE = "companyCheckState";
	public static final String COMPANY_CHECK_MESSAGE = "companyCheckMessage";

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

	public void save(Companycheck transientInstance) {
		log.debug("saving Companycheck instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companycheck persistentInstance) {
		log.debug("deleting Companycheck instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companycheck findById(java.lang.Integer id) {
		log.debug("getting Companycheck instance with id: " + id);
		try {
			Companycheck instance = (Companycheck) getCurrentSession().get(
					"com.lagou.domain.Companycheck", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Companycheck> findByExample(Companycheck instance) {
		log.debug("finding Companycheck instance by example");
		try {
			List<Companycheck> results = (List<Companycheck>) getCurrentSession()
					.createCriteria("com.lagou.domain.Companycheck")
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
		log.debug("finding Companycheck instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companycheck as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Companycheck> findByCompanyCheckState(Object companyCheckState) {
		return findByProperty(COMPANY_CHECK_STATE, companyCheckState);
	}

	public List<Companycheck> findByCompanyCheckMessage(
			Object companyCheckMessage) {
		return findByProperty(COMPANY_CHECK_MESSAGE, companyCheckMessage);
	}

	public List findAll() {
		log.debug("finding all Companycheck instances");
		try {
			String queryString = "from Companycheck";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Companycheck merge(Companycheck detachedInstance) {
		log.debug("merging Companycheck instance");
		try {
			Companycheck result = (Companycheck) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companycheck instance) {
		log.debug("attaching dirty Companycheck instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companycheck instance) {
		log.debug("attaching clean Companycheck instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanycheckDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanycheckDAO) ctx.getBean("CompanycheckDAO");
	}
}