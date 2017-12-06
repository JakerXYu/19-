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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OrderBy;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userinfo", catalog = "lagou")
@DynamicUpdate
public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userinfoId;
	private String userinfoPassword;
	private String userinfoUsername;
	private String userinfoEmail;
	private String userinfoSex;
	private Integer userinfoEdu;
	private Integer userinfoExp;
	private String userinfoImg;
	private Integer userinfoExptime;
	private String userinfoPhone;
	private Set<Subscribe> subscribes = new HashSet<Subscribe>(0);
	private Set<Resumeinfo> resumeinfos = new HashSet<Resumeinfo>(0);
	private Set<Reportjob> reportjobs = new HashSet<Reportjob>(0);
	private Set<Email> emails = new HashSet<Email>(0);
	private Set<Auditionjudge> auditionjudges = new HashSet<Auditionjudge>(0);
	private Set<Jobinfo> jobinfos = new HashSet<Jobinfo>(0);
	private Set<Message> messages = new HashSet<Message>(0);
	private Set<Companyinfo> companyinfos = new HashSet<Companyinfo>(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** full constructor */
	public Userinfo(String userinfoPassword, String userinfoUsername,
			String userinfoEmail, String userinfoSex, Integer userinfoEdu,
			Integer userinfoExp, String userinfoImg, Integer userinfoExptime,
			String userinfoPhone, Set<Subscribe> subscribes,
			Set<Resumeinfo> resumeinfos, Set<Reportjob> reportjobs,
			Set<Email> emails, Set<Auditionjudge> auditionjudges,
			Set<Jobinfo> jobinfos, Set<Message> messages,
			Set<Companyinfo> companyinfos) {
		this.userinfoPassword = userinfoPassword;
		this.userinfoUsername = userinfoUsername;
		this.userinfoEmail = userinfoEmail;
		this.userinfoSex = userinfoSex;
		this.userinfoEdu = userinfoEdu;
		this.userinfoExp = userinfoExp;
		this.userinfoImg = userinfoImg;
		this.userinfoExptime = userinfoExptime;
		this.userinfoPhone = userinfoPhone;
		this.subscribes = subscribes;
		this.resumeinfos = resumeinfos;
		this.reportjobs = reportjobs;
		this.emails = emails;
		this.auditionjudges = auditionjudges;
		this.jobinfos = jobinfos;
		this.messages = messages;
		this.companyinfos = companyinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userinfo_id", unique = true, nullable = false)
	public Integer getUserinfoId() {
		return this.userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	@Column(name = "userinfo_password", length = 32)
	public String getUserinfoPassword() {
		return this.userinfoPassword;
	}

	public void setUserinfoPassword(String userinfoPassword) {
		this.userinfoPassword = userinfoPassword;
	}

	@Column(name = "userinfo_username", length = 20)
	public String getUserinfoUsername() {
		return this.userinfoUsername;
	}

	public void setUserinfoUsername(String userinfoUsername) {
		this.userinfoUsername = userinfoUsername;
	}

	@Column(name = "userinfo_email")
	public String getUserinfoEmail() {
		return this.userinfoEmail;
	}

	public void setUserinfoEmail(String userinfoEmail) {
		this.userinfoEmail = userinfoEmail;
	}

	@Column(name = "userinfo_sex")
	public String getUserinfoSex() {
		return this.userinfoSex;
	}

	public void setUserinfoSex(String userinfoSex) {
		this.userinfoSex = userinfoSex;
	}

	@Column(name = "userinfo_edu")
	public Integer getUserinfoEdu() {
		return this.userinfoEdu;
	}

	public void setUserinfoEdu(Integer userinfoEdu) {
		this.userinfoEdu = userinfoEdu;
	}

	@Column(name = "userinfo_exp")
	public Integer getUserinfoExp() {
		return this.userinfoExp;
	}

	public void setUserinfoExp(Integer userinfoExp) {
		this.userinfoExp = userinfoExp;
	}

	@Column(name = "userinfo_img")
	public String getUserinfoImg() {
		return this.userinfoImg;
	}

	public void setUserinfoImg(String userinfoImg) {
		this.userinfoImg = userinfoImg;
	}

	@Column(name = "userinfo_exptime")
	public Integer getUserinfoExptime() {
		return this.userinfoExptime;
	}

	public void setUserinfoExptime(Integer userinfoExptime) {
		this.userinfoExptime = userinfoExptime;
	}

	@Column(name = "userinfo_phone")
	public String getUserinfoPhone() {
		return this.userinfoPhone;
	}

	public void setUserinfoPhone(String userinfoPhone) {
		this.userinfoPhone = userinfoPhone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(Set<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Resumeinfo> getResumeinfos() {
		return this.resumeinfos;
	}

	public void setResumeinfos(Set<Resumeinfo> resumeinfos) {
		this.resumeinfos = resumeinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Reportjob> getReportjobs() {
		return this.reportjobs;
	}

	public void setReportjobs(Set<Reportjob> reportjobs) {
		this.reportjobs = reportjobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Auditionjudge> getAuditionjudges() {
		return this.auditionjudges;
	}

	public void setAuditionjudges(Set<Auditionjudge> auditionjudges) {
		this.auditionjudges = auditionjudges;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "jobcollection", catalog = "lagou", joinColumns = { @JoinColumn(name = "collection_user", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "collection_job", updatable = false) })
	public Set<Jobinfo> getJobinfos() {
		return this.jobinfos;
	}

	public void setJobinfos(Set<Jobinfo> jobinfos) {
		this.jobinfos = jobinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "companycollection", catalog = "lagou", joinColumns = { @JoinColumn(name = "collection_user", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "collection_company", updatable = false) })
	public Set<Companyinfo> getCompanyinfos() {
		return this.companyinfos;
	}

	public void setCompanyinfos(Set<Companyinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

}