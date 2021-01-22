package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TXinwen;

/**
 * A data access object (DAO) providing persistence and search support for
 * TXinwen entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TXinwen
 * @author MyEclipse Persistence Tools
 */

public class TXinwenDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TXinwenDAO.class);
	// property constants
	public static final String SHETUAN_ID = "shetuanId";
	public static final String BIAOTI = "biaoti";
	public static final String NEIRONG = "neirong";
	public static final String SHIJIAN = "shijian";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TXinwen transientInstance)
	{
		log.debug("saving TXinwen instance");
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

	public void delete(TXinwen persistentInstance)
	{
		log.debug("deleting TXinwen instance");
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

	public TXinwen findById(java.lang.Integer id)
	{
		log.debug("getting TXinwen instance with id: " + id);
		try
		{
			TXinwen instance = (TXinwen) getHibernateTemplate().get(
					"com.model.TXinwen", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TXinwen instance)
	{
		log.debug("finding TXinwen instance by example");
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
		log.debug("finding TXinwen instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TXinwen as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShetuanId(Object shetuanId)
	{
		return findByProperty(SHETUAN_ID, shetuanId);
	}

	public List findByBiaoti(Object biaoti)
	{
		return findByProperty(BIAOTI, biaoti);
	}

	public List findByNeirong(Object neirong)
	{
		return findByProperty(NEIRONG, neirong);
	}

	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}

	public List findAll()
	{
		log.debug("finding all TXinwen instances");
		try
		{
			String queryString = "from TXinwen";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TXinwen merge(TXinwen detachedInstance)
	{
		log.debug("merging TXinwen instance");
		try
		{
			TXinwen result = (TXinwen) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TXinwen instance)
	{
		log.debug("attaching dirty TXinwen instance");
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

	public void attachClean(TXinwen instance)
	{
		log.debug("attaching clean TXinwen instance");
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

	public static TXinwenDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TXinwenDAO) ctx.getBean("TXinwenDAO");
	}
}