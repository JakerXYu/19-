package com.lagou.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.domain.Companyinfo;
import com.lagou.domain.Userinfo;
import com.lagou.vo.CompanySearchVO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Companyinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.lagou.domain.Companyinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CompanyinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyinfoDAO.class);
	// property constants
	public static final String COMPANY_LOGNAME = "companyLogname";
	public static final String COMPANY_PASSWORD = "companyPassword";
	public static final String COMPANY_NAME = "companyName";
	public static final String COMPANY_LOGO = "companyLogo";
	public static final String COMPANY_INDEX = "companyIndex";
	public static final String COMPANY_ADDRESS = "companyAddress";

	private SessionFactory sessionFactory;
	public void update(Companyinfo transientInstance) {
		log.debug("update Companyinfo instance");
		try {
			getCurrentSession().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
	public List findBySearch(CompanySearchVO searchvo) {
		log.debug("finding all Companyinfo instances");
		try {
			Session session = getCurrentSession();
			Criteria criteria = session.createCriteria(Companyinfo.class);
			criteria.createAlias("companyfield", "field");
			criteria.createAlias("companysize", "size");
			criteria.createAlias("companystage", "stage");
			criteria.createAlias("jobinfos", "job");
			if(searchvo.getAdress()!=null && !"".equals(searchvo.getAdress())){
				Criterion criterion1 = Restrictions.eq("companyAddress", searchvo.getAdress());
				criteria.add(criterion1);
			}
			if(searchvo.getStage()!=null && !"".equals(searchvo.getStage())){
				int stage = Integer.parseInt(searchvo.getStage());
				Criterion criterion2 = Restrictions.eq("stage.stageId",stage );
				criteria.add(criterion2);
			}
			if(searchvo.getField()!=null && !"".equals(searchvo.getField())){
				int field = Integer.parseInt(searchvo.getField());
				Criterion criterion3 = Restrictions.eq("field.fieldId", field);
				criteria.add(criterion3);
			}
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Companyinfo> companyinfolist = criteria.list();
			return companyinfolist;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/**
	 * @author ZH
	 * @param username
	 * @return Companyinfo
	 */

	public Companyinfo findByUserName(Object companyLogname) {
		log.debug("finding Companyinfo instance with property: " + this.COMPANY_LOGNAME
				+ ", value: " + companyLogname);
		try {
			String queryString = "from Companyinfo as model where model."
					+ this.COMPANY_LOGNAME + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, companyLogname);
			System.out.println((Companyinfo) queryObject.uniqueResult());
			return  (Companyinfo) queryObject.uniqueResult();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	public List findAll() {
		log.debug("finding all Companyinfo instances");
		try {
			Session session = getCurrentSession();
			Criteria criteria = session.createCriteria(Companyinfo.class);
			criteria.createAlias("companyfield", "filed");
			criteria.createAlias("companysize", "size");
			criteria.createAlias("companystage", "stage");
			
			criteria.createAlias("jobinfos", "job");
			List<Companyinfo> companyinfolist = criteria.list();
			return companyinfolist;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Companyinfo findByUsername(String username){
		Criteria criteria=getCurrentSession().createCriteria(Companyinfo.class);
		Criterion criterion=Restrictions.eq("companyLogname", username);
		criteria.add(criterion);
		Companyinfo companyinfo;
		try {
			companyinfo = (Companyinfo) criteria.uniqueResult();
			return companyinfo;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
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

	public void save(Companyinfo transientInstance) {
		log.debug("saving Companyinfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companyinfo persistentInstance) {
		log.debug("deleting Companyinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companyinfo findById(java.lang.Integer id) {
		log.debug("getting Companyinfo instance with id: " + id);
		try {
			Companyinfo instance = (Companyinfo) getCurrentSession().get(
					"com.lagou.domain.Companyinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Companyinfo> findByExample(Companyinfo instance) {
		log.debug("finding Companyinfo instance by example");
		try {
			List<Companyinfo> results = (List<Companyinfo>) getCurrentSession()
					.createCriteria("com.lagou.domain.Companyinfo")
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
		log.debug("finding Companyinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Companyinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Companyinfo> findByCompanyLogname(Object companyLogname) {
		return findByProperty(COMPANY_LOGNAME, companyLogname);
	}

	public List<Companyinfo> findByCompanyPassword(Object companyPassword) {
		return findByProperty(COMPANY_PASSWORD, companyPassword);
	}

	public List<Companyinfo> findByCompanyName(Object companyName) {
		return findByProperty(COMPANY_NAME, companyName);
	}

	public List<Companyinfo> findByCompanyLogo(Object companyLogo) {
		return findByProperty(COMPANY_LOGO, companyLogo);
	}

	public List<Companyinfo> findByCompanyIndex(Object companyIndex) {
		return findByProperty(COMPANY_INDEX, companyIndex);
	}

	public List<Companyinfo> findByCompanyAddress(Object companyAddress) {
		return findByProperty(COMPANY_ADDRESS, companyAddress);
	}

	

	public Companyinfo merge(Companyinfo detachedInstance) {
		log.debug("merging Companyinfo instance");
		try {
			Companyinfo result = (Companyinfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companyinfo instance) {
		log.debug("attaching dirty Companyinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			re.printStackTrace();
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companyinfo instance) {
		log.debug("attaching clean Companyinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyinfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyinfoDAO) ctx.getBean("CompanyinfoDAO");
	}
}