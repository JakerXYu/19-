package com.lagou.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("ExitAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/jobSeeker")
public class ExitAction extends ActionSupport {

	@Action(value="exit",results={
			@Result(name="success",type="redirect",location="/index.jsp")
	})
	public String exit(){
		ActionContext context=ActionContext.getContext();
		Map<String, Object> map_sess=context.getSession();
		map_sess.clear();
		return ActionSupport.SUCCESS;
	
	}
}
