package com.lagou.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.AdminsBIZ;
import com.lagou.bizImp.AdminsBIZImp;
import com.lagou.domain.Admins;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.utils.MD5_Encoding;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("AdminsAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/manager")
public class AdminsAction extends ActionSupport{
	@Autowired@Qualifier("AdminsBIZImp")
	private AdminsBIZ adminsBIZ;
	
	private Admins admins;
	private String username;
	private String password;
	private int adminId;
	private int level;
	/**
	 * 杨四龙
	 * 查找管理员
	 * @return
	 */
	@Action(value="findall",results={
			@Result(location="/manager/role/show.jsp")
	})
	public String findAll(){
		List<Admins> adminsList=this.adminsBIZ.findAll();
		ActionContext context=ActionContext.getContext();
		Map<String, Object> map_re=(Map<String, Object>) context.get("request");
		map_re.put("adminsList", adminsList);
		return ActionSupport.SUCCESS;
	
	}
	
	/**
	 * 杨四龙
	 * 登录管理员
	 * @return
	 */
	@Action(value = "isLogin", results = {
			@Result(name="success",type="redirect",location = "/manager/main.jsp"),
			@Result(name = "error", location = "/adminlogin.jsp"),
			@Result(name = "input", location = "/adminlogin.jsp") })
	public String isLogin(){
		try {
			Admins admin=adminsBIZ.isLogin(username, password);
			ActionContext context=ActionContext.getContext();
			Map<String, Object> sess_map = context.getSession();
			sess_map.put("admin",admin);
			return ActionSupport.SUCCESS;
		} catch (NameMissException e) {
			e.printStackTrace();
			return ActionSupport.INPUT;
		} catch (PassErrorException e) {
			e.printStackTrace();
			return ActionSupport.INPUT;
		}catch(Exception e){
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
	}
	
	@Action(value = "save", results = {
			@Result(name="success",type="redirectAction",params={"actionName","findAll"}),
			@Result(name = "error",type="dispatcher",location = "/manager/role/save.jsp"),
			@Result(name = "input",type="dispatcher", location = "/manager/role/save.jsp") })
	private String save(){
		
		return ActionSupport.SUCCESS;
		
	}
	
	@Action(value = "delete", results = {
			@Result(name="success",type="redirect",location = "/manager/main.jsp"),
			@Result(name = "error", location = "/adminlogin.jsp"),
			@Result(name = "input", location = "/adminlogin.jsp") })
	private String delete(){
		
		return ActionSupport.SUCCESS;
		
	}
	
	
	

	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	public Admins getAdmins() {
		return admins;
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}


	public AdminsBIZ getAdminsBIZ() {
		return adminsBIZ;
	}


	public void setAdminsBIZ(AdminsBIZ adminsBIZ) {
		this.adminsBIZ = adminsBIZ;
	}


	
	
}
