package com.lagou.action;

import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.domain.Userinfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//ajax例子
@Controller("AjaxTestAction")
@ParentPackage("json-default")//注意这里是json-default而不是struts-default
@Scope("prototype")
@Namespace("/ajax")//namespace随便取，自己认识就行
public class AjaxTestAction {
	Object jsonText;//返回给页面的数据，一般定义成String就行了
	
	String name;//ajax传过来的参数
	Integer pass;//ajax传过来的参数
	
	//Action中需要改的就是value 和success 以及jsonText
	//value 和success就不多说了  jsonText就是上面定义的那个Object用于返回数据给
	@Action(value = "showuser", results = { @Result(name = "success", type = "json", params = {
			"root", "jsonText" }) }, interceptorRefs = {
			@InterceptorRef("defaultStack"), @InterceptorRef("json") })
	public String showuser() {
		ActionContext context = ActionContext.getContext();
		Map<String, Object> ses_map = (Map<String, Object>) context.getSession();
		Userinfo userinfo=(Userinfo) ses_map.get("userinfo");
		/*this.jsonText=userinfo.getUserinfoEmail();*/
		this.jsonText=jsonToHtml(userinfo);
		System.out.println("name-----------------"+name);
		System.out.println("pass-----------------"+pass);
		return ActionSupport.SUCCESS;
		

/*		Userinfo userinfo2=new Userinfo();
		userinfo2=userinfo;
		JSONObject jsonObject=JSONObject.fromObject(userinfo2);
		System.out.println(jsonObject.toString());*/
		/*System.out.println("userinfo"+userinfo.getUserinfoEmail());*/
		/*JSONObject jsonObject=JSONObject.fromObject(userinfo);
		jsonText=(JSONObject)jsonObject;*/
		/*System.out.println(jsonText.toString());*/
		/*this.jsonText="hahaha";*/
	}
	
	public String jsonToHtml(Userinfo userinfo){
		if(userinfo!=null){
			return "<a href="+"\"/lagou1/index.jsp"+"\""+">"+userinfo.getUserinfoEmail()+"</a>";
		}
		else{
			return "<span>haha</span>";
		}
	}


	public Object getJsonText() {
		return jsonText;
	}




	public void setJsonText(Object jsonText) {
		this.jsonText = jsonText;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getPass() {
		return pass;
	}


	public void setPass(Integer pass) {
		this.pass = pass;
	}
	
}
