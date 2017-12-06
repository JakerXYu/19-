package com.lagou.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JakerDateUtil {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 ");
	public String DateToString(Date date) {
		return sdf.format(date).toString();
	}
	
	public Date Calculate(Date day,int add){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(day);
		calendar.set(Calendar.DAY_OF_MONTH, (add));
		Date endDate = calendar.getTime();
		return endDate;
	}

	public JakerDateUtil() {
		super();
	}
	
}
