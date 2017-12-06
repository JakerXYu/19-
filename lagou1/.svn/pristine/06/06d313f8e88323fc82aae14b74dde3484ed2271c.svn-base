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
 * Companyfield entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companyfield", catalog = "lagou")
public class Companyfield implements java.io.Serializable {

	// Fields

	private Integer fieldId;
	private String fieldName;
	private Set<Companyinfo> companyinfos = new HashSet<Companyinfo>(0);
	private Set<Subscribe> subscribes = new HashSet<Subscribe>(0);

	// Constructors

	/** default constructor */
	public Companyfield() {
	}

	/** full constructor */
	public Companyfield(String fieldName, Set<Companyinfo> companyinfos,
			Set<Subscribe> subscribes) {
		this.fieldName = fieldName;
		this.companyinfos = companyinfos;
		this.subscribes = subscribes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "field_id", unique = true, nullable = false)
	public Integer getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	@Column(name = "field_name")
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companyfield")
	public Set<Companyinfo> getCompanyinfos() {
		return this.companyinfos;
	}

	public void setCompanyinfos(Set<Companyinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companyfield")
	public Set<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(Set<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

}