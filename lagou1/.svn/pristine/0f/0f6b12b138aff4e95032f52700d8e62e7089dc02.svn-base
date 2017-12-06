package com.lagou.utils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class JakerDecideUtil {
	private JakerTransJsonFormUtil ju = new JakerTransJsonFormUtil();
	public Map<String, String> judge(Map<String,String>paraMap,String uri) throws ParseException{
		Map<String, String>resMap=new HashMap<String, String>();
		if(uri.equals("resume/basic.json")){//基本信息     都是userinfo下的
			resMap.put("mark", "basicInfo.action");
			resMap.put("userinfoEmail", paraMap.get("email"));
			resMap.put("userinfoUsername", paraMap.get("name"));
			resMap.put("userinfoSex",paraMap.get("sex"));
			resMap.put("userinfoEdu",  ju.getInteger(paraMap.get("highestEducation")));
			resMap.put("userinfoExptime",ju.getInteger(paraMap.get("workYear")));
			resMap.put("userinfoPhone", paraMap.get("phone"));
		}
		else if(uri.equals("resume/expect.json")){//期望工作
			resMap.put("mark", "expectJob.action");
			resMap.put("propId", ju.getInteger(paraMap.get("positionType")));//Resumeinfo/expectjob/jobprop/propId
			resMap.put("cityName",paraMap.get("city"));//Resumeinfo/cityinfo/cityName
			resMap.put("expectJobDept",paraMap.get("positionName"));//Resumeinfo/expectjob/expectJobDept
			resMap.put("salId", ju.getInteger(paraMap.get("salarys")));//Resumeinfo/expectjob/sal/salId
		}
		else if(uri.equals("workExperience/save.json")){//工作经历
			resMap.put("mark", "workExperience.action");
			resMap.put("workexpName",paraMap.get("companyName"));//Resumeinfo/userworkexp/workexpName
			resMap.put("workexpJob",paraMap.get("positionName"));//Resumeinfo/userworkexp/workexpJob
			resMap.put("workexpBegintime",ju.GetDate(paraMap.get("startYear"), paraMap.get("startMonth")));//Resumeinfo/userworkexp/workexpBegintime
			resMap.put("workexpEndtime", ju.GetDate(paraMap.get("endYear"), paraMap.get("endMonth")));//Resumeinfo/userworkexp/workexpEndtime
		}
		else if(uri.equals("projectExperience/save.json")){//项目经验
			resMap.put("mark", "projectExp.action");
			resMap.put("itemName", paraMap.get("projectName"));//Resumeinfo/useritemitemName
			resMap.put("itemDuty", paraMap.get("positionName"));//Resumeinfo/useritem/itemDuty
			resMap.put("itemBegtime",paraMap.get("projectRemark"));//Resumeinfo/useritem/itemBegtime
			//此处实体类有异常itemBegtime和itemdescribe类型写反了
			resMap.put("itemDiscrebe",ju.GetDate(paraMap.get("startYear"), paraMap.get("startMonth")));//Resumeinfo/useritem/itemDiscrebe
			resMap.put("itemEndtime", ju.GetDate(paraMap.get("endYear"), paraMap.get("endMonth")));//Resumeinfo/useritem/itemEndtime
		}
		else if(uri.equals("educationExperience/save.json")){//学历
			resMap.put("mark", "userEdu.action");
			resMap.put("eduId", ju.getInteger(paraMap.get("education")));//Resumeinfo/useredu/jobedu/eduid
			resMap.put("eduSchool", paraMap.get("schoolName"));//Resumeinfo/useredu/eduSchool
			resMap.put("eduDep",paraMap.get("professional"));//Resumeinfo/useredu/eduDep
			resMap.put("eduBegintime",ju.GetDate(paraMap.get("startYear")));//Resumeinfo/useredu/eduBegintime
			resMap.put("eduEndtime", ju.GetDate(paraMap.get("endYear")));//Resumeinfo/useredu/eduEndtime
			
		}
		else if(uri.equals("resume/intro.json")){//自我描述
			resMap.put("mark", "resumeDesc.action");
			resMap.put("resumeDesc", paraMap.get("myRemark"));//Resumeinfo/resumeDesc
		}
		else if(uri.equals("workShow/save.json")){//作品展示     暂未实现
			
		}else{
			
		}
		return resMap;
	}
}
