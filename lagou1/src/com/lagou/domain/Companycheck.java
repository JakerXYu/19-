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
 * Companycheck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companycheck", catalog = "lagou")
public class Companycheck implements java.io.Serializable {

	// Fields

	private Integer companyCheckId;
	private String companyCheckState;
	private String companyCheckMessage;
	private Set<Companyinfo> companyinfos = new HashSet<Companyinfo>(0);

	// Constructors

	/** default constructor */
	public Companycheck() {
	}

	/** full constructor */
	public Companycheck(String companyCheckState, String companyCheckMessage,
			Set<Companyinfo> companyinfos) {
		this.companyCheckState = companyCheckState;
		this.companyCheckMessage = companyCheckMessage;
		this.companyinfos = companyinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "company_check_id", unique = true, nullable = false)
	public Integer getCompanyCheckId() {
		return this.companyCheckId;
	}

	public void setCompanyCheckId(Integer companyCheckId) {
		this.companyCheckId = companyCheckId;
	}

	@Column(name = "company_check_state")
	public String getCompanyCheckState() {
		return this.companyCheckState;
	}

	public void setCompanyCheckState(String companyCheckState) {
		this.companyCheckState = companyCheckState;
	}

	@Column(name = "company_check_message")
	public String getCompanyCheckMessage() {
		return this.companyCheckMessage;
	}

	public void setCompanyCheckMessage(String companyCheckMessage) {
		this.companyCheckMessage = companyCheckMessage;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companycheck")
	public Set<Companyinfo> getCompanyinfos() {
		return this.companyinfos;
	}

	public void setCompanyinfos(Set<Companyinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

}