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
 * Jobexp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobexp", catalog = "lagou")
public class Jobexp implements java.io.Serializable {

	// Fields

	private Integer expId;
	private String expName;
	private Set<Jobinfo> jobinfos = new HashSet<Jobinfo>(0);

	// Constructors

	/** default constructor */
	public Jobexp() {
	}

	/** full constructor */
	public Jobexp(String expName, Set<Jobinfo> jobinfos) {
		this.expName = expName;
		this.jobinfos = jobinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "exp_id", unique = true, nullable = false)
	public Integer getExpId() {
		return this.expId;
	}

	public void setExpId(Integer expId) {
		this.expId = expId;
	}

	@Column(name = "exp_name")
	public String getExpName() {
		return this.expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobexp")
	public Set<Jobinfo> getJobinfos() {
		return this.jobinfos;
	}

	public void setJobinfos(Set<Jobinfo> jobinfos) {
		this.jobinfos = jobinfos;
	}

}