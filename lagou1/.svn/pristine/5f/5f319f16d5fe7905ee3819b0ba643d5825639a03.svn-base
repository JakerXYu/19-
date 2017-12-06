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
 * Resumestatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resumestatus", catalog = "lagou")
public class Resumestatus implements java.io.Serializable {

	// Fields

	private Integer statusId;
	private String statusName;
	private Set<Jobdeliver> jobdelivers = new HashSet<Jobdeliver>(0);

	// Constructors

	/** default constructor */
	public Resumestatus() {
	}

	/** full constructor */
	public Resumestatus(String statusName, Set<Jobdeliver> jobdelivers) {
		this.statusName = statusName;
		this.jobdelivers = jobdelivers;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resumestatus")
	public Set<Jobdeliver> getJobdelivers() {
		return this.jobdelivers;
	}

	public void setJobdelivers(Set<Jobdeliver> jobdelivers) {
		this.jobdelivers = jobdelivers;
	}

}