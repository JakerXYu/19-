package com.lagou.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.bizImp.UserinfoBIZImp;
import com.lagou.dao.CompanyinfoDAO;
import com.lagou.dao.UserinfoDAO;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Userinfo;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
//求职者登录测试
public class LoginTest {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
		UserinfoDAO userinfoDAO=(UserinfoDAO) context.getBean("UserinfoDAO");
		UserinfoBIZImp userinfoBIZImp=new UserinfoBIZImp();
		userinfoBIZImp.setUserinfoDAO(userinfoDAO);
		String username="zh";
		String password="123456";
		try {
			Userinfo userinfo= userinfoBIZImp.userlogin(username, password);
			System.out.println(userinfo);
		} catch (NameMissException e) {
			System.out.println("测试登录名不存在");
			e.printStackTrace();
		} catch (PassErrorException e) {
			System.out.println("测试密码错误");
			e.printStackTrace();
		}
	}
	
	
//公司登录测试	
//	public static void main(String[] args) {
//		ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");
////		CompanyinfoDAO companyinfoDAO=(CompanyinfoDAO) context.getBean("CompanyinfoDAO");
////		String username="123456789@qq.com";
////		String password="112";
////		CompanyinfoBIZImp companyinfoBIZ=new CompanyinfoBIZImp();
////		companyinfoBIZ.setCompanyinfoDAO(companyinfoDAO);
////		try {
////			Companyinfo companyinfo=companyinfoBIZ.companylogin(username, password);
////			System.err.println(companyinfo+"???????????????????");
////		} catch (NameMissException e) {
////			System.out.println("测试登录名不存在");
////			e.printStackTrace();
////		} catch (PassErrorException e) {
////			System.out.println("测试密码错误");
////			e.printStackTrace();
////		}
////		
//	}
}

//String usename="zh";
//String password="123456";