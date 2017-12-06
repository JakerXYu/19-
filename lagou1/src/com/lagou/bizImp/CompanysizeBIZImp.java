package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.CompanysizeBIZ;
import com.lagou.dao.CompanysizeDAO;
import com.lagou.dao.CompanystageDAO;
import com.lagou.domain.Companysize;
@Service("CompanysizeBIZImp")
public class CompanysizeBIZImp implements CompanysizeBIZ {
	@Autowired@Qualifier("CompanysizeDAO")
	private CompanysizeDAO companysizeDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Companysize> findAll() {
		List<Companysize> companysizeList=this.companysizeDAO.findAll();
		return companysizeList;
	}
	public CompanysizeDAO getCompanysizeDAO() {
		return companysizeDAO;
	}
	public void setCompanysizeDAO(CompanysizeDAO companysizeDAO) {
		this.companysizeDAO = companysizeDAO;
	}

}
