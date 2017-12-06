package com.lagou.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Email entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email", catalog = "lagou")
public class Email implements java.io.Serializable {

	// Fields

	private Integer emailId;
	private Userinfo userinfo;
	private Timestamp emailTime;

	// Constructors

	/** default constructor */
	public Email() {
	}

	/** full constructor */
	public Email(Userinfo userinfo, Timestamp emailTime) {
		this.userinfo = userinfo;
		this.emailTime = emailTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "email_id", unique = true, nullable = false)
	public Integer getEmailId() {
		return this.emailId;
	}

	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_user")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "email_time", length = 19)
	public Timestamp getEmailTime() {
		return this.emailTime;
	}

	public void setEmailTime(Timestamp emailTime) {
		this.emailTime = emailTime;
	}

}