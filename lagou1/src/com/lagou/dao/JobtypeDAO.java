package com.lagou.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Jobtype;

/**
 * A data access object (DAO) providing persistence and search support for
 * Jobtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Jobtype
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class JobtypeDAO {
	private static final Logger log = LoggerFactory.getLogger(JobtypeDAO.class);
	// property constants
	public static final String TYPE_NAME = "typeName";
	public static final String TYPE_LV = "typeLv";
	public static final String TYPE_PATH = "typePath";

	private SessionFactory sessionFactory;
	
	public List<Jobtype> findByTypePath(int typePath) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Jobtype.class);
		Criterion criterion = Restrictions.like("typePath", "|"+typePath+"|",MatchMode.ANYWHERE);
		criteria.add(criterion);
		List<Jobtype> jobtypelist = criteria.list();
		return jobtypelist;
	}
	
	public List<Jobtype> findByTypeLv(int typeLv) {
		return findByProperty(TYPE_LV, typeLv);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Jobtype transientInstance) {
		log.debug("saving Jobtype instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Jobtype persistentInstance) {
		log.debug("deleting Jobtype instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Jobtype findById(java.lang.Integer id) {
		log.debug("getting Jobtype instance with id: " + id);
		try {
			Jobtype instance = (Jobtype) getCurrentSession().get(
					"com.lagou.domain.Jobtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobtype> findByExample(Jobtype instance) {
		log.debug("finding Jobtype instance by example");
		try {
			List<Jobtype> results = (List<Jobtype>) getCurrentSession()
					.createCriteria("com.lagou.domain.Jobtype")
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
		log.debug("finding Jobtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Jobtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Jobtype> findByTypeName(Object typeName) {
		return findByProperty(TYPE_NAME, typeName);
	}



	

	public List findAll() {
		log.debug("finding all Jobtype instances");
		try {
			String queryString = "from Jobtype";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Jobtype merge(Jobtype detachedInstance) {
		log.debug("merging Jobtype instance");
		try {
			Jobtype result = (Jobtype) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Jobtype instance) {
		log.debug("attaching dirty Jobtype instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Jobtype instance) {
		log.debug("attaching clean Jobtype instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static JobtypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (JobtypeDAO) ctx.getBean("JobtypeDAO");
	}
}