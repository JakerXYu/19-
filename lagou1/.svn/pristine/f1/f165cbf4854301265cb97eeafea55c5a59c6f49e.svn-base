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
 * Companystage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companystage", catalog = "lagou")
public class Companystage implements java.io.Serializable {

	// Fields

	private Integer stageId;
	private String stageName;
	private Set<Companyinfo> companyinfos = new HashSet<Companyinfo>(0);
	private Set<Subscribe> subscribes = new HashSet<Subscribe>(0);

	// Constructors

	/** default constructor */
	public Companystage() {
	}

	/** full constructor */
	public Companystage(String stageName, Set<Companyinfo> companyinfos,
			Set<Subscribe> subscribes) {
		this.stageName = stageName;
		this.companyinfos = companyinfos;
		this.subscribes = subscribes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "stage_id", unique = true, nullable = false)
	public Integer getStageId() {
		return this.stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	@Column(name = "stage_name")
	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companystage")
	public Set<Companyinfo> getCompanyinfos() {
		return this.companyinfos;
	}

	public void setCompanyinfos(Set<Companyinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companystage")
	public Set<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(Set<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

}