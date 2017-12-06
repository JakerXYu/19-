package com.lagou.bizImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.SubscribeBIZ;
import com.lagou.dao.SubscribeDAO;
import com.lagou.domain.Subscribe;
import com.lagou.domain.Userinfo;



@Service("SubscribeBIZImp")
public class SubscribeBIZImp implements SubscribeBIZ {
	@Autowired@Qualifier("SubscribeDAO")
	private SubscribeDAO subscribeDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Subscribe findById(int subscribeId) {
		// TODO Auto-generated method stub
		return this.subscribeDAO.findById(subscribeId);
	}


	
	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public boolean delect(Subscribe subscribe) {
		try{
			this.subscribeDAO.delete(subscribe);
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}

	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Subscribe> findByUser(Userinfo userinfo) {
		
		return this.subscribeDAO.findByUser(userinfo);
	}
	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={Exception.class})
	public boolean save(Subscribe subscribe) {
		try{
			subscribeDAO.save(subscribe);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	

	public SubscribeDAO getSubscribeDAO() {
		return subscribeDAO;
	}

	public void setSubscribeDAO(SubscribeDAO subscribeDAO) {
		this.subscribeDAO = subscribeDAO;
	}


	



	
	

}
