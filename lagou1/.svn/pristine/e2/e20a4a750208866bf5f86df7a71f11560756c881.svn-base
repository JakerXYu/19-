package com.lagou.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.bizImp.CompanyinfoBIZImp;
import com.lagou.bizImp.UserinfoBIZImp;
import com.lagou.dao.CompanyinfoDAO;
import com.lagou.dao.UserinfoDAO;
import com.lagou.domain.Companyinfo;

public class testgu {

public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("/applicationContext.xml");;
	CompanyinfoDAO companyinfoDAO=(CompanyinfoDAO) context.getBean("CompanyinfoDAO");
	Companyinfo companyinfo =new Companyinfo();
	companyinfo=companyinfoDAO.findById(4);
	companyinfo.setCompanyName("lagou");
	companyinfoDAO.update(companyinfo);
    List<Companyinfo> companyinfoList=companyinfoDAO.findAll();
    for (Companyinfo companyinfo2 : companyinfoList) {
		System.out.println(companyinfo2.getCompanyName());
	}
	
}
}
