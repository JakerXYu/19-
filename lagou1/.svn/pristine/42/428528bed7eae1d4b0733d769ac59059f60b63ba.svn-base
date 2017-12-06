package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobdeliverBIZ;
import com.lagou.dao.JobdeliverDAO;
import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Resumestatus;
import com.lagou.domain.Userinfo;

/**
 * 
 * @author 陶雅楠
 *
 */
@Service("JobdeliverBIZImp")
public class JobdeliverBIZImp implements JobdeliverBIZ,java.io.Serializable{
	@Autowired@Qualifier("JobdeliverDAO")
    private JobdeliverDAO jobdeliverDao;
	/**
	 * 把一个简历投递记录保存到简历投递表里
	 * @param 简历投递记录
	 * 
	 */	
	
	@Override
	public Jobdeliver findById(int jobdeliverid) {
		// TODO Auto-generated method stub
		return this.jobdeliverDao.findById(jobdeliverid);
	}

	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public void save(Jobdeliver transientInstance) {
		this.jobdeliverDao.save(transientInstance);
          
	}
	
	/**
	 * 查询当前用户所有处于该状态的投递信息
	 * @param userinfo 用户对象
	 * @param status 简历状态id
	 * @return  简历集合
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Jobdeliver> findByResumeStatus(int resumeid,int status) {
		return this.jobdeliverDao.findByResumeStatus(resumeid, status);
	}
	/**
	 * 查找所有简历
	 * @return
	 */
	
	@Override
	public List<Jobdeliver> findByUser(int resumeinfoid1) {
		return this.jobdeliverDao.findByUser(resumeinfoid1);
	}
    
	@Override
	public List<Jobinfo> findJobDeliver(Userinfo userinfo) {
		
		return this.findJobDeliver(userinfo);
	}
	
	
	
	
	public JobdeliverDAO getJobdeliverDao() {
		return jobdeliverDao;
	}
	public void setJobdeliverDao(JobdeliverDAO jobdeliverDao) {
		this.jobdeliverDao = jobdeliverDao;
	}

	/**
	 * 更新投递记录表
	 * @param Jobdeliver
	 * @author ZH
	 *
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	@Override
	public void update(Jobdeliver jobdeliver) {
		jobdeliverDao.update(jobdeliver);
	}

	
	
}
