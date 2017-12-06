package com.lagou.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jobstatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobstatus", catalog = "lagou")
public class Jobstatus implements java.io.Serializable {

	// Fields

	private Integer statusId;
	private String statusName;
	private Set<Jobinfo> jobinfos = new HashSet<Jobinfo>(0);

	// Constructors

	/** default constructor */
	public Jobstatus() {
	}

	/** full constructor */
	public Jobstatus(String statusName, Set<Jobinfo> jobinfos) {
		this.statusName = statusName;
		this.jobinfos = jobinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "status_id", unique = true, nullable = false)
	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Column(name = "status_name")
	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobstatus")
	public Set<Jobinfo> getJobinfos() {
		return this.jobinfos;
	}

	public void setJobinfos(Set<Jobinfo> jobinfos) {
		this.jobinfos = jobinfos;
	}

}