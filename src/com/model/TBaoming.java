package com.model;

/**
 * TBaoming entity. @author MyEclipse Persistence Tools
 */

public class TBaoming implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer huodongId;
	private Integer sheyuanId;
	private String lianxifangshi;
	
	private String beizhu;
	private String baomingshi;

	// Constructors

	/** default constructor */
	public TBaoming()
	{
	}

	/** full constructor */
	public TBaoming(Integer huodongId, Integer sheyuanId, String lianxifangshi,
			String beizhu, String baomingshi)
	{
		this.huodongId = huodongId;
		this.sheyuanId = sheyuanId;
		this.lianxifangshi = lianxifangshi;
		this.beizhu = beizhu;
		this.baomingshi = baomingshi;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getHuodongId()
	{
		return this.huodongId;
	}

	public void setHuodongId(Integer huodongId)
	{
		this.huodongId = huodongId;
	}

	public Integer getSheyuanId()
	{
		return this.sheyuanId;
	}

	public void setSheyuanId(Integer sheyuanId)
	{
		this.sheyuanId = sheyuanId;
	}

	public String getLianxifangshi()
	{
		return this.lianxifangshi;
	}

	public void setLianxifangshi(String lianxifangshi)
	{
		this.lianxifangshi = lianxifangshi;
	}

	public String getBeizhu()
	{
		return this.beizhu;
	}

	public void setBeizhu(String beizhu)
	{
		this.beizhu = beizhu;
	}

	public String getBaomingshi()
	{
		return this.baomingshi;
	}

	public void setBaomingshi(String baomingshi)
	{
		this.baomingshi = baomingshi;
	}

}