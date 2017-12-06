package com.lagou.bizImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobstatusBIZ;
import com.lagou.dao.JobexpDAO;
import com.lagou.dao.JobstatusDAO;
import com.lagou.domain.Jobstatus;
@Service("JobstatusBIZImp")
public class JobstatusBIZImp implements JobstatusBIZ {
	@Autowired@Qualifier("JobstatusDAO")
	private JobstatusDAO jobstatusDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Jobstatus findById(Integer id) {
		return jobstatusDAO.findById(id);
	}

}
