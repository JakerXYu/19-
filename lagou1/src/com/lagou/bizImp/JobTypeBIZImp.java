package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobTypeBIZ;
import com.lagou.dao.JobtypeDAO;
import com.lagou.domain.Jobexp;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Jobtype;
@Service("JobTypeBIZImp")
public class JobTypeBIZImp implements JobTypeBIZ {
	@Autowired@Qualifier("JobtypeDAO")
	private JobtypeDAO jobtypeDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobtype> findBylv() {
		// TODO Auto-generated method stub
		int typeLv = 1;
		return this.jobtypeDAO.findByTypeLv(typeLv);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Jobtype findById(Integer jobTypeId) {
		return jobtypeDAO.findById(jobTypeId);
	}
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobtype> findAll() {
		List<Jobtype> jobtypeList=this.jobtypeDAO.findAll();
		return jobtypeList;
	}

	public JobtypeDAO getJobtypeDAO() {
		return jobtypeDAO;
	}

	public void setJobtypeDAO(JobtypeDAO jobtypeDAO) {
		this.jobtypeDAO = jobtypeDAO;
	}


	

	

	
	

}
