package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lagou.biz.SalBIZ;
import com.lagou.dao.SalDAO;
import com.lagou.domain.Sal;
@Service("SalBIZImp")
public class SalBIZImp implements SalBIZ {
	@Autowired@Qualifier("SalDAO")
	private SalDAO salDAO;

	@Override
	public List<Sal> findAll() {
		
		return salDAO.findAll();
	}

}
