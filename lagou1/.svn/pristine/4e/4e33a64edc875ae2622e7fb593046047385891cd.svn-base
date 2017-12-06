package com.lagou.vo;

import java.util.Date;

import com.lagou.utils.JakerDateUtil;
/**	多条件查询的VO对象
 * 工作类型(jobTypeId)
 *月薪(int minSal.int maxSal)
 *工作经验(workEXP),
 *学历(workEXP),
 *工作性质(jobProp),
 *发布时间(java.util.date)
 *工作地点(城市)
 **/
public class JobSearchVO {
	private Integer jobId;
	private Integer typeId;
	private JakerDateUtil dUtil = new JakerDateUtil();
	
	private String jobname;
	private Integer Sal;
	private Integer edu;
	private Integer workEXP;
	private Integer jobProp;
	private Integer Date;
	private String city;
	private Integer stage;
	private Integer field;
	private Date Sday;
	private Date Eday;
	private com.lagou.domain.Sal sala;
	
	

	

	
	@Override
	public String toString() {
		return "JobSearchVO [jobId=" + jobId + ", jobname=" + jobname + ", Sal=" + Sal + ", edu=" + edu
				+ ", workEXP=" + workEXP + ", jobProp=" + jobProp + ", Date="
				+ Date + ", city=" + city + ", stage=" + stage + ", field="
				+ field + ", Sday=" + Sday + ", Eday=" + Eday + ", sala="
				+ sala + "]";
	}

	public JobSearchVO update(JobSearchVO jVo, JobSearchVO retVo) {
		
		if (jVo.getCity() == "全国" || jVo.getCity() == null
				|| "".equals(jVo.getCity())) {
			retVo.setCity(null);
		} else {
			retVo.city = jVo.city;
		}
		if (jVo.getDate() == null) {

		} else if (jVo.getDate() == 1) {
			retVo.Eday = new Date();
			retVo.Sday = dUtil.Calculate(retVo.Eday, -1);
		} else if (jVo.getDate() == 2) {
			retVo.Eday = new Date();
			retVo.Sday = dUtil.Calculate(retVo.Eday, -3);
		} else if (jVo.getDate() == 3) {
			retVo.Eday = new Date();
			retVo.Sday = dUtil.Calculate(retVo.Eday, -7);
		} else if (jVo.getDate() == 4) {
			retVo.Eday = new Date();
			retVo.Sday = dUtil.Calculate(retVo.Eday, -30);
		} else if (jVo.getDate() == 0) {
			retVo.Eday = null;
			retVo.Sday = null;
		}
		if (jVo.getEdu() == null || jVo.getEdu() == 1) {
			retVo.setEdu(null);
		} else {
			retVo.edu = jVo.edu;
		}
		if (jVo.getField() == null || jVo.getField() == 0) {
			retVo.setField(null);
		} else {
			retVo.edu = jVo.edu;
		}
		/*if (jVo.getJobname() == null || "".equals(jVo.getJobname())) {
			retVo.setJobname(null);
		} else {
			retVo.jobname = jVo.jobname;
		}*/
		if(jVo.getJobname() == "" ){
			retVo.setJobname(null);
		}else{
			retVo.jobname = jVo.jobname;
		}
		if (jVo.getJobProp() == null) {
			if(retVo.jobProp==null){
				
			}else{
				
			}
		
		}else{
			retVo.jobProp=jVo.jobProp;
		}
		if (jVo.getStage() == null || jVo.getStage() == 0) {
			retVo.setStage(null);
		} else {
			retVo.stage = jVo.stage;
		}
		if(jVo.getWorkEXP() == null){
			
		}else{
			if(jVo.workEXP==1){
				retVo.setWorkEXP(null);
			}else{
				retVo.workEXP = jVo.workEXP;
			}
		}
		if (jVo.getSal() != null) {
			switch (jVo.getSal()) {
			case 1:
				retVo.setSala(new com.lagou.domain.Sal(0, 2000));
				break;
			case 2:
				retVo.setSala(new com.lagou.domain.Sal(2000, 5000));
				break;
			case 3:
				retVo.setSala(new com.lagou.domain.Sal(5000, 10000));
				break;
			case 4:
				retVo.setSala(new com.lagou.domain.Sal(10000, 15000));
				break;
			case 5:
				retVo.setSala(new com.lagou.domain.Sal(15000, 25000));
				break;
			case 6:
				retVo.setSala(new com.lagou.domain.Sal(25000, 50000));
				break;
			case 7:
				retVo.setSala(new com.lagou.domain.Sal(50000, 200000));
				break;
			default:
				break;
			}
		} else if (jVo.getSal() == null && retVo.getSala() == null) {
			retVo.setSala(new com.lagou.domain.Sal(0, 200000));
		}

		return retVo;
	}
	public JobSearchVO change(JobSearchVO jVo) {
		if (jVo.getCity() == "全国"||jVo.getCity()== null||"".equals(jVo.getCity())) {
			jVo.setCity(null);
		}
		if(jVo.getDate() == null){
			
		}else if (jVo.getDate() == 1) {
			jVo.Eday = new Date();
			jVo.Sday =dUtil.Calculate(jVo.Eday, -1);
		}
		else if(jVo.getDate() == 2){
			jVo.Eday = new Date();
			jVo.Sday =dUtil.Calculate(jVo.Eday, -3);
		}
		else if(jVo.getDate() == 3){
			jVo.Eday = new Date();
			jVo.Sday =dUtil.Calculate(jVo.Eday, -7);
		}
		else if(jVo.getDate() == 4){
			jVo.Eday = new Date();
			jVo.Sday =dUtil.Calculate(jVo.Eday, -30);
		}
		else if(jVo.getDate() == 0){
			jVo.Eday = null;
			jVo.Sday = null;
		}
		if (jVo.getEdu() == null||jVo.getEdu() == 1) {
			jVo.setEdu(null);
		}
		if (jVo.getField() == null||jVo.getField()==0) {
			jVo.setField(null);
		}
		if (jVo.getJobname() == null||"".equals(jVo.getJobname())) {
			jVo.setJobname(null);
		}
		if (jVo.getJobProp() == null||jVo.getJobProp()==0) {
			jVo.setJobProp(null);
		}
		if (jVo.getStage() == null||jVo.getStage()==0) {
			jVo.setStage(null);
		}
		if (jVo.getWorkEXP() == null||jVo.getWorkEXP()==1) {
			jVo.setWorkEXP(null);
		}
		if(jVo.getSal()!=null){
		switch (jVo.getSal()) {
		case 1:
			jVo.setSala(new com.lagou.domain.Sal(0,2000));
			break;
		case 2:
			jVo.setSala(new com.lagou.domain.Sal(2000,5000));
			break;
		case 3:
			jVo.setSala(new com.lagou.domain.Sal(5000,10000));
			break;
		case 4:
			jVo.setSala(new com.lagou.domain.Sal(10000,15000));
			break;
		case 5:
			jVo.setSala(new com.lagou.domain.Sal(15000,25000));
			break;
		case 6:
			jVo.setSala(new com.lagou.domain.Sal(25000,50000));
			break;
		case 7:
			jVo.setSala(new com.lagou.domain.Sal(50000,200000));
			break;
		default:
			break;
		}}else{
			jVo.setSala(new com.lagou.domain.Sal(0,200000));
		}

		return jVo;
	}
	
