package com.lagou.utils;

import java.text.SimpleDateFormat;
import java.util.List;

import com.lagou.domain.Jobinfo;

public class JakerListToHTMLUtil {
public static StringBuffer change(List<Jobinfo> list){
	if(list.size()==0){
		return new StringBuffer("<li>对不起没有符合条件的职位信息!<*li>");
	}
	StringBuffer result = new StringBuffer();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 ");
	for (Jobinfo jobinfo : list) {
		String string="<li class='clearfix'>"
		+ "<div class='hot_pos_l'>"
		+ "<div class='mb10'>"
		+ "<a href='jobinfo*findbyid.action?jobId="+jobinfo.getJobId()+"' target='_blank'>"+jobinfo.getJobName()+"<*a>"
		+ "&nbsp;<span class='c9'>["+jobinfo.getJobCity()+"]<*span><*div>"
		+ "<span><em class='c7'>月薪： <*em>"+(jobinfo.getJobLowsal()/1000)+"k-"+(jobinfo.getJobHighsal()/1000)+"k<*span>"
		+ "<span><em class='c7'>经验：<*em>"+jobinfo.getJobexp().getExpName()+"<*span>"
		+ "<span><em class='c7'>最低学历： <*em>"+jobinfo.getJobedu().getEduName()+"<*span><br>"
		+ "<span><em class='c7'>职位诱惑：<*em>"+jobinfo.getJobAdvantage()+"<*span><br> "
		+ "<span>"+sdf.format(jobinfo.getJobStartTime()).toString()+"发布<*span><*div>"
		+ "<div class='hot_pos_r'>"
		+ "<div class='mb10 recompany'>"
		+ "<a href='myhome.jsp' target='_blank'>"+jobinfo.getCompanyinfo().getCompanyName()+"<*a><*div>"
		+ "<span><em class='c7'>领域：<*em>"+jobinfo.getCompanyinfo().getCompanyfield().getFieldName()+"<*span><br>"
		+ "<span><em class='c7'>阶段：<*em>"+jobinfo.getCompanyinfo().getCompanystage().getStageName()+"<*span>"
		+ "<span><em class='c7'>规模：<*em>"+jobinfo.getCompanyinfo().getCompanysize().getSizeName()+"<*span>"
		+ "<*div><*li>";
result.append(string);
}
return result;
}
public static StringBuffer change2(List<Jobinfo> list){
	if(list.size()==0){
		return new StringBuffer("<li>对不起没有符合条件的职位信息!<*li>");
	}
	StringBuffer result = new StringBuffer();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 ");
	for (Jobinfo jobinfo : list) {
  String string="<li class='clearfix'>"
			+ "<div class='hot_pos_l'>"
			+ "<div class='mb10'>"
			+ "<a href='commonJsp*jobdetail.jsp' target='_blank'>"+jobinfo.getJobName()+"<*a>"
			+ "&nbsp;<span class='c9'>["+jobinfo.getJobCity()+"]<*span><*div>"
			+ "<span><em class='c7'>月薪： <*em>"+(jobinfo.getJobLowsal()/1000)+"k-"+(jobinfo.getJobHighsal()/1000)+"k<*span>"
			+ "<span><em class='c7'>经验：<*em>"+jobinfo.getJobexp().getExpName()+"<*span>"
			+ "<span><em class='c7'>最低学历： <*em>"+jobinfo.getJobedu().getEduName()+"<*span><br>"
			+ "<span><em class='c7'>职位诱惑：<*em>"+jobinfo.getJobAdvantage()+"<*span><br> "
			+ "<span>"+sdf.format(jobinfo.getJobStartTime()).toString()+"发布<*span><*div>"
			+ "<div class='hot_pos_r'>"+"<div class='apply'><a href='"
					+ "toudi.jsp'"
					+ " target='_blank'>投个简历<*a><*div>"
			+ "<div class='mb10 recompany'>"
			+ "<a href='myhome.jsp' target='_blank'>"+jobinfo.getCompanyinfo().getCompanyName()+"<*a><*div>"
			+ "<span><em class='c7'>领域：<*em>"+jobinfo.getCompanyinfo().getCompanyfield().getFieldName()+"<*span><br>"
			+ "<span><em class='c7'>阶段：<*em>"+jobinfo.getCompanyinfo().getCompanystage().getStageName()+"<*span>"
			+ "<span><em class='c7'>规模：<*em>"+jobinfo.getCompanyinfo().getCompanysize().getSizeName()+"<*span>"
			+ "<*div><*li>";result.append(string);
	}
	return result;
}
}
