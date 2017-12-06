package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Companyinfo;
import com.lagou.domain.Userinfo;
import com.lagou.exception.NameExistException;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.vo.CompanySearchVO;

public interface CompanyinfoBIZ {
	public void reg(Companyinfo company) throws NameExistException;
	public Companyinfo findByUserName(Object companyLogname);
	public void update(Companyinfo instance);
	/**
	 *用户登陆
	 * 
	 * @param 用户名
	 *            密码
	 */
	public Userinfo userlogin(String username, String password)
			throws NameMissException, PassErrorException;
	/**
	 * 查看所有公司信息
	 * 
	 * @param
	 */
	public List<Companyinfo> findAll();

	/**
	 * 公司登陆
	 * 
	 * @param 用户名
	 *            密码
	 */
	public Companyinfo companylogin(String username, String password)
			throws NameMissException, PassErrorException;

	/**
	 * 多条件查询公司
	 * 
	 * @param 查询条件Vo类
	 */
	public List<Companyinfo> findBySearch(CompanySearchVO searchvo);
}
