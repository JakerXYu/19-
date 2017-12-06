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
 * Resumeinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "resumeinfo", catalog = "lagou")
public class Resumeinfo implements java.io.Serializable {

	// Fields

	private Integer resumeId;
	private Userinfo userinfo;
	private Useritem useritem;
	private Useredu useredu;
	private Expectjob expectjob;
	private Userworkexp userworkexp;
	private String resumeDesc;
	private Set<Jobdeliver> jobdelivers = new HashSet<Jobdeliver>(0);

	// Constructors

	/** default constructor */
	public Resumeinfo() {
	}

	/** full constructor */
	public Resumeinfo(Userinfo userinfo, Useritem useritem, Useredu useredu,
			Expectjob expectjob, Userworkexp userworkexp, String resumeDesc,
			Set<Jobdeliver> jobdelivers) {
		this.userinfo = userinfo;
		this.useritem = useritem;
		this.useredu = useredu;
		this.expectjob = expectjob;
		this.userworkexp = userworkexp;
		this.resumeDesc = resumeDesc;
		this.jobdelivers = jobdelivers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "resume_id", unique = true, nullable = false)
	public Integer getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_user")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_item")
	public Useritem getUseritem() {
		return this.useritem;
	}

	public void setUseritem(Useritem useritem) {
		this.useritem = useritem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_edu")
	public Useredu getUseredu() {
		return this.useredu;
	}

	public void setUseredu(Useredu useredu) {
		this.useredu = useredu;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_job")
	public Expectjob getExpectjob() {
		return this.expectjob;
	}

	public void setExpectjob(Expectjob expectjob) {
		this.expectjob = expectjob;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_exp")
	public Userworkexp getUserworkexp() {
		return this.userworkexp;
	}

	public void setUserworkexp(Userworkexp userworkexp) {
		this.userworkexp = userworkexp;
	}

	@Column(name = "resume_desc")
	public String getResumeDesc() {
		return this.resumeDesc;
	}

	public void setResumeDesc(String resumeDesc) {
		this.resumeDesc = resumeDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "resumeinfo")
	public Set<Jobdeliver> getJobdelivers() {
		return this.jobdelivers;
	}

	public void setJobdelivers(Set<Jobdeliver> jobdelivers) {
		this.jobdelivers = jobdelivers;
	}

}