	public Integer getJobId() {
		return jobId;
	}
	
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public JakerDateUtil getdUtil() {
		return dUtil;
	}
	public void setdUtil(JakerDateUtil dUtil) {
		this.dUtil = dUtil;
	}
	public com.lagou.domain.Sal getSala() {
		return sala;
	}
	public void setSala(com.lagou.domain.Sal sala) {
		this.sala = sala;
	}
	public Date getSday() {
		return Sday;
	}
	public void setSday(Date sday) {
		Sday = sday;
	}
	public Date getEday() {
		return Eday;
	}
	public void setEday(Date eday) {
		Eday = eday;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
	public Integer getStage() {
		return stage;
	}
	public void setStage(Integer stage) {
		this.stage = stage;
	}
	public Integer getField() {
		return field;
	}
	public void setField(Integer field) {
		this.field = field;
	}
	public Integer getEdu() {
		return edu;
	}
	public void setEdu(Integer edu) {
		this.edu = edu;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public JobSearchVO() {
		super();
	}
	public Integer getSal() {
		return Sal;
	}
	public void setSal(Integer sal) {
		Sal = sal;
	}
	public Integer getWorkEXP() {
		return workEXP;
	}
	public void setWorkEXP(Integer workEXP) {
		this.workEXP = workEXP;
	}
	public Integer getJobProp() {
		return jobProp;
	}
	public void setJobProp(Integer jobProp) {
		this.jobProp = jobProp;
	}
	public Integer getDate() {
		return Date;
	}
	public void setDate(Integer date) {
		Date = date;
	}
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
