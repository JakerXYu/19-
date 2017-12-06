package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Subscribe;
import com.lagou.domain.Userinfo;


public interface SubscribeBIZ {
	/*
	 * 添加订阅职位的信息
	 */
	public boolean save(Subscribe subscribe);
	/*
	 * 查询所有的订阅职位信息
	 */
	public List<Subscribe> findByUser(Userinfo userinfo);
	/*
	 * 删除该条订阅职位的信息
	 */
	public boolean delect(Subscribe subscribe);
	/*
	 * 根据该条订阅信息的id来获得对应的该对象
	 */
	public Subscribe findById(int subscribeId);

}
