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
 * Auditioninfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auditioninfo", catalog = "lagou")
public class Auditioninfo implements java.io.Serializable {

	// Fields

	private Integer auditionId;
	private Timestamp auditionTime;
	private String auditionAddress;
	private String auditionDescribe;
	private Set<Jobdeliver> jobdelivers = new HashSet<Jobdeliver>(0);

	// Constructors

	/** default constructor */
	public Auditioninfo() {
	}

	/** full constructor */
	public Auditioninfo(Timestamp auditionTime, String auditionAddress,
			String auditionDescribe, Set<Jobdeliver> jobdelivers) {
		this.auditionTime = auditionTime;
		this.auditionAddress = auditionAddress;
		this.auditionDescribe = auditionDescribe;
		this.jobdelivers = jobdelivers;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "audition_id", unique = true, nullable = false)
	public Integer getAuditionId() {
		return this.auditionId;
	}

	public void setAuditionId(Integer auditionId) {
		this.auditionId = auditionId;
	}

	@Column(name = "audition_time", length = 19)
	public Timestamp getAuditionTime() {
		return this.auditionTime;
	}

	public void setAuditionTime(Timestamp auditionTime) {
		this.auditionTime = auditionTime;
	}

	@Column(name = "audition_address")
	public String getAuditionAddress() {
		return this.auditionAddress;
	}

	public void setAuditionAddress(String auditionAddress) {
		this.auditionAddress = auditionAddress;
	}

	@Column(name = "audition_describe")
	public String getAuditionDescribe() {
		return this.auditionDescribe;
	}

	public void setAuditionDescribe(String auditionDescribe) {
		this.auditionDescribe = auditionDescribe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auditioninfo")
	public Set<Jobdeliver> getJobdelivers() {
		return this.jobdelivers;
	}

	public void setJobdelivers(Set<Jobdeliver> jobdelivers) {
		this.jobdelivers = jobdelivers;
	}

}