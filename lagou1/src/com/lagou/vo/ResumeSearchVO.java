package com.lagou.vo;

import java.util.Date;

public class ResumeSearchVO {
	/**
	 * 简历筛选条件
	 * 工作经验(一年以下,1-3年等)
	 * 最低学历(大专及以上)
	 * 版本1.0
	 */
	private Integer jobexp;
	private Integer jobedu;
	
	public ResumeSearchVO(Integer jobexp, Integer jobedu) {
		super();
		this.jobexp = jobexp;
		this.jobedu = jobedu;
	}
	public Integer getJobexp() {
		return jobexp;
	}
	public void setJobexp(Integer jobexp) {
		this.jobexp = jobexp;
	}
	public Integer getJobedu() {
		return jobedu;
	}
	public void setJobedu(Integer jobedu) {
		this.jobedu = jobedu;
	}

	
}
