package com.lagou.listener;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lagou.biz.CityinfoBIZ;
import com.lagou.biz.CompanyfieldBIZ;
import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.biz.CompanysizeBIZ;
import com.lagou.biz.CompanystageBIZ;
import com.lagou.biz.JobTypeBIZ;
import com.lagou.biz.JobeduBIZ;
import com.lagou.biz.JobexpBIZ;
import com.lagou.biz.JobpropBIZ;
import com.lagou.biz.SalBIZ;
import com.lagou.domain.Cityinfo;
import com.lagou.domain.Companyfield;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Companysize;
import com.lagou.domain.Companystage;
import com.lagou.domain.Jobedu;
import com.lagou.domain.Jobexp;
import com.lagou.domain.Jobprop;
import com.lagou.domain.Jobtype;
import com.lagou.domain.Sal;
import com.opensymphony.xwork2.ActionContext;

/**
 * Application Lifecycle Listener implementation class InitCompanystateListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {
	
	
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext app = arg0.getServletContext();
    	ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(app);
    	
    	CompanystageBIZ companystageBIZ = (CompanystageBIZ) context.getBean("CompanystageBIZImp");
    	List<Companystage> stagelist = companystageBIZ.findAll();
    	
    	CompanyfieldBIZ companyfieldBIZ = (CompanyfieldBIZ) context.getBean("CompanyfieldBIZImp");
    	List<Companyfield> fieldlist = companyfieldBIZ.findAll();
    	
    	CityinfoBIZ cityinfoBIZ = (CityinfoBIZ) context.getBean("CityinfoBIZImp");
    	List<Cityinfo> citylist = cityinfoBIZ.findAll();
    	
    	SalBIZ salbiz = (SalBIZ) context.getBean("SalBIZImp");
    	List<Sal> sallist = salbiz.findAll();
    	
    	JobTypeBIZ jobtypeBIZ=(JobTypeBIZ) context.getBean("JobTypeBIZImp");
    	List<Jobtype> typelvlist = jobtypeBIZ.findBylv();
  
    	CompanysizeBIZ companysizeBIZ=(CompanysizeBIZ) context.getBean("CompanysizeBIZImp");
    	List<Companysize> sizeliList=companysizeBIZ.findAll();
    	
    	JobpropBIZ jobpropBIZ=(JobpropBIZ) context.getBean("JobpropBIZImp");
    	List<Jobprop> jobpropliList=jobpropBIZ.findAll();
    	
    	JobexpBIZ jobexpBIZ=(JobexpBIZ) context.getBean("JobexpBIZImp");
    	List<Jobexp> jobexpliList=jobexpBIZ.findAll();
    	
    	JobTypeBIZ jobtypeBIZ1=(JobTypeBIZ) context.getBean("JobTypeBIZImp");
    	List<Jobtype> jobtypelList = jobtypeBIZ1.findBylv();
    	 
    	JobeduBIZ jobeduBIZ=(JobeduBIZ) context.getBean("JobeduBIZImp");
    	List<Jobedu> jobedulList=jobeduBIZ.findAll();
    	
    	CompanyinfoBIZ companyinfoBIZ=(CompanyinfoBIZ) context.getBean("CompanyinfoBIZImp");
    	List<Companyinfo> companyinfoList=companyinfoBIZ.findAll();
    	
    	app.setAttribute("sallist", sallist);
    	app.setAttribute("citylist", citylist);
    	app.setAttribute("stagelist", stagelist);
    	app.setAttribute("fieldlist", fieldlist);
    	app.setAttribute("typelvlist", typelvlist);
    	app.setAttribute("sizeliList", sizeliList);
    	app.setAttribute("jobpropliList", jobpropliList);
    	app.setAttribute("jobexpliList", jobexpliList);
    	app.setAttribute("jobtypelList", jobtypelList);
    	app.setAttribute("jobedulList", jobedulList);
    	app.setAttribute("companyinfoList", companyinfoList);
    	
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


	
}
