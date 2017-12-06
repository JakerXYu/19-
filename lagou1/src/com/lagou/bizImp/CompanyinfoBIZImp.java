package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.dao.CompanyinfoDAO;
import com.lagou.dao.UserinfoDAO;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Userinfo;
import com.lagou.exception.NameExistException;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.utils.MD5_Encoding;
import com.lagou.vo.CompanySearchVO;

@Service("CompanyinfoBIZImp")
public class CompanyinfoBIZImp implements CompanyinfoBIZ {
	@Autowired
	@Qualifier("CompanyinfoDAO")
	private CompanyinfoDAO companyinfoDAO;
	@Autowired
	@Qualifier("UserinfoDAO")
	private UserinfoDAO userinfoDAO;// zh
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void update(Companyinfo instance){
		this.companyinfoDAO.attachDirty(instance);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Companyinfo> findBySearch(CompanySearchVO searchvo) {

		return this.companyinfoDAO.findBySearch(searchvo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Companyinfo> findAll() {
		List<Companyinfo> companylist = companyinfoDAO.findAll();
		return companylist;
	}

	public CompanyinfoDAO getCompanyinfoDAO() {
		return companyinfoDAO;
	}

	public void setCompanyinfoDAO(CompanyinfoDAO companyinfoDAO) {
		this.companyinfoDAO = companyinfoDAO;
	}

	public UserinfoDAO getUserinfoDAO() {
		return userinfoDAO;
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	/**
	 * HR登录
	 * 
	 * @author ZH
	 * @param username
	 *            password
	 * @return companyinfo
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Companyinfo companylogin(String username, String password)
			throws NameMissException, PassErrorException {
		MD5_Encoding md5_Encoding=new MD5_Encoding();
		Companyinfo companyinfo = companyinfoDAO.findByUsername(username);
		if (companyinfo == null) {
			throw new NameMissException("用户名不存在！");
		} else {
			if (companyinfo.getCompanyPassword().equals(md5_Encoding.getMD5ofStr(password))) {
				return companyinfo;
			} else {
				throw new PassErrorException("密码错误！");
			}
		}
	}

	/**
	 * 求职者登录
	 * 
	 * @param 登录名和密码
	 * @author ZH
	 * @return Userinfo
	 */
	@Override
	public Userinfo userlogin(String username, String password)
			throws NameMissException, PassErrorException {
		MD5_Encoding md5_Encoding=new MD5_Encoding();
		Userinfo userinfo = userinfoDAO.findByUsername(username);
		if (userinfo == null) {
			throw new NameMissException("用户名不存在！");
		} else {
			if (userinfo.getUserinfoPassword().equals(md5_Encoding.getMD5ofStr(password))) {
				return userinfo;
			} else {
				throw new PassErrorException("密码错误！");
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { NameExistException.class })
	public void reg(Companyinfo companyinfo) throws NameExistException {
		if ("".equals(this.companyinfoDAO.findByUserName(companyinfo
				.getCompanyLogname()))
				|| this.companyinfoDAO.findByUserName(companyinfo
						.getCompanyLogname()) == null) {
			this.companyinfoDAO.save(companyinfo);
		} else {
			throw new NameExistException("用户名已存在！");
		}
	}

	public Companyinfo findByUserName(Object companyLogname) {
		return this.companyinfoDAO.findByUserName(companyLogname);
	}

}
