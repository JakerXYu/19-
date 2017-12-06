package com.lagou.biz;

import com.lagou.domain.Userinfo;
import com.lagou.exception.NameExistException;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;

public interface UserinfoBIZ {
//public Userinfo findByUsername(String username);
	public Userinfo userlogin(String username,String password) throws NameMissException, PassErrorException;
	//用户注册
	public void reg(Userinfo user) throws NameExistException;
	public Userinfo findByUserName(Object userName);
}
