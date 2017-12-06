package com.lagou.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.biz.UserinfoBIZ;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Userinfo;
import com.lagou.exception.NameExistException;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.utils.MD5_Encoding;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("CompanyAndUserAction")
@ParentPackage("struts-default")
@Scope("prototype")
@Namespace("/commonJsp")
public class CompanyAndUserAction extends ActionSupport {
	@Autowired@Qualifier("CompanyinfoBIZImp")
	private CompanyinfoBIZ companyinfoBIZ;
    @Autowired@Qualifier("UserinfoBIZImp")
    private UserinfoBIZ userinfoBIZ;
//	private Companyinfo companyinfo;
//	private Userinfo userinfo;
	private String email;
	private String password;
	private String type;
	public void validatereg(){
		if("0".equals(type)){
			System.out.println("validateuserreg");
			ActionContext context = ActionContext.getContext();
			Map<String,Object> req_map = (Map<String, Object>) context.get("request");
			Userinfo user=userinfoBIZ.findByUserName(email);
			if (user!=null) {
				req_map.put("usernameError", "用户名已存在，请用户重新输入");
				this.addFieldError("usernameError", "用户名已存在，请用户重新输入");
				return;
			}
		}else{
			System.out.println("validatecompanyreg");
			ActionContext context = ActionContext.getContext();
			Map<String,Object> req_map = (Map<String, Object>) context.get("request");
			Companyinfo company=companyinfoBIZ.findByUserName(email);
			if (company!=null) {
				req_map.put("usernameError", "用户名已存在，请用户重新输入");
				this.addFieldError("usernameError", "用户名已存在，请用户重新输入");
				System.out.println();
				return;
			}
		}
	}
	@Action(value = "reg", results = {
			@Result(type = "redirect", location = "/commonJsp/login.jsp"),
			@Result(name = "error", location = "/commonJsp/register.jsp"),
			@Result(name = "input", location = "/commonJsp/register.jsp") })
	public String reg(){
		if("0".equals(type)){
			ActionContext actionContext = ActionContext.getContext();
			Map<String,Object> req_map = (Map<String, Object>) actionContext.get("request");
			Map<String, Object> sess_map = actionContext.getSession();
			Userinfo userinfo=new Userinfo();
			MD5_Encoding md5 = new MD5_Encoding();
			userinfo.setUserinfoEmail(email);
			userinfo.setUserinfoPassword(md5.getMD5ofStr(password));
			try {
//				sess_map.remove("usernameExist");
				req_map.remove("usernameExist");
				userinfoBIZ.reg(userinfo);
				return ActionSupport.SUCCESS;
			} catch (NameExistException e) {
				req_map.put("usernameExist", e.getMessage());
				e.printStackTrace();
				return ActionSupport.ERROR;
			}
		}else {
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> sess_map = actionContext.getSession();
			Map<String,Object> req_map = (Map<String, Object>) actionContext.get("request");
			Companyinfo companyinfo=new Companyinfo();
			MD5_Encoding md5 = new MD5_Encoding();
			companyinfo.setCompanyLogname(email);
			companyinfo.setCompanyPassword(md5.getMD5ofStr(password));
			try {
				req_map.remove("usernameExist");
				companyinfoBIZ.reg(companyinfo);
				return ActionSupport.SUCCESS;
			} catch (NameExistException e) {
				req_map.put("usernameExist", e.getMessage());
				e.printStackTrace();
				return ActionSupport.ERROR;
			}
		}
	}
	
	@Action(value="login",results={
			@Result(name="success1",location="/index.jsp",type="redirect"),
			@Result(name="success2",location="/index.jsp",type="redirect"),
			@Result(name="none",location="/commonJsp/login.jsp")
	})
	public  String Login(){
		try {//周航这里加入了登录的用户类型
			if (type.equals("0")) {
				Userinfo userinfo=companyinfoBIZ.userlogin(email, password);
				System.out.println(userinfo.getUserinfoUsername());
				ActionContext actionContext=ActionContext.getContext();
				Map<String , Object> sesMap=(Map<String, Object>) actionContext.getSession();
				sesMap.clear();
				sesMap.put("userinfo", userinfo);
				return "success1";

			}
			else{
			Companyinfo companyinfo=companyinfoBIZ.companylogin(email, password);
			System.out.println(companyinfo.getCompanyLogname());
			ActionContext actionContext=ActionContext.getContext();
			Map<String , Object> sesMap=(Map<String, Object>) actionContext.getSession();
			sesMap.clear();
			sesMap.put("companyinfo", companyinfo);
			return "success2";
			}
		} catch (NameMissException e) {
			Map<String , Object> reqMap1=(Map<String, Object>) ActionContext.getContext().get("request");
			reqMap1.put("errorMessage", "用户名不存在");
			e.printStackTrace();
			return "none";
		} catch (PassErrorException e) {
			Map<String , Object> reqMap2=(Map<String, Object>) ActionContext.getContext().get("request");
			reqMap2.put("errorMessage", "密码错误");
			e.printStackTrace();
			return "none";
		}
	}
		
	public CompanyinfoBIZ getCompanyinfoBIZ() {
		return companyinfoBIZ;
	}
	public void setCompanyinfoBIZ(CompanyinfoBIZ companyinfoBIZ) {
		this.companyinfoBIZ = companyinfoBIZ;
	}
	public UserinfoBIZ getUserinfoBIZ() {
		return userinfoBIZ;
	}
	public void setUserinfoBIZ(UserinfoBIZ userinfoBIZ) {
		this.userinfoBIZ = userinfoBIZ;
	}
//	public Companyinfo getCompanyinfo() {
//		return companyinfo;
//	}
//	public void setCompanyinfo(Companyinfo companyinfo) {
//		this.companyinfo = companyinfo;
//	}
//	public Userinfo getUserinfo() {
//		return userinfo;
//	}
//	public void setUserinfo(Userinfo userinfo) {
//		this.userinfo = userinfo;
//	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}
  