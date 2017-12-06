package com.lagou.bizImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lagou.biz.ResumestatusBIZ;
import com.lagou.dao.ResumestatusDAO;
import com.lagou.domain.Resumestatus;
@Service("ResumestatusBIZImp")
public class ResumestatusBIZImp implements ResumestatusBIZ {
	@Autowired@Qualifier("ResumestatusDAO")
	private ResumestatusDAO resumestatusDAO;

	@Override
	public Resumestatus findById(int statusid) {
		// TODO Auto-generated method stub
		return this.resumestatusDAO.findById(statusid);
	}

}
