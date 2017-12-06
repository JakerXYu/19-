package com.lagou.domain;

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
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "lagou")
public class Message implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private Jobinfo jobinfo;
	private Userinfo userinfo;
	private Companyinfo companyinfo;
	private String messageContent;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Jobinfo jobinfo, Userinfo userinfo, Companyinfo companyinfo,
			String messageContent) {
		this.jobinfo = jobinfo;
		this.userinfo = userinfo;
		this.companyinfo = companyinfo;
		this.messageContent = messageContent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_job")
	public Jobinfo getJobinfo() {
		return this.jobinfo;
	}

	public void setJobinfo(Jobinfo jobinfo) {
		this.jobinfo = jobinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_user")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "message_company")
	public Companyinfo getCompanyinfo() {
		return this.companyinfo;
	}

	public void setCompanyinfo(Companyinfo companyinfo) {
		this.companyinfo = companyinfo;
	}

	@Column(name = "message_content")
	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

}