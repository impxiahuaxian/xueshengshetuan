package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBaoming;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBaoming entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TBaoming
 * @author MyEclipse Persistence Tools
 */

public class TBaomingDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TBaomingDAO.class);
	// property constants
	public static final String HUODONG_ID = "huodongId";
	public static final String SHEYUAN_ID = "sheyuanId";
	public static final String LIANXIFANGSHI = "lianxifangshi";
	public static final String BEIZHU = "beizhu";
	public static final String BAOMINGSHI = "baomingshi";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TBaoming transientInstance)
	{
		log.debug("saving TBaoming instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBaoming persistentInstance)
	{
		log.debug("deleting TBaoming instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBaoming findById(java.lang.Integer id)
	{
		log.debug("getting TBaoming instance with id: " + id);
		try
		{
			TBaoming instance = (TBaoming) getHibernateTemplate().get(
					"com.model.TBaoming", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBaoming instance)
	{
		log.debug("finding TBaoming instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TBaoming instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TBaoming as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHuodongId(Object huodongId)
	{
		return findByProperty(HUODONG_ID, huodongId);
	}

	public List findBySheyuanId(Object sheyuanId)
	{
		return findByProperty(SHEYUAN_ID, sheyuanId);
	}

	public List findByLianxifangshi(Object lianxifangshi)
	{
		return findByProperty(LIANXIFANGSHI, lianxifangshi);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByBaomingshi(Object baomingshi)
	{
		return findByProperty(BAOMINGSHI, baomingshi);
	}

	public List findAll()
	{
		log.debug("finding all TBaoming instances");
		try
		{
			String queryString = "from TBaoming";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBaoming merge(TBaoming detachedInstance)
	{
		log.debug("merging TBaoming instance");
		try
		{
			TBaoming result = (TBaoming) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBaoming instance)
	{
		log.debug("attaching dirty TBaoming instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBaoming instance)
	{
		log.debug("attaching clean TBaoming instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TBaomingDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TBaomingDAO) ctx.getBean("TBaomingDAO");
	}
}