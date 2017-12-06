package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lagou.dao.JobpropDAO;
import com.lagou.biz.JobpropBIZ;
import com.lagou.domain.Jobprop;
@Service("JobpropBIZImp")
public class JobpropBIZImp implements JobpropBIZ {

	@Autowired@Qualifier("JobpropDAO")
	private JobpropDAO JobpropDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobprop> findAll() {
		List<Jobprop> jobpropList=this.JobpropDAO.findAll();
		return jobpropList;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Jobprop findById(Integer jobpropId) {
		
		return JobpropDAO.findById(jobpropId);
	}
	
	public JobpropDAO getJobpropDAO() {
		return JobpropDAO;
	}
	public void setJobpropDAO(JobpropDAO jobpropDAO) {
		JobpropDAO = jobpropDAO;
	}
	

}
