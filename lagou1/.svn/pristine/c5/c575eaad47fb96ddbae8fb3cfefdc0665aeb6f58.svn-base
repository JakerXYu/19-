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
 * Companysize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "companysize", catalog = "lagou")
public class Companysize implements java.io.Serializable {

	// Fields

	private Integer sizeId;
	private String sizeName;
	private Set<Companyinfo> companyinfos = new HashSet<Companyinfo>(0);

	// Constructors

	/** default constructor */
	public Companysize() {
	}

	/** full constructor */
	public Companysize(String sizeName, Set<Companyinfo> companyinfos) {
		this.sizeName = sizeName;
		this.companyinfos = companyinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "size_id", unique = true, nullable = false)
	public Integer getSizeId() {
		return this.sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	@Column(name = "size_name")
	public String getSizeName() {
		return this.sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "companysize")
	public Set<Companyinfo> getCompanyinfos() {
		return this.companyinfos;
	}

	public void setCompanyinfos(Set<Companyinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

}