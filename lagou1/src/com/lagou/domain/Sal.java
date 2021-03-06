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
 * Sal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sal", catalog = "lagou")
public class Sal implements java.io.Serializable {

	// Fields

	private Integer salId;
	private Integer salMax;
	private Integer salMin;
	private Set<Expectjob> expectjobs = new HashSet<Expectjob>(0);
	private Set<Subscribe> subscribes = new HashSet<Subscribe>(0);

	// Constructors

	/** default constructor */
	public Sal() {
	}

	/** full constructor */
	public Sal(Integer salMax, Integer salMin, Set<Expectjob> expectjobs,
			Set<Subscribe> subscribes) {
		this.salMax = salMax;
		this.salMin = salMin;
		this.expectjobs = expectjobs;
		this.subscribes = subscribes;
	}
	@Override
	public String toString() {
		return "Sal [salMax=" + salMax + ", salMin=" + salMin + "]";
	}

	public Sal(Integer salMin, Integer salMax) {
		this.salMax = salMax;
		this.salMin = salMin;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "sal_id", unique = true, nullable = false)
	public Integer getSalId() {
		return this.salId;
	}

	public void setSalId(Integer salId) {
		this.salId = salId;
	}

	@Column(name = "sal_max")
	public Integer getSalMax() {
		return this.salMax;
	}

	public void setSalMax(Integer salMax) {
		this.salMax = salMax;
	}

	@Column(name = "sal_min")
	public Integer getSalMin() {
		return this.salMin;
	}

	public void setSalMin(Integer salMin) {
		this.salMin = salMin;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sal")
	public Set<Expectjob> getExpectjobs() {
		return this.expectjobs;
	}

	public void setExpectjobs(Set<Expectjob> expectjobs) {
		this.expectjobs = expectjobs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sal")
	public Set<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(Set<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

}