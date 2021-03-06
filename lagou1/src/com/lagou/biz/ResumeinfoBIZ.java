package com.lagou.biz;

import java.util.List;

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

public interface ResumeinfoBIZ {
	/**
	 * 查看简历信息
	 * @param userId  用户Id
	 * @return	返回一个简历对象
	 */
	public List<Resumeinfo> findByUser(int userId);
	
	/**
	 * 修改简历信息——个人信息
	 * @param userinfo
	 */
	public void update(Userinfo userinfo);
	
	/**
	 * 修改简历信息——
	 * @param resume 简历信息对象
	 */
	public void update(Resumeinfo resume);
	
	/**
	 * 修改简历信息——期望工作
	 * @param expectjob
	 */
	public void update(Expectjob expectjob);
	
	/**
	 * 根据给定的id查询期望工作信息
	 * @param expectjobId
	 * @return 期望工作对象
	 */
	public Expectjob findByExpectjob(int expectjobId);
	
	/**
	 * 修改简历信息——工作经历
	 * @param userworkexp
	 */
	public void update(Userworkexp userworkexp);
	
	
	/**
	 * 修改简历信息——项目经验
	 * @param useritem
	 */
	public void update(Useritem useritem);
	
	public Jobprop findByJobprop(int jobpropId);
	public Cityinfo findByCity(int cityId);
	public Sal findBySal(int salId);
	/**
	 * ——————————————————————————————陶陶
	 * 按简历状态查找简历信息
	 * @param userId 用户id
	 * @param statusId 简历状态id
	 * @return 简历信息的集合
	 */
	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo, int status) ;
	public List<Jobdeliver> findByResumeStatuss(Companyinfo companyinfo, int status,
			ResumeSearchVO resumeSearchVO);
}
