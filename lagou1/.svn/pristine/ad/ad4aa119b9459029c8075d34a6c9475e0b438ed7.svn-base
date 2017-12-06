package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.ResumeinfoBIZ;
import com.lagou.dao.CityinfoDAO;
import com.lagou.dao.ExpectjobDAO;
import com.lagou.dao.JobpropDAO;
import com.lagou.dao.ResumeinfoDAO;
import com.lagou.dao.SalDAO;
import com.lagou.dao.UserinfoDAO;
import com.lagou.dao.UseritemDAO;
import com.lagou.dao.UserworkexpDAO;
import com.lagou.domain.Cityinfo;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Expectjob;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobprop;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Sal;
import com.lagou.domain.Userinfo;
import com.lagou.domain.Useritem;
import com.lagou.domain.Userworkexp;
import com.lagou.vo.ResumeSearchVO;
@Service("ResumeinfoBIZImp")
public class ResumeinfoBIZImp implements ResumeinfoBIZ {
	@Autowired@Qualifier("ResumeinfoDAO")
	private ResumeinfoDAO resumeinfoDAO;
	
	@Autowired@Qualifier("UserinfoDAO")
	private UserinfoDAO userinfoDAO;
	
	@Autowired@Qualifier("ExpectjobDAO")
	private ExpectjobDAO expectjobDAO;
	
	@Autowired@Qualifier("UserworkexpDAO")
	private UserworkexpDAO userworkexpDAO;
	
	@Autowired@Qualifier("UseritemDAO")
	private UseritemDAO useritemDAO;
	@Autowired@Qualifier("JobpropDAO")
	private JobpropDAO jobpropDAO;
	@Autowired@Qualifier("CityinfoDAO")
	private CityinfoDAO cityinfoDAO;
	@Autowired@Qualifier("SalDAO")
	private SalDAO salDAO;
	
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public List<Resumeinfo> findByUser(int userId) {
		return this.resumeinfoDAO.findByUser(userId);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@Override
	public void update(Useritem useritem) {
		this.useritemDAO.update(useritem);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void update(Userworkexp userworkexp) {
		this.userworkexpDAO.update(userworkexp);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void update(Userinfo userinfo) {
		this.userinfoDAO.update(userinfo);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void update(Expectjob expectjob) {
		this.expectjobDAO.update(expectjob);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void update(Resumeinfo resume) {
		this.resumeinfoDAO.update(resume);
	}
	@Override
	public Expectjob findByExpectjob(int expectjobId) {
		// TODO Auto-generated method stub
		return expectjobDAO.findById(expectjobId);
	}

	@Override
	public Jobprop findByJobprop(int jobpropId) {
		// TODO Auto-generated method stub
		return jobpropDAO.findById(jobpropId);
	}
	@Override
	public Cityinfo findByCity(int cityId) {
		return cityinfoDAO.findById(cityId);
	}
	@Override
	public Sal findBySal(int salId) {
		return salDAO.findById(salId);
	}
	public ResumeinfoDAO getResumeinfoDAO() {
		return resumeinfoDAO;
	}

	public void setResumeinfoDAO(ResumeinfoDAO resumeinfoDAO) {
		this.resumeinfoDAO = resumeinfoDAO;
	}
	

	public UserinfoDAO getUserinfoDAO() {
		return userinfoDAO;
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	public ExpectjobDAO getExpectjobDAO() {
		return expectjobDAO;
	}

	public void setExpectjobDAO(ExpectjobDAO expectjobDAO) {
		this.expectjobDAO = expectjobDAO;
	}

	public UserworkexpDAO getUserworkexpDAO() {
		return userworkexpDAO;
	}

	public void setUserworkexpDAO(UserworkexpDAO userworkexpDAO) {
		this.userworkexpDAO = userworkexpDAO;
	}

	public UseritemDAO getUseritemDAO() {
		return useritemDAO;
	}

	public void setUseritemDAO(UseritemDAO useritemDAO) {
		this.useritemDAO = useritemDAO;
	}

	
	
	public JobpropDAO getJobpropDAO() {
		return jobpropDAO;
	}

	public void setJobpropDAO(JobpropDAO jobpropDAO) {
		this.jobpropDAO = jobpropDAO;
	}

	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo, int status,
			ResumeSearchVO resumeSearchVO) {
		return resumeinfoDAO.findByResumeStatuss(companyinfo, status, resumeSearchVO);
	}
	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo, int status) {
		return resumeinfoDAO.findByResumeStatuss(companyinfo, status);
	}



}
