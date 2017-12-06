package com.lagou.biz;

import java.util.List;

import com.lagou.domain.Auditioninfo;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;

public interface AuditionEmailBIZ {
	public boolean SendEMail(Jobdeliver dels,Auditioninfo au,Companyinfo c)throws Exception;
}
