package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobeduBIZ;
import com.lagou.dao.JobeduDAO;
import com.lagou.dao.JobexpDAO;
import com.lagou.domain.Jobedu;
@Service("JobeduBIZImp")
public class JobeduBIZImp implements JobeduBIZ {
	@Autowired@Qualifier("JobeduDAO")
	private JobeduDAO JobeduDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobedu> findAll() {
		List<Jobedu> jobexpList=this.JobeduDAO.findAll();
		return jobexpList;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Jobedu findById(Integer jobduId) {
		return JobeduDAO.findById(jobduId);
	}
	
	public JobeduDAO getJobeduDAO() {
		return JobeduDAO;
	}
	public void setJobeduDAO(JobeduDAO jobeduDAO) {
		JobeduDAO = jobeduDAO;
	}
	
}
