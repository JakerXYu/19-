package com.lagou.domain;

import java.sql.Timestamp;
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
 * Useritem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "useritem", catalog = "lagou")
public class Useritem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private String itemName;
	private String itemDuty;
	private String itemBegtime;
	private Timestamp itemEndtime;
	private Timestamp itemDiscrebe;
	private Set<Resumeinfo> resumeinfos = new HashSet<Resumeinfo>(0);

	// Constructors

	/** default constructor */
	public Useritem() {
	}

	/** full constructor */
	public Useritem(String itemName, String itemDuty, String itemBegtime,
			Timestamp itemEndtime, Timestamp itemDiscrebe,
			Set<Resumeinfo> resumeinfos) {
		this.itemName = itemName;
		this.itemDuty = itemDuty;
		this.itemBegtime = itemBegtime;
		this.itemEndtime = itemEndtime;
		this.itemDiscrebe = itemDiscrebe;
		this.resumeinfos = resumeinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "item_id", unique = true, nullable = false)
	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "item_name")
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_duty")
	public String getItemDuty() {
		return this.itemDuty;
	}

	public void setItemDuty(String itemDuty) {
		this.itemDuty = itemDuty;
	}

	@Column(name = "item_begtime")
	public String getItemBegtime() {
		return this.itemBegtime;
	}

	public void setItemBegtime(String itemBegtime) {
		this.itemBegtime = itemBegtime;
	}

	@Column(name = "item_endtime", length = 19)
	public Timestamp getItemEndtime() {
		return this.itemEndtime;
	}

	public void setItemEndtime(Timestamp itemEndtime) {
		this.itemEndtime = itemEndtime;
	}

	@Column(name = "item_discrebe", length = 19)
	public Timestamp getItemDiscrebe() {
		return this.itemDiscrebe;
	}

	public void setItemDiscrebe(Timestamp itemDiscrebe) {
		this.itemDiscrebe = itemDiscrebe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "useritem")
	public Set<Resumeinfo> getResumeinfos() {
		return this.resumeinfos;
	}

	public void setResumeinfos(Set<Resumeinfo> resumeinfos) {
		this.resumeinfos = resumeinfos;
	}

}