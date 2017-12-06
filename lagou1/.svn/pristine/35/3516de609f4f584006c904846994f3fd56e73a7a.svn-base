package com.lagou.utils;
/**
 * 通过用户在页面自己输入的工作经验比如2年得到在Jobex表中对应的工作经验段对应的Id值,2年属于1-3年,所以JobexId=4
 * @author Oracle
 *
 */
public  class GetJobexId {
	/**
	 * 
	 * @param jobexofUserJobex 用户在页面自己输入的工作经验
	 * @return 在Jobex表中对应的工作经验段对应的Id值
	 */
	public static int getJobexId(Integer jobexofUserJobex){
		if(jobexofUserJobex==null){
			return 8;
		}
		if(jobexofUserJobex==0){
			return 2;
		}
		if(jobexofUserJobex<=1&&jobexofUserJobex>0){
			return 3;
		}
		if(jobexofUserJobex<=3&&jobexofUserJobex>1){
			return 4;
		}
		if(jobexofUserJobex<=5&&jobexofUserJobex>3){
			return 5;
		}
		if(jobexofUserJobex<=10&&jobexofUserJobex>5){
			return 6;
		}
		if(jobexofUserJobex>10){
			return 7;
		}
		return 0;
	}

}
