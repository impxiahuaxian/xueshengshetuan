package com.model;

/**
 * TXinwen entity. @author MyEclipse Persistence Tools
 */

public class TXinwen implements java.io.Serializable
{

	// Fields

	private Integer id;
	private Integer shetuanId;
	private String biaoti;
	private String neirong;
	
	private String shijian;
	
	private TShetuan shetuan;

	// Constructors

	/** default constructor */
	public TXinwen()
	{
	}

	/** full constructor */
	public TXinwen(Integer shetuanId, String biaoti, String neirong,
			String shijian)
	{
		this.shetuanId = shetuanId;
		this.biaoti = biaoti;
		this.neirong = neirong;
		this.shijian = shijian;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public TShetuan getShetuan()
	{
		return shetuan;
	}

	public void setShetuan(TShetuan shetuan)
	{
		this.shetuan = shetuan;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getShetuanId()
	{
		return this.shetuanId;
	}

	public void setShetuanId(Integer shetuanId)
	{
		this.shetuanId = shetuanId;
	}

	public String getBiaoti()
	{
		return this.biaoti;
	}

	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}

	public String getNeirong()
	{
		return this.neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public String getShijian()
	{
		return this.shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

}