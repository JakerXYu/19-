package com.lagou.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.enterprise.inject.New;

public class JakerTransJsonFormUtil {
	public static Map<String, String> transformMap(Map<String, String[]>sMap){
		Set<String>kSet=sMap.keySet();
		Map<String, String>result=new HashMap<String, String>();
		for (String string : kSet) {
			for (String s : sMap.get(string)) {
				result.put(string, s);
			}
		}
		return result;
	}
	public String getInteger(String param){
		if(param.equals("大专")){
			return "1";
		}
		if(param.equals("本科")){
			return "2";
		}
		if(param.equals("硕士")){
			return "3";
		}
		if(param.equals("博士")){
			return "4";
		}
		if(param.equals("其他")){
			return "5";
		}
		if(param.equals("应届毕业生")){
			return "0";
		}
		if(param.endsWith("年")){
			return param.replace("年", "");
		}
		if(param.equals("全职")){
			return "1";
		}
		if(param.equals("兼职")){
			return "2";
		}
		if(param.equals("实习")){
			return "3";
		}
		
		if(param.equals("2k以下")){
			return "1";
		}
		if(param.equals("2k-5k")){
			return "2";
		}
		if(param.equals("5k-10k")){
			return "3";
		}
		if(param.equals("10k-15k")){
			return "4";
		}
		if(param.equals("15k-25k")){
			return "5";
		}
		if(param.equals("25k-50k")){
			return "6";
		}
		if(param.equals("50k以上")){
			return "7";
		}		
		return null;
	}
	
	public String GetDate(String param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Timestamp date = new Timestamp(0L);
		try {
			if(param.equals("至今")){
				param=sdf.format(new Date());
			}
			 date = new Timestamp(sdf.parse(param).getTime());
		} catch (Exception e) {
			System.out.println("日期转换错误");
		}
		return date.toString();
	}
	public String GetDate(String yyy,String mm){
		Timestamp date = new Timestamp(0L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		try {
			if(yyy.equals("至今")&&mm.equals("至今")){
				return sdf.format(new Date());
			}else{
			 date = new Timestamp(sdf.parse(yyy+mm).getTime());
			}
		} catch (Exception e) {
			System.out.println("日期转换错误");
		}
		return date.toString();
	}
	
}
