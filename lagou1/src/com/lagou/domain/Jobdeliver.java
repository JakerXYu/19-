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
 * Jobdeliver entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobdeliver", catalog = "lagou")
public class Jobdeliver implements java.io.Serializable {

	// Fields

	private Integer deliverId;
	private Resumeinfo resumeinfo;
	private Jobinfo jobinfo;
	private Resumestatus resumestatus;
	private Auditioninfo auditioninfo;

	// Constructors

	/** default constructor */
	public Jobdeliver() {
	}

	/** full constructor */
	public Jobdeliver(Resumeinfo resumeinfo, Jobinfo jobinfo,
			Resumestatus resumestatus, Auditioninfo auditioninfo) {
		this.resumeinfo = resumeinfo;
		this.jobinfo = jobinfo;
		this.resumestatus = resumestatus;
		this.auditioninfo = auditioninfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "deliver_id", unique = true, nullable = false)
	public Integer getDeliverId() {
		return this.deliverId;
	}

	public void setDeliverId(Integer deliverId) {
		this.deliverId = deliverId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliver_resume")
	public Resumeinfo getResumeinfo() {
		return this.resumeinfo;
	}

	public void setResumeinfo(Resumeinfo resumeinfo) {
		this.resumeinfo = resumeinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliver_job")
	public Jobinfo getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliver_status")
	public Resumestatus getResumestatus() {
		return this.resumestatus;
	}

	public void setResumestatus(Resumestatus resumestatus) {
		this.resumestatus = resumestatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliver_audition")
	public Auditioninfo getAuditioninfo() {
		return this.auditioninfo;
	}

	public void setAuditioninfo(Auditioninfo auditioninfo) {
		this.auditioninfo = auditioninfo;
	}

}