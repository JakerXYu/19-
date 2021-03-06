package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobexpBIZ;
import com.lagou.dao.JobexpDAO;
import com.lagou.dao.JobpropDAO;
import com.lagou.domain.Jobexp;
import com.lagou.domain.Jobprop;
@Service("JobexpBIZImp")
public class JobexpBIZImp implements JobexpBIZ {

	@Autowired@Qualifier("JobexpDAO")
	private JobexpDAO JobexpDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobexp> findAll() {
		List<Jobexp> jobexpList=this.JobexpDAO.findAll();
		return jobexpList;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Jobexp findById(Integer Id) {
		return JobexpDAO.findById(Id);
	}
	public JobexpDAO getJobexpDAO() {
		return JobexpDAO;
	}
	public void setJobexpDAO(JobexpDAO jobexpDAO) {
		JobexpDAO = jobexpDAO;
	}

}
