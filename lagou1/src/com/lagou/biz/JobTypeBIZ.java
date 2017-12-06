package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Jobprop;
import com.lagou.domain.Jobtype;

public interface JobTypeBIZ {

	/*
	 * 查找一级的所有
	 */
	public List<Jobtype> findBylv();
	public List<Jobtype> findAll();
	/**
	 * 按照id查找
	 * @param jobTypeId
	 * @return
	 */
	public Jobtype findById(Integer jobTypeId);
}
