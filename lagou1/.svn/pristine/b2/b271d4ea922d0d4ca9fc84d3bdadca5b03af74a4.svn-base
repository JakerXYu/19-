package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.CompanyfieldBIZ;
import com.lagou.dao.CompanyfieldDAO;
import com.lagou.domain.Companyfield;
@Service("CompanyfieldBIZImp")
public class CompanyfieldBIZImp implements CompanyfieldBIZ {
	@Autowired@Qualifier("CompanyfieldDAO")
	private CompanyfieldDAO companyfieldDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Companyfield> findAll() {
		
		return this.companyfieldDAO.findAll();
	}

	public CompanyfieldDAO getCompanyfieldDAO() {
		return companyfieldDAO;
	}

	public void setCompanyfieldDAO(CompanyfieldDAO companyfieldDAO) {
		this.companyfieldDAO = companyfieldDAO;
	}
	

}
