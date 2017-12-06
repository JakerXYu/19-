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
 * Auditionjudge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auditionjudge", catalog = "lagou")
public class Auditionjudge implements java.io.Serializable {

	// Fields

	private Integer auditionId;
	private Jobinfo jobinfo;
	private Userinfo userinfo;
	private String auditionJudge;

	// Constructors

	/** default constructor */
	public Auditionjudge() {
	}

	/** full constructor */
	public Auditionjudge(Jobinfo jobinfo, Userinfo userinfo,
			String auditionJudge) {
		this.jobinfo = jobinfo;
		this.userinfo = userinfo;
		this.auditionJudge = auditionJudge;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "audition_id", unique = true, nullable = false)
	public Integer getAuditionId() {
		return this.auditionId;
	}

	public void setAuditionId(Integer auditionId) {
		this.auditionId = auditionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "audition_job")
	public Jobinfo getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "audition_user")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "audition_judge")
	public String getAuditionJudge() {
		return this.auditionJudge;
	}

	public void setAuditionJudge(String auditionJudge) {
		this.auditionJudge = auditionJudge;
	}

}