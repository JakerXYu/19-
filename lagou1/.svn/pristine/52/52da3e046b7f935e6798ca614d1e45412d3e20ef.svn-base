package com.lagou.bizImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.UserinfoBIZ;
import com.lagou.dao.UserinfoDAO;
import com.lagou.domain.Userinfo;
import com.lagou.exception.NameExistException;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.utils.MD5_Encoding;

@Service("UserinfoBIZImp")
public class UserinfoBIZImp implements UserinfoBIZ {
	@Autowired
	@Qualifier("UserinfoDAO")
	UserinfoDAO userinfoDAO;

	public UserinfoDAO getUserinfoDAO() {
		return userinfoDAO;
	}

	public void setUserinfoDAO(UserinfoDAO userinfoDAO) {
		this.userinfoDAO = userinfoDAO;
	}

	@Override
	public Userinfo userlogin(String username, String password)
			throws NameMissException, PassErrorException {
		MD5_Encoding md5_Encoding=new MD5_Encoding();
		Userinfo userinfo = userinfoDAO.findByUsername(username);
		if (userinfo == null) {
			throw new NameMissException("用户名不存在！");
		} else {
			System.out.println(userinfo.getUserinfoPassword());
			System.out.println("=====================================");
			System.out.println(md5_Encoding.getMD5ofStr(password));
			if (userinfo.getUserinfoPassword().equals(md5_Encoding.getMD5ofStr(password))) {
				return userinfo;
			} else {
				throw new PassErrorException("密码错误！");
			}
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { NameExistException.class })
	public void reg(Userinfo user) throws NameExistException {
		if ("".equals(this.userinfoDAO.findByUserName(user.getUserinfoEmail()))
				|| this.userinfoDAO.findByUserName(user.getUserinfoEmail()) == null) {
			this.userinfoDAO.save(user);
		} else {
			throw new NameExistException("用户名已存在！");
		}
	}

	@Override
	public Userinfo findByUserName(Object userName) {
		return this.userinfoDAO.findByUserName(userName);
	}

	// @Override
	// public Userinfo findByUsername(String username) {
	// Userinfo userinfo =userinfoDAO.findByUsername(username);
	// return userinfo;
	// }

}
