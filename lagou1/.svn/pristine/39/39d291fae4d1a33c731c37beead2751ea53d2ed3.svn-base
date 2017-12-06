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

import com.lagou.domain.Expectjob;
import com.lagou.domain.Useritem;

/**
 * A data access object (DAO) providing persistence and search support for
 * Useritem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.lagou.domain.Useritem
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UseritemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UseritemDAO.class);
	// property constants
	public static final String ITEM_NAME = "itemName";
	public static final String ITEM_DUTY = "itemDuty";
	public static final String ITEM_BEGTIME = "itemBegtime";

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
	 * 更新简历信息——项目经验
	 * @param 
	 */
	public void update(Useritem useritem){
		log.debug("update Resumeinfo instance");
		try {
			getCurrentSession().update(useritem);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public void save(Useritem transientInstance) {
		log.debug("saving Useritem instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Useritem persistentInstance) {
		log.debug("deleting Useritem instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Useritem findById(java.lang.Integer id) {
		log.debug("getting Useritem instance with id: " + id);
		try {
			Useritem instance = (Useritem) getCurrentSession().get(
					"com.lagou.domain.Useritem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Useritem> findByExample(Useritem instance) {
		log.debug("finding Useritem instance by example");
		try {
			List<Useritem> results = (List<Useritem>) getCurrentSession()
					.createCriteria("com.lagou.domain.Useritem")
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
		log.debug("finding Useritem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Useritem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Useritem> findByItemName(Object itemName) {
		return findByProperty(ITEM_NAME, itemName);
	}

	public List<Useritem> findByItemDuty(Object itemDuty) {
		return findByProperty(ITEM_DUTY, itemDuty);
	}

	public List<Useritem> findByItemBegtime(Object itemBegtime) {
		return findByProperty(ITEM_BEGTIME, itemBegtime);
	}

	public List findAll() {
		log.debug("finding all Useritem instances");
		try {
			String queryString = "from Useritem";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Useritem merge(Useritem detachedInstance) {
		log.debug("merging Useritem instance");
		try {
			Useritem result = (Useritem) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Useritem instance) {
		log.debug("attaching dirty Useritem instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Useritem instance) {
		log.debug("attaching clean Useritem instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UseritemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UseritemDAO) ctx.getBean("UseritemDAO");
	}
}