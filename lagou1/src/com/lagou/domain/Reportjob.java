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
 * Reportjob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reportjob", catalog = "lagou")
public class Reportjob implements java.io.Serializable {

	// Fields

	private Integer reportId;
	private Userinfo userinfo;
	private Jobinfo jobinfo;

	// Constructors

	/** default constructor */
	public Reportjob() {
	}

	/** full constructor */
	public Reportjob(Userinfo userinfo, Jobinfo jobinfo) {
		this.userinfo = userinfo;
		this.jobinfo = jobinfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "report_id", unique = true, nullable = false)
	public Integer getReportId() {
		return this.reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_user")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_job")
	public Jobinfo getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}

}