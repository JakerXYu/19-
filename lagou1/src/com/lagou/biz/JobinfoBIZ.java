package com.lagou.biz;

import java.util.List;
import java.util.Set;

import com.lagou.domain.Jobinfo;
import com.lagou.domain.Subscribe;
import com.lagou.vo.JobSearchVO;

public interface JobinfoBIZ {
	/**
	 * 根据职位id查询id
	 * @return
	 */
	public Jobinfo findById(int id);
	/**
	 * 保存职位信息的功能(包括修改)
	 * @param jobinfo 传递一个Jobinfo对象存储到数据库
	 * @author 姜翔宇
	 */
	public void releasePosition(Jobinfo jobinfo);
	/**
	 * 查询所有职位信息
	 * @return 所有职位信息
	 * @author 姜翔宇
	 */
	public List<Jobinfo> findAll();
	/**
	 * 按照多条件(月薪范围,工作经验,学历,工作性质,发布时间)查询职位信息
	 * @param jobsearchVo
	 * @return 符合条件的职位信息列表
	 * @author 姜翔宇
	 */
	public List<Jobinfo> findBySearch(JobSearchVO jobsearchVo);
	/**
	 * 查询投递简历数量最多的职位信息
	 * @return 符合条件的职位信息列表
	 * @author 姜翔宇
	 */
	public String findByHot();
	/**
	 * 查询最新的职位信息
	 * @return 符合条件的职位信息列表
	 * @author 姜翔宇
	 */
	public String findByNew();
	/**
	 * 根据订阅条件推荐职位列表
	 * @param subscribe
	 * @return 符合条件的职位信息列表
	 * @author 姜翔宇
	 */
	public String findBySubscribe(Set<Subscribe> subscribe);
	 /**
     * 查找当前公司的所有发布职业信息,条件为上线或者上线.zh
     * @param resumeinfoid1
     * @return List<Jobinfo>
     */
	public List<Jobinfo> findByUser(Integer companyId, Integer status);
}