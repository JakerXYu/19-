package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Jobexp;

public interface JobexpBIZ {
	public List<Jobexp> findAll();
	public Jobexp findById(Integer Id);
}
