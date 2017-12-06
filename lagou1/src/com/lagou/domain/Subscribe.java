package com.lagou.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Subscribe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "subscribe", catalog = "lagou")
public class Subscribe implements java.io.Serializable {

	// Fields

	private Integer subId;
	private Jobtype jobtype;
	private Sal sal;
	private Companystage companystage;
	private Companyfield companyfield;
	private Userinfo userinfo;
	private Cityinfo cityinfo;
	private Integer subWeekday;

	// Constructors

	/** default constructor */
	public Subscribe() {
	}

	/** full constructor */
	public Subscribe(Jobtype jobtype, Sal sal, Companystage companystage,
			Companyfield companyfield, Userinfo userinfo, Cityinfo cityinfo,
			Integer subWeekday) {
		this.jobtype = jobtype;
		this.sal = sal;
		this.companystage = companystage;
		this.companyfield = companyfield;
		this.userinfo = userinfo;
		this.cityinfo = cityinfo;
		this.subWeekday = subWeekday;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sub_id", unique = true, nullable = false)
	public Integer getSubId() {
		return this.subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_job_name")
	public Jobtype getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_sal")
	public Sal getSal() {
		return this.sal;
	}

	public void setSal(Sal sal) {
		this.sal = sal;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_stage")
	public Companystage getCompanystage() {
		return this.companystage;
	}

	public void setCompanystage(Companystage companystage) {
		this.companystage = companystage;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_field")
	public Companyfield getCompanyfield() {
		return this.companyfield;
	}

	public void setCompanyfield(Companyfield companyfield) {
		this.companyfield = companyfield;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_userid")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sub_city")
	public Cityinfo getCityinfo() {
		return this.cityinfo;
	}

	public void setCityinfo(Cityinfo cityinfo) {
		this.cityinfo = cityinfo;
	}

	@Column(name = "sub_weekday")
	public Integer getSubWeekday() {
		return this.subWeekday;
	}

	public void setSubWeekday(Integer subWeekday) {
		this.subWeekday = subWeekday;
	}

}