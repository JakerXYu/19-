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
 * Admins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admins", catalog = "lagou")
public class Admins implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private Roles roles;
	private String adminName;
	private String adminPass;

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** full constructor */
	public Admins(Roles roles, String adminName, String adminPass) {
		this.roles = roles;
		this.adminName = adminName;
		this.adminPass = adminPass;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "admin_id", unique = true, nullable = false)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "admin_role")
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Column(name = "admin_name")
	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Column(name = "admin_pass", length = 32)
	public String getAdminPass() {
		return this.adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

}