package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.CityinfoBIZ;
import com.lagou.dao.CityinfoDAO;
import com.lagou.domain.Cityinfo;
@Service("CityinfoBIZImp")
public class CityinfoBIZImp implements CityinfoBIZ {
	@Autowired@Qualifier("CityinfoDAO")
	private CityinfoDAO cityinfoDAO;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Cityinfo> findAll() {
		
		return this.cityinfoDAO.findAll();
	}
	

}
