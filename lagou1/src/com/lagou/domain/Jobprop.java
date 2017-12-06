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
 * Jobprop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobprop", catalog = "lagou")
public class Jobprop implements java.io.Serializable {

	// Fields

	private Integer propId;
	private String propName;
	private Set<Jobinfo> jobinfos = new HashSet<Jobinfo>(0);
	private Set<Expectjob> expectjobs = new HashSet<Expectjob>(0);

	// Constructors

	/** default constructor */
	public Jobprop() {
	}

	/** full constructor */
	public Jobprop(String propName, Set<Jobinfo> jobinfos,
			Set<Expectjob> expectjobs) {
		this.propName = propName;
		this.jobinfos = jobinfos;
		this.expectjobs = expectjobs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prop_id", unique = true, nullable = false)
	public Integer getPropId() {
		return this.propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	@Column(name = "prop_name")
	public String getPropName() {
		return this.propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobprop")
	public Set<Jobinfo> getJobinfos() {
		return this.jobinfos;
	}

	public void setJobinfos(Set<Jobinfo> jobinfos) {
		this.jobinfos = jobinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobprop")
	public Set<Expectjob> getExpectjobs() {
		return this.expectjobs;
	}

	public void setExpectjobs(Set<Expectjob> expectjobs) {
		this.expectjobs = expectjobs;
	}

}