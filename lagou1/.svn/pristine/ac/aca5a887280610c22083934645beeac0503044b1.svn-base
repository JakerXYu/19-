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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Expectjob entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "expectjob", catalog = "lagou")
public class Expectjob implements java.io.Serializable {

	// Fields

	private Integer expectJobId;
	private Jobprop jobprop;
	private Cityinfo cityinfo;
	private Sal sal;
	private String expectJobDept;
	private Set<Resumeinfo> resumeinfos = new HashSet<Resumeinfo>(0);

	// Constructors

	/** default constructor */
	public Expectjob() {
	}

	/** full constructor */
	public Expectjob(Jobprop jobprop, Cityinfo cityinfo, Sal sal,
			String expectJobDept, Set<Resumeinfo> resumeinfos) {
		this.jobprop = jobprop;
		this.cityinfo = cityinfo;
		this.sal = sal;
		this.expectJobDept = expectJobDept;
		this.resumeinfos = resumeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "expect_job_id", unique = true, nullable = false)
	public Integer getExpectJobId() {
		return this.expectJobId;
	}

	public void setExpectJobId(Integer expectJobId) {
		this.expectJobId = expectJobId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expect_job_prop")
	public Jobprop getJobprop() {
		return this.jobprop;
	}

	public void setJobprop(Jobprop jobprop) {
		this.jobprop = jobprop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expect_job_city")
	public Cityinfo getCityinfo() {
		return this.cityinfo;
	}

	public void setCityinfo(Cityinfo cityinfo) {
		this.cityinfo = cityinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expect_job_sal")
	public Sal getSal() {
		return this.sal;
	}

	public void setSal(Sal sal) {
		this.sal = sal;
	}

	@Column(name = "expect_job_dept")
	public String getExpectJobDept() {
		return this.expectJobDept;
	}

	public void setExpectJobDept(String expectJobDept) {
		this.expectJobDept = expectJobDept;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "expectjob")
	public Set<Resumeinfo> getResumeinfos() {
		return this.resumeinfos;
	}

	public void setResumeinfos(Set<Resumeinfo> resumeinfos) {
		this.resumeinfos = resumeinfos;
	}

}