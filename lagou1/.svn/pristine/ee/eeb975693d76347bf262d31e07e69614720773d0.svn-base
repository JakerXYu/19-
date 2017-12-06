package com.lagou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lagou.biz.JobdeliverBIZ;
import com.lagou.biz.ResumestatusBIZ;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Resumestatus;

public class tests {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
	
		ResumestatusBIZ statusBIZ = (ResumestatusBIZ) context.getBean("ResumestatusBIZImp");
		Resumestatus status = statusBIZ.findById(4);
		System.out.println(status.getStatusName()+"=======================");
		JobdeliverBIZ jobBIZ = (JobdeliverBIZ) context.getBean("JobdeliverBIZImp");
		Jobdeliver job = jobBIZ.findById(4);
		System.out.println(job.getResumestatus().getStatusName()+"+++++++++++++++");
	}
}
