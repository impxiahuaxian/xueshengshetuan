package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShetuanDAO;
import com.dao.TSheyuanDAO;
import com.model.TShetuan;
import com.model.TSheyuan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class sheyuanAction extends ActionSupport
{
	private Integer id;
	private Integer shetuanId;
	private String xuehao;
	private String xingming;
	
	private String xingbie;
	private String nianling;
	private String banji;
	private String loginpw;
	
	private String del;
	
	private String message;
	private String path;
	
	private TSheyuanDAO sheyuanDAO;
	
	
	
	public String sheyuanAdd()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		List list=sheyuanDAO.findByProperty("xuehao", xuehao.trim());
		if(list.size()>0)
		{
			request.put("msg", "学号重复，请重新输入");
		}
		else
		{
			TSheyuan sheyuan=new TSheyuan();
			
			//sheyuan.setId(id);
			sheyuan.setShetuanId(shetuan.getId());
			sheyuan.setXuehao(xuehao);
			sheyuan.setXingming(xingming);
			
			sheyuan.setXingbie(xingbie);
			sheyuan.setNianling(nianling);
			sheyuan.setBanji(banji);
			sheyuan.setLoginpw(loginpw);
			
			sheyuan.setDel("no");
			
			sheyuanDAO.save(sheyuan);
			
			
			request.put("msg", "信息添加完毕");
		}
		
		return "msg";
	}
	
	public String sheyuanMana()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		String sql = "from TSheyuan where del='no' and shetuanId="+shetuan.getId();
		List sheyuanList=sheyuanDAO.getHibernateTemplate().find(sql);
		
		request.put("sheyuanList", sheyuanList);
		return ActionSupport.SUCCESS;
	}	
	
	public String sheyuanDel()
	{
		TSheyuan sheyuan=sheyuanDAO.findById(id);
		sheyuan.setDel("yes");
		sheyuanDAO.attachDirty(sheyuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "退社完毕");
		return "msg";
	}
	
	
	public String sheyuanDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql = "from TSheyuan where id="+id;
		List sheyuanList=sheyuanDAO.getHibernateTemplate().find(sql);
		
		request.put("sheyuanList", sheyuanList);
		return ActionSupport.SUCCESS;
	}	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getShetuanId()
	{
		return shetuanId;
	}

	public void setShetuanId(Integer shetuanId)
	{
		this.shetuanId = shetuanId;
	}

	public String getXuehao()
	{
		return xuehao;
	}

	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}

	public String getXingming()
	{
		return xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXingbie()
	{
		return xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public String getNianling()
	{
		return nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getBanji()
	{
		return banji;
	}

	public void setBanji(String banji)
	{
		this.banji = banji;
	}

	public String getLoginpw()
	{
		return loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public TSheyuanDAO getSheyuanDAO()
	{
		return sheyuanDAO;
	}

	public void setSheyuanDAO(TSheyuanDAO sheyuanDAO)
	{
		this.sheyuanDAO = sheyuanDAO;
	}
	
}
