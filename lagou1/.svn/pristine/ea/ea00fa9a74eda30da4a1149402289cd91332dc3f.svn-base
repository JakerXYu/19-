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
 * Cityinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cityinfo", catalog = "lagou")
public class Cityinfo implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private Set<Expectjob> expectjobs = new HashSet<Expectjob>(0);
	private Set<Subscribe> subscribes = new HashSet<Subscribe>(0);

	// Constructors

	/** default constructor */
	public Cityinfo() {
	}

	/** full constructor */
	public Cityinfo(String cityName, Set<Expectjob> expectjobs,
			Set<Subscribe> subscribes) {
		this.cityName = cityName;
		this.expectjobs = expectjobs;
		this.subscribes = subscribes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "city_id", unique = true, nullable = false)
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column(name = "city_name")
	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityinfo")
	public Set<Expectjob> getExpectjobs() {
		return this.expectjobs;
	}

	public void setExpectjobs(Set<Expectjob> expectjobs) {
		this.expectjobs = expectjobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cityinfo")
	public Set<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(Set<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

}