package com.lagou.bizImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.biz.JobinfoBIZ;
import com.lagou.dao.JobinfoDAO;
import com.lagou.dao.SalDAO;
import com.lagou.domain.Companysize;
import com.lagou.domain.Jobinfo;
import com.lagou.domain.Sal;
import com.lagou.domain.Subscribe;
import com.lagou.utils.JakerListToHTMLUtil;
import com.lagou.vo.JobSearchVO;

@Service("JobinfoBIZImp")
public class JobinfoBIZImp implements JobinfoBIZ {
	@Override
	public Jobinfo findById(int id) {
		
		return this.jobinfoDAO.findById(id);
	}

	@Autowired
	@Qualifier("JobinfoDAO")
	private JobinfoDAO jobinfoDAO;
	@Autowired@Qualifier("SalDAO")
	private SalDAO salDAO;

	@Override
	public String findBySubscribe(Set<Subscribe> subscribes) {
		
		JobSearchVO jobSearchVO = new JobSearchVO();
		List<Jobinfo> jobs=new ArrayList<Jobinfo>();
		for (Subscribe subscribe : subscribes) {
			if(subscribe.getCityinfo()!=null){
				jobSearchVO.setCity(subscribe.getCityinfo().getCityName());
			}
			/*if(subscribe.getJobtype()!=null){
				jobSearchVO.setJobTypeId(subscribe.getJobtype().getTypeId());
			}*/
			if(subscribe.getSal()!=null){
				jobSearchVO.setSal(subscribe.getSal().getSalId());
			}
			if(subscribe.getCompanyfield()!=null){
				jobSearchVO.setField(subscribe.getCompanyfield().getFieldId());
			}
			if(subscribe.getCompanystage()!=null){
				jobSearchVO.setStage(subscribe.getCompanystage().getStageId());
			}
			
			List<Jobinfo> job = this.jobinfoDAO.findBySearch(jobSearchVO);
			System.out.println(job);
			for (Jobinfo jobinfo : job) {
				if (!jobs.contains(jobinfo)) {
					jobs.add(jobinfo);
				}
			}
		}
		System.out.println(jobs);
		
		return new String (JakerListToHTMLUtil.change(jobs));
		}
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void releasePosition(Jobinfo jobinfo) {
		this.jobinfoDAO.save(jobinfo);
	}
	@Override
	public List<Jobinfo> findBySearch(JobSearchVO jobsearchVo) {
//		jobsearchVo=jobsearchVo.change(jobsearchVo);
		List<Jobinfo> jobinfoList =  this.jobinfoDAO.findBySearch(jobsearchVo);
//		return	new String (JakerListToHTMLUtil.change2(jobinfoList));
		return jobinfoList;
		
		
		
		
	}


	@Override
	public String findByHot() {
		try {
			List<Jobinfo> jobinfoList = this.jobinfoDAO.findByHot();
			return new String (JakerListToHTMLUtil.change(jobinfoList));
			/*System.out.println(jobinfoList);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] { "reportjobs",
					"auditionjudges", "jobdelivers", "userinfos", "messages",
					"jobinfos", "useredus", "companyinfos", "subscribes",
					"Jobtype.jobtype", "jobtypes", "expectjobs" });
			jsonConfig.setExcludes(new String[] { "reportjobs",
					"auditionjudges", "resumeinfo", "resumestatus",
					"jobdeliver.jobinfo", "jobdeliver.auditioninfo","jobdeliver.resumeinfo",
					"userinfos", "messages", "jobinfos", "useredus",
					"companyinfos", "subscribes", "Jobtype.jobtype",
					"jobtypes", "expectjobs" });
			JSONArray jsonArray = JSONArray.fromObject(jobinfoList, jsonConfig);
			System.out.println(jsonArray.toString());
			return jsonArray.toString();*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public String findByNew() {
		try {
			List<Jobinfo> jobinfoList = this.jobinfoDAO.findByNew();
			return new String (JakerListToHTMLUtil.change(jobinfoList));
			/*System.out.println(jobinfoList);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[] { "reportjobs",
					"auditionjudges", "jobdelivers", "userinfos", "messages",
					"jobinfos", "useredus", "companyinfos", "subscribes",
					"Jobtype.jobtype", "jobtypes", "expectjobs" });
			JSONArray jsonArray = JSONArray.fromObject(jobinfoList, jsonConfig);
			return jsonArray.toString();*/
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public SalDAO getSalDAO() {
		return salDAO;
	}


	public void setSalDAO(SalDAO salDAO) {
		this.salDAO = salDAO;
	}


	public JobinfoDAO getJobinfoDAO() {
		return jobinfoDAO;
	}

	public void setJobinfoDAO(JobinfoDAO jobinfoDAO) {
		this.jobinfoDAO = jobinfoDAO;
	}


	@Override
	public List<Jobinfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Jobinfo> findByUser(Integer companyId, Integer status) {
		return jobinfoDAO.findByUser(companyId,status);
	}

}
