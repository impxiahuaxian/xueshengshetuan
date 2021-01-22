package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBaomingDAO;
import com.model.TBaoming;
import com.model.TShetuan;
import com.model.TSheyuan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class baomingAction extends ActionSupport
{
	private Integer id;
	private Integer huodongId;
	private Integer sheyuanId;
	private String lianxifangshi;
	
	private String beizhu;
	private String baomingshi;
	
	private TBaomingDAO baomingDAO;
	
	
	
	public String baomingAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TSheyuan sheyuan=(TSheyuan)session.get("sheyuan");
		
		TBaoming baoming=new TBaoming();
		
		//baoming.setId(0);
		baoming.setHuodongId(huodongId);
		baoming.setSheyuanId(sheyuan.getId());
		baoming.setLianxifangshi(lianxifangshi);
		
		baoming.setBeizhu(beizhu);
		baoming.setBaomingshi(baomingshi);
		
		baomingDAO.save(baoming);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "成功报名");
		
		return "msg";
	}
	
	public String baomingMana()
	{
		String sql = "from TBaoming where huodongId="+huodongId;
		System.out.println(sql+"YY");
		List baomingList=baomingDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("baomingList", baomingList);
		return ActionSupport.SUCCESS;
	}	
	
	public String baomingDel()
	{
		TBaoming baoming=baomingDAO.findById(id);
		baomingDAO.delete(baoming);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getHuodongId()
	{
		return huodongId;
	}

	public void setHuodongId(Integer huodongId)
	{
		this.huodongId = huodongId;
	}

	public Integer getSheyuanId()
	{
		return sheyuanId;
	}

	public void setSheyuanId(Integer sheyuanId)
	{
		this.sheyuanId = sheyuanId;
	}

	public String getLianxifangshi()
	{
		return lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi)
	{
		this.lianxifangshi = lianxifangshi;
	}

	public String getBeizhu()
	{
		return beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getBaomingshi()
	{
		return baomingshi;
	}

	public void setBaomingshi(String baomingshi)
	{
		this.baomingshi = baomingshi;
	}

	public TBaomingDAO getBaomingDAO()
	{
		return baomingDAO;
	}

	public void setBaomingDAO(TBaomingDAO baomingDAO)
	{
		this.baomingDAO = baomingDAO;
	}
	
}
