package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TSheyuan;

/**
 * A data access object (DAO) providing persistence and search support for
 * TSheyuan entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TSheyuan
 * @author MyEclipse Persistence Tools
 */

public class TSheyuanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TSheyuanDAO.class);
	// property constants
	public static final String XUEHAO = "xuehao";
	public static final String XINGMING = "xingming";
	public static final String XINGBIE = "xingbie";
	public static final String NIANLING = "nianling";
	public static final String BANJI = "banji";
	public static final String LOGINPW = "loginpw";
	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TSheyuan transientInstance)
	{
		log.debug("saving TSheyuan instance");
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

	public void delete(TSheyuan persistentInstance)
	{
		log.debug("deleting TSheyuan instance");
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

	public TSheyuan findById(java.lang.Integer id)
	{
		log.debug("getting TSheyuan instance with id: " + id);
		try
		{
			TSheyuan instance = (TSheyuan) getHibernateTemplate().get(
					"com.model.TSheyuan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TSheyuan instance)
	{
		log.debug("finding TSheyuan instance by example");
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
		log.debug("finding TSheyuan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TSheyuan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXuehao(Object xuehao)
	{
		return findByProperty(XUEHAO, xuehao);
	}

	public List findByXingming(Object xingming)
	{
		return findByProperty(XINGMING, xingming);
	}

	public List findByXingbie(Object xingbie)
	{
		return findByProperty(XINGBIE, xingbie);
	}

	public List findByNianling(Object nianling)
	{
		return findByProperty(NIANLING, nianling);
	}

	public List findByBanji(Object banji)
	{
		return findByProperty(BANJI, banji);
	}

	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TSheyuan instances");
		try
		{
			String queryString = "from TSheyuan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TSheyuan merge(TSheyuan detachedInstance)
	{
		log.debug("merging TSheyuan instance");
		try
		{
			TSheyuan result = (TSheyuan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TSheyuan instance)
	{
		log.debug("attaching dirty TSheyuan instance");
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

	public void attachClean(TSheyuan instance)
	{
		log.debug("attaching clean TSheyuan instance");
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

	public static TSheyuanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TSheyuanDAO) ctx.getBean("TSheyuanDAO");
	}
}