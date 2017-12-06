package com.lagou.vo;

public class JobdeliverVO {
	private Integer jobId;
	private Integer statusId;
	public JobdeliverVO() {
		// TODO Auto-generated constructor stub
	}
	public JobdeliverVO(Integer jobId, Integer statusId) {
		super();
		this.jobId = jobId;
		this.statusId = statusId;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	
	

}
