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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Useredu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useredu", catalog = "lagou")
public class Useredu implements java.io.Serializable {

	// Fields

	private Integer eduId;
	private Jobedu jobedu;
	private String eduSchool;
	private String eduDep;
	private Timestamp eduBegintime;
	private Timestamp eduEndtime;
	private Set<Resumeinfo> resumeinfos = new HashSet<Resumeinfo>(0);

	// Constructors

	/** default constructor */
	public Useredu() {
	}

	/** full constructor */
	public Useredu(Jobedu jobedu, String eduSchool, String eduDep,
			Timestamp eduBegintime, Timestamp eduEndtime,
			Set<Resumeinfo> resumeinfos) {
		this.jobedu = jobedu;
		this.eduSchool = eduSchool;
		this.eduDep = eduDep;
		this.eduBegintime = eduBegintime;
		this.eduEndtime = eduEndtime;
		this.resumeinfos = resumeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "edu_id", unique = true, nullable = false)
	public Integer getEduId() {
		return this.eduId;
	}

	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "edu_lev")
	public Jobedu getJobedu() {
		return this.jobedu;
	}

	public void setJobedu(Jobedu jobedu) {
		this.jobedu = jobedu;
	}

	@Column(name = "edu_school")
	public String getEduSchool() {
		return this.eduSchool;
	}

	public void setEduSchool(String eduSchool) {
		this.eduSchool = eduSchool;
	}

	@Column(name = "edu_dep")
	public String getEduDep() {
		return this.eduDep;
	}

	public void setEduDep(String eduDep) {
		this.eduDep = eduDep;
	}

	@Column(name = "edu_begintime", length = 19)
	public Timestamp getEduBegintime() {
		return this.eduBegintime;
	}

	public void setEduBegintime(Timestamp eduBegintime) {
		this.eduBegintime = eduBegintime;
	}

	@Column(name = "edu_endtime", length = 19)
	public Timestamp getEduEndtime() {
		return this.eduEndtime;
	}

	public void setEduEndtime(Timestamp eduEndtime) {
		this.eduEndtime = eduEndtime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "useredu")
	public Set<Resumeinfo> getResumeinfos() {
		return this.resumeinfos;
	}

	public void setResumeinfos(Set<Resumeinfo> resumeinfos) {
		this.resumeinfos = resumeinfos;
	}

}