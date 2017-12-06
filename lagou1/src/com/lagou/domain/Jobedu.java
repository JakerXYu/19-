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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jobedu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "jobedu", catalog = "lagou")
public class Jobedu implements java.io.Serializable {

	// Fields

	private Integer eduId;
	private String eduName;
	private Set<Jobinfo> jobinfos = new HashSet<Jobinfo>(0);
	private Set<Useredu> useredus = new HashSet<Useredu>(0);

	// Constructors

	/** default constructor */
	public Jobedu() {
	}

	/** full constructor */
	public Jobedu(String eduName, Set<Jobinfo> jobinfos, Set<Useredu> useredus) {
		this.eduName = eduName;
		this.jobinfos = jobinfos;
		this.useredus = useredus;
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

	@Column(name = "edu_name")
	public String getEduName() {
		return this.eduName;
	}

	public void setEduName(String eduName) {
		this.eduName = eduName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobedu")
	public Set<Jobinfo> getJobinfos() {
		return this.jobinfos;
	}

	public void setJobinfos(Set<Jobinfo> jobinfos) {
		this.jobinfos = jobinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jobedu")
	public Set<Useredu> getUseredus() {
		return this.useredus;
	}

	public void setUseredus(Set<Useredu> useredus) {
		this.useredus = useredus;
	}

}