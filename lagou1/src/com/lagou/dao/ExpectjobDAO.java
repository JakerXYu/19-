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

import com.lagou.domain.Expectjob;
import com.lagou.domain.Resumeinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expectjob entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Expectjob
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ExpectjobDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ExpectjobDAO.class);
	// property constants
	public static final String EXPECT_JOB_DEPT = "expectJobDept";

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
	/**
	 * 更新简历信息——期望工作
	 * @param 
	 */
	public void update(Expectjob expectjob){
		log.debug("update Resumeinfo instance");
		try {
			getCurrentSession().update(expectjob);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void save(Expectjob transientInstance) {
		log.debug("saving Expectjob instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expectjob persistentInstance) {
		log.debug("deleting Expectjob instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Expectjob findById(java.lang.Integer id) {
		log.debug("getting Expectjob instance with id: " + id);
		try {
			Expectjob instance = (Expectjob) getCurrentSession().get(
					"com.lagou.domain.Expectjob", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Expectjob> findByExample(Expectjob instance) {
		log.debug("finding Expectjob instance by example");
		try {
			List<Expectjob> results = (List<Expectjob>) getCurrentSession()
					.createCriteria("com.lagou.domain.Expectjob")
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
		log.debug("finding Expectjob instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Expectjob as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Expectjob> findByExpectJobDept(Object expectJobDept) {
		return findByProperty(EXPECT_JOB_DEPT, expectJobDept);
	}

	public List findAll() {
		log.debug("finding all Expectjob instances");
		try {
			String queryString = "from Expectjob";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expectjob merge(Expectjob detachedInstance) {
		log.debug("merging Expectjob instance");
		try {
			Expectjob result = (Expectjob) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expectjob instance) {
		log.debug("attaching dirty Expectjob instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expectjob instance) {
		log.debug("attaching clean Expectjob instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpectjobDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExpectjobDAO) ctx.getBean("ExpectjobDAO");
	}
}