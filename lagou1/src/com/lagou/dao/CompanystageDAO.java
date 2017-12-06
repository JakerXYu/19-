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

import com.lagou.domain.Companystage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companystage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lagou.domain.Companystage
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanystageDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanystageDAO.class);
	// property constants
	public static final String STAGE_NAME = "stageName";

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

	public void save(Companystage transientInstance) {
		log.debug("saving Companystage instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companystage persistentInstance) {
		log.debug("deleting Companystage instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companystage findById(java.lang.Integer id) {
		log.debug("getting Companystage instance with id: " + id);
		try {
			Companystage instance = (Companystage) getCurrentSession().get(
					"com.lagou.domain.Companystage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Companystage> findByExample(Companystage instance) {
		log.debug("finding Companystage instance by example");
		try {
			List<Companystage> results = (List<Companystage>) getCurrentSession()
					.createCriteria("com.lagou.domain.Companystage")
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
		log.debug("finding Companystage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companystage as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Companystage> findByStageName(Object stageName) {
		return findByProperty(STAGE_NAME, stageName);
	}

	public List findAll() {
		log.debug("finding all Companystage instances");
		try {
			String queryString = "from Companystage";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Companystage merge(Companystage detachedInstance) {
		log.debug("merging Companystage instance");
		try {
			Companystage result = (Companystage) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companystage instance) {
		log.debug("attaching dirty Companystage instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companystage instance) {
		log.debug("attaching clean Companystage instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanystageDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanystageDAO) ctx.getBean("CompanystageDAO");
	}
}