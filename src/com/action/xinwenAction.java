package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TShetuanDAO;
import com.dao.TXinwenDAO;
import com.model.TShetuan;
import com.model.TXinwen;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class xinwenAction extends ActionSupport
{
	private Integer id;
	private Integer shetuanId;
	private String biaoti;
	private String neirong;
	private String shijian;
	
	private TXinwenDAO xinwenDAO;
	private TShetuanDAO shetuanDAO;
	
	
	
	public String xinwenAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		TXinwen xinwen=new TXinwen();
		
		//xinwen.setId(id);
		xinwen.setShetuanId(shetuan.getId());
		xinwen.setBiaoti(biaoti);
		xinwen.setNeirong(neirong);
		
		xinwen.setShijian(shijian);
		
		xinwenDAO.save(xinwen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String xinwenMana()
	{
		Map session=ActionContext.getContext().getSession();
		TShetuan shetuan=(TShetuan)session.get("shetuan");
		
		String sql = "from TXinwen where shetuanId="+shetuan.getId();
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
	
	
	
	public String xinwenDel()
	{
		TXinwen xinwen=xinwenDAO.findById(id);
		xinwenDAO.delete(xinwen);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	public String xinwenAll()
	{
		String sql = "from TXinwen order by shijian desc";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwenList", xinwenList);
		return ActionSupport.SUCCESS;
	}	
	
	
	public String xinwenDetailQian()
	{
		TXinwen xinwen=xinwenDAO.findById(id);
		xinwen.setShetuan(shetuanDAO.findById(xinwen.getShetuanId()));
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("xinwen", xinwen);
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

	public String getBiaoti()
	{
		return biaoti;
	}

	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public TXinwenDAO getXinwenDAO()
	{
		return xinwenDAO;
	}

	public void setXinwenDAO(TXinwenDAO xinwenDAO)
	{
		this.xinwenDAO = xinwenDAO;
	}

	public TShetuanDAO getShetuanDAO()
	{
		return shetuanDAO;
	}

	public void setShetuanDAO(TShetuanDAO shetuanDAO)
	{
		this.shetuanDAO = shetuanDAO;
	}

}
