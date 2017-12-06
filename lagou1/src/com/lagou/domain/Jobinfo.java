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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * Jobinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobinfo", catalog = "lagou")
@DynamicUpdate@DynamicInsert
public class Jobinfo implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Jobinfo [jobId=" + jobId + ", jobedu=" + jobedu
				+ ", companyinfo=" + companyinfo + ", jobtype=" + jobtype
				+ ", jobstatus=" + jobstatus + ", jobprop=" + jobprop
				+ ", jobexp=" + jobexp + ", jobLowsal=" + jobLowsal
				+ ", jobHighsal=" + jobHighsal + ", jobName=" + jobName
				+ ", jobDepartment=" + jobDepartment + ", jobCity=" + jobCity
				+ ", jobAdvantage=" + jobAdvantage + ", jobDescripe="
				+ jobDescripe + ", jobAddress=" + jobAddress + ", jobEmail="
				+ jobEmail + ", jobStartTime=" + jobStartTime + ", jobEndTime="
				+ jobEndTime + "]";
	}

	private Integer jobId;
	private Jobedu jobedu;
	private Companyinfo companyinfo;
	private Jobtype jobtype;
	private Jobstatus jobstatus;
	private Jobprop jobprop;
	private Jobexp jobexp;
	private Integer jobLowsal;
	private Integer jobHighsal;
	private String jobName;
	private String jobDepartment;
	private String jobCity;
	private String jobAdvantage;
	private String jobDescripe;
	private String jobAddress;
	private String jobEmail;
	private Timestamp jobStartTime;
	private Timestamp jobEndTime;
	private Set<Reportjob> reportjobs = new HashSet<Reportjob>(0);
	private Set<Auditionjudge> auditionjudges = new HashSet<Auditionjudge>(0);
	private Set<Jobdeliver> jobdelivers = new HashSet<Jobdeliver>(0);
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);
	private Set<Message> messages = new HashSet<Message>(0);

	// Constructors

	/** default constructor */
	public Jobinfo() {
	}

	/** full constructor */
	public Jobinfo(Jobedu jobedu, Companyinfo companyinfo, Jobtype jobtype,
			Jobstatus jobstatus, Jobprop jobprop, Jobexp jobexp,
			Integer jobLowsal, Integer jobHighsal, String jobName,
			String jobDepartment, String jobCity, String jobAdvantage,
			String jobDescripe, String jobAddress, String jobEmail,
			Timestamp jobStartTime, Timestamp jobEndTime,
			Set<Reportjob> reportjobs, Set<Auditionjudge> auditionjudges,
			Set<Jobdeliver> jobdelivers, Set<Userinfo> userinfos,
			Set<Message> messages) {
		this.jobedu = jobedu;
		this.companyinfo = companyinfo;
		this.jobtype = jobtype;
		this.jobstatus = jobstatus;
		this.jobprop = jobprop;
		this.jobexp = jobexp;
		this.jobLowsal = jobLowsal;
		this.jobHighsal = jobHighsal;
		this.jobName = jobName;
		this.jobDepartment = jobDepartment;
		this.jobCity = jobCity;
		this.jobAdvantage = jobAdvantage;
		this.jobDescripe = jobDescripe;
		this.jobAddress = jobAddress;
		this.jobEmail = jobEmail;
		this.jobStartTime = jobStartTime;
		this.jobEndTime = jobEndTime;
		this.reportjobs = reportjobs;
		this.auditionjudges = auditionjudges;
		this.jobdelivers = jobdelivers;
		this.userinfos = userinfos;
		this.messages = messages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "job_id", unique = true, nullable = false)
	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@ManyToOne
	@JoinColumn(name = "job_edu")
	public Jobedu getJobedu() {
		return this.jobedu;
	}

	public void setJobedu(Jobedu jobedu) {
		this.jobedu = jobedu;
	}

	@ManyToOne
	@JoinColumn(name = "job_company")
	public Companyinfo getCompanyinfo() {
		return this.companyinfo;
	}

	public void setCompanyinfo(Companyinfo companyinfo) {
		this.companyinfo = companyinfo;
	}

	@ManyToOne
	@JoinColumn(name = "job_type")
	public Jobtype getJobtype() {
		return this.jobtype;
	}

	public void setJobtype(Jobtype jobtype) {
		this.jobtype = jobtype;
	}

	@ManyToOne
	@JoinColumn(name = "job_status")
	public Jobstatus getJobstatus() {
		return this.jobstatus;
	}

	public void setJobstatus(Jobstatus jobstatus) {
		this.jobstatus = jobstatus;
	}

	@ManyToOne
	@JoinColumn(name = "job_prop")
	public Jobprop getJobprop() {
		return this.jobprop;
	}

	public void setJobprop(Jobprop jobprop) {
		this.jobprop = jobprop;
	}

	@ManyToOne
	@JoinColumn(name = "job_exp")
	public Jobexp getJobexp() {
		return this.jobexp;
	}

	public void setJobexp(Jobexp jobexp) {
		this.jobexp = jobexp;
	}

	@Column(name = "job_lowsal")
	public Integer getJobLowsal() {
		return this.jobLowsal;
	}

	public void setJobLowsal(Integer jobLowsal) {
		this.jobLowsal = jobLowsal;
	}

	@Column(name = "job_highsal")
	public Integer getJobHighsal() {
		return this.jobHighsal;
	}

	public void setJobHighsal(Integer jobHighsal) {
		this.jobHighsal = jobHighsal;
	}

	@Column(name = "job_name")
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Column(name = "job_department")
	public String getJobDepartment() {
		return this.jobDepartment;
	}

	public void setJobDepartment(String jobDepartment) {
		this.jobDepartment = jobDepartment;
	}

	@Column(name = "job_city")
	public String getJobCity() {
		return this.jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	@Column(name = "job_advantage")
	public String getJobAdvantage() {
		return this.jobAdvantage;
	}

	public void setJobAdvantage(String jobAdvantage) {
		this.jobAdvantage = jobAdvantage;
	}

	@Column(name = "job_descripe")
	public String getJobDescripe() {
		return this.jobDescripe;
	}

	public void setJobDescripe(String jobDescripe) {
		this.jobDescripe = jobDescripe;
	}

	@Column(name = "job_address")
	public String getJobAddress() {
		return this.jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
	}

	@Column(name = "job_email")
	public String getJobEmail() {
		return this.jobEmail;
	}

	public void setJobEmail(String jobEmail) {
		this.jobEmail = jobEmail;
	}

	@Column(name = "job_start_time", length = 19)
	public Timestamp getJobStartTime() {
		return this.jobStartTime;
	}

	public void setJobStartTime(Timestamp jobStartTime) {
		this.jobStartTime = jobStartTime;
	}

	@Column(name = "job_end_time", length = 19)
	public Timestamp getJobEndTime() {
		return this.jobEndTime;
	}

	public void setJobEndTime(Timestamp jobEndTime) {
		this.jobEndTime = jobEndTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobinfo")
	public Set<Reportjob> getReportjobs() {
		return this.reportjobs;
	}

	public void setReportjobs(Set<Reportjob> reportjobs) {
		this.reportjobs = reportjobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobinfo")
	public Set<Auditionjudge> getAuditionjudges() {
		return this.auditionjudges;
	}

	public void setAuditionjudges(Set<Auditionjudge> auditionjudges) {
		this.auditionjudges = auditionjudges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobinfo")
	public Set<Jobdeliver> getJobdelivers() {
		return this.jobdelivers;
	}

	public void setJobdelivers(Set<Jobdeliver> jobdelivers) {
		this.jobdelivers = jobdelivers;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobinfos")
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "jobinfo")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}