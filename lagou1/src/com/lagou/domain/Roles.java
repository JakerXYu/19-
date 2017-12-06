package com.lagou.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;


/**
 * Roles entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "roles", catalog = "lagou")
public class Roles implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleName;
	private List<Funs> funses = new ArrayList<Funs>(0);//当前节点具有的一级功能列表
	private List<Admins> adminses = new ArrayList<Admins>(0);

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String roleName, List<Funs> funses, List<Admins> adminses) {
		this.roleName = roleName;
		this.funses = funses;
		this.adminses = adminses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@OrderBy("funId desc")
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "permissions", catalog = "lagou", joinColumns = { @JoinColumn(name = "permission_role", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "permission_fun", updatable = false) })
	public List<Funs> getFunses() {
		return this.funses;
	}

	public void setFunses(List<Funs> funses) {
		this.funses = funses;
	}
	
	@OrderBy("adminId desc")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roles")
	public List<Admins> getAdminses() {
		return this.adminses;
	}

	public void setAdminses(List<Admins> adminses) {
		this.adminses = adminses;
	}

}