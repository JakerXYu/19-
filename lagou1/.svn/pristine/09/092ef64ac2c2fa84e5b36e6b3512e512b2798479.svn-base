package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.CompanystageBIZ;
import com.lagou.dao.CompanystageDAO;
import com.lagou.domain.Companystage;
@Service("CompanystageBIZImp")
public class CompanystageBIZImp implements CompanystageBIZ {
	@Autowired@Qualifier("CompanystageDAO")
	private CompanystageDAO companystageDAO;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Companystage> findAll(){
		List<Companystage> stagelist = companystageDAO.findAll();
	
		return stagelist;
		
	}

}
