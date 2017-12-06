package com.lagou.domain;

import java.sql.Timestamp;
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
 * Userworkexp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userworkexp", catalog = "lagou")
public class Userworkexp implements java.io.Serializable {

	// Fields

	private Integer workexpId;
	private String workexpName;
	private String workexpJob;
	private Timestamp workexpBegintime;
	private Timestamp workexpEndtime;
	private Set<Resumeinfo> resumeinfos = new HashSet<Resumeinfo>(0);

	// Constructors

	/** default constructor */
	public Userworkexp() {
	}

	/** full constructor */
	public Userworkexp(String workexpName, String workexpJob,
			Timestamp workexpBegintime, Timestamp workexpEndtime,
			Set<Resumeinfo> resumeinfos) {
		this.workexpName = workexpName;
		this.workexpJob = workexpJob;
		this.workexpBegintime = workexpBegintime;
		this.workexpEndtime = workexpEndtime;
		this.resumeinfos = resumeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "workexp_id", unique = true, nullable = false)
	public Integer getWorkexpId() {
		return this.workexpId;
	}

	public void setWorkexpId(Integer workexpId) {
		this.workexpId = workexpId;
	}

	@Column(name = "workexp_name")
	public String getWorkexpName() {
		return this.workexpName;
	}

	public void setWorkexpName(String workexpName) {
		this.workexpName = workexpName;
	}

	@Column(name = "workexp_job")
	public String getWorkexpJob() {
		return this.workexpJob;
	}

	public void setWorkexpJob(String workexpJob) {
		this.workexpJob = workexpJob;
	}

	@Column(name = "workexp_begintime", length = 19)
	public Timestamp getWorkexpBegintime() {
		return this.workexpBegintime;
	}

	public void setWorkexpBegintime(Timestamp workexpBegintime) {
		this.workexpBegintime = workexpBegintime;
	}

	@Column(name = "workexp_endtime", length = 19)
	public Timestamp getWorkexpEndtime() {
		return this.workexpEndtime;
	}

	public void setWorkexpEndtime(Timestamp workexpEndtime) {
		this.workexpEndtime = workexpEndtime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userworkexp")
	public Set<Resumeinfo> getResumeinfos() {
		return this.resumeinfos;
	}

	public void setResumeinfos(Set<Resumeinfo> resumeinfos) {
		this.resumeinfos = resumeinfos;
	}

}