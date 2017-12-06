package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Jobdeliver;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Resumeinfo;
import com.lagou.domain.Resumestatus;
import com.lagou.domain.Userinfo;

/**
 * @author 陶w雅楠
 *投递简历接口类
 */
public interface JobdeliverBIZ {
	/**
	 * 把一个简历投递记录保存到简历投递表里
	 * @param 简历投递记录
	 * 
	 */	
	
	/*
	 * 通过投递记录的ID查找该条记录
	 */
	public Jobdeliver findById(int jobdeliverid);
	
	public void save(Jobdeliver transientInstance);
	/**
	 * 查询当前用户所有处于该状态的投递信息
	 * @param userinfo 用户对象
	 * @param status 简历状态id
	 * @return  简历集合
	 */
		public List<Jobdeliver> findByResumeStatus(int resumeid,int status);
		/**
		 * 查找所有简历
		 * @return
		 */
		
		public List<Jobdeliver> findByUser(int resumeinfoid1);
		public List<Jobinfo> findJobDeliver(Userinfo userinfo);
	
	public void update(Jobdeliver jobdeliver);
	
	
}
