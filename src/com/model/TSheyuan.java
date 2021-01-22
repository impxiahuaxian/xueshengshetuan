package com.model;

/**
 * TSheyuan entity. @author MyEclipse Persistence Tools
 */

public class TSheyuan implements java.io.Serializable
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

	// Constructors

	/** default constructor */
	public TSheyuan()
	{
	}

	/** full constructor */
	public TSheyuan(String xuehao, String xingming, String xingbie,
			String nianling, String banji, String loginpw, String del)
	{
		this.xuehao = xuehao;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.banji = banji;
		this.loginpw = loginpw;
		this.del = del;
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

	public String getXuehao()
	{
		return this.xuehao;
	}

	public void setXuehao(String xuehao)
	{
		this.xuehao = xuehao;
	}

	public String getXingming()
	{
		return this.xingming;
	}

	public void setXingming(String xingming)
	{
		this.xingming = xingming;
	}

	public String getXingbie()
	{
		return this.xingbie;
	}

	public void setXingbie(String xingbie)
	{
		this.xingbie = xingbie;
	}

	public Integer getShetuanId()
	{
		return shetuanId;
	}

	public void setShetuanId(Integer shetuanId)
	{
		this.shetuanId = shetuanId;
	}

	public String getNianling()
	{
		return this.nianling;
	}

	public void setNianling(String nianling)
	{
		this.nianling = nianling;
	}

	public String getBanji()
	{
		return this.banji;
	}

	public void setBanji(String banji)
	{
		this.banji = banji;
	}

	public String getLoginpw()
	{
		return this.loginpw;
	}

	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}

	public String getDel()
	{
		return this.del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

}