package com.lagou.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.lagou.biz.CompanyinfoBIZ;
import com.lagou.domain.Companyfield;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Companysize;
import com.lagou.domain.Companystage;
import com.lagou.exception.NameMissException;
import com.lagou.exception.PassErrorException;
import com.lagou.utils.FileNameUtil;
import com.lagou.utils.UUIDUtil;
import com.lagou.vo.CompanySearchVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller("CompanyinfoAction")
@ParentPackage("struts-default")
@Namespace("/companyinfo")
@Scope("prototype")
public class CompanyinfoAction extends ActionSupport {
	
	private String email;
	private String password;
	private String cityId;
	private String stageId;
	private String fieldId;
	private String companyName;
	private String sizeId;
	private String website;
	private File companylogo;
	private String showImgFileName;
	private String showImgContentType;
	private CompanySearchVO searchvo = new CompanySearchVO();;
	@Autowired@Qualifier("CompanyinfoBIZImp")
	private CompanyinfoBIZ companyinfoBIZ;
	
	
	@Action(value="findbysearch", results={
			@Result( name="success", location="/commonJsp/companylist.jsp")
	})
	public String findbysearch(){
		
			searchvo.setAdress(getCityId());
			searchvo.setStage(getStageId());
			searchvo.setField(getFieldId());
			
		
		List<Companyinfo> companylist = companyinfoBIZ.findBySearch(searchvo);
		Map<String,Object> req = (Map<String, Object>) ActionContext.getContext().get("request");
		req.put("companylist", companylist);
	
		return ActionSupport.SUCCESS;
	}
	public CompanyinfoBIZ getCompanyinfoBIZ() {
		return companyinfoBIZ;
	}
	public void setCompanyinfoBIZ(CompanyinfoBIZ companyinfoBIZ) {
		this.companyinfoBIZ = companyinfoBIZ;
	}
	
	@Action(value="login",results={
			@Result(name="success",location="/index.jsp"),
			@Result(name="none",location="commonJsp/login.jsp")
	})
	public  String Login(){
		try {
			Companyinfo companyinfo=companyinfoBIZ.companylogin(email, password);
			System.out.println(companyinfo.getCompanyName());
			ActionContext actionContext=ActionContext.getContext();
			Map<String , Object> sesMap=(Map<String, Object>) actionContext.getSession();
			sesMap.put("companyinfo", companyinfo);
			return "success";
		} catch (NameMissException e) {
			e.printStackTrace();
			return "none";
		} catch (PassErrorException e) {
			e.printStackTrace();
			return "none";
		}
		
	}
	@Action(value = "update", results = {
			@Result(type = "redirect", location = "/HR/companyTag.jsp"),
			@Result(name = "error", location = "/HR/companyBasicInfo.jsp"),
			@Result(name = "input", location = "/HR/companyBasicInfo.jsp") })
	public String update(){
		try {
			Companyinfo companyinfo1 = (Companyinfo) ActionContext.getContext().getSession().get("companyinfo");
			System.out.println(companyinfo1);
//			Map<String,Object> req_map = (Map<String, Object>) actionContext.get("request");
//			Map<String, Object> sess_map = actionContext.getSession();
//			Companyinfo companyinfo1=(Companyinfo) sess_map.get("companyinfo");
			companyinfo1.setCompanyName(companyName);
//			Part goodsImgPart=request.getPart(companylogo);
//			String contentDisposition=goodsImgPart.getHeader("Content-Disposition");
//			String goodsImg=UUIDUtil.getUUID()+FileNameUtil.getTypeName(contentDisposition);
//			String realPath=this.getServletContext().getRealPath("/uploadimg");
			//goodsImgPart.write(realPath+File.separator+goodsImg);
			String realPath = ServletActionContext.getServletContext().getRealPath("/uploadimg");
			if (companylogo != null) {
				File saveDir = new File(realPath);
				if (!saveDir.exists()) {
					saveDir.mkdirs();
				}
				// 创建保存的文件
				showImgFileName = UUIDUtil.getUUID()+FileNameUtil.getTypeName(showImgFileName);
				File saveFile = new File(saveDir, showImgFileName);
				
				// 使用commons-io组件的fileUtils上传文件
				try {
					FileUtils.copyFile(companylogo, saveFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			companyinfo1.setCompanyLogo(showImgFileName);
			companyinfo1.setCompanyIndex(website);
			companyinfo1.setCompanyAddress("cityId");
			Companyfield companyfield=new Companyfield();
			companyfield.setFieldId(Integer.parseInt(fieldId));
			companyinfo1.setCompanyfield(companyfield);
			Companysize companysize=new Companysize();
			companysize.setSizeId(Integer.parseInt(sizeId));
			companyinfo1.setCompanysize(companysize);
			Companystage companystage=new Companystage();
			companystage.setStageId(Integer.parseInt(stageId));
			companyinfo1.setCompanystage(companystage);
		    companyinfoBIZ.update(companyinfo1);
			return ActionSupport.SUCCESS;	
		} catch (Exception e) {
			e.printStackTrace();
			return ActionSupport.ERROR;
		}
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getStageId() {
		return stageId;
	}
	public void setStageId(String stageId) {
		this.stageId = stageId;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSizeId() {
		return sizeId;
	}
	public void setSizeId(String sizeId) {
		this.sizeId = sizeId;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public File getCompanylogo() {
		return companylogo;
	}
	public void setCompanylogo(File companylogo) {
		this.companylogo = companylogo;
	}
	public String getShowImgFileName() {
		return showImgFileName;
	}
	public void setShowImgFileName(String showImgFileName) {
		this.showImgFileName = showImgFileName;
	}
	public String getShowImgContentType() {
		return showImgContentType;
	}
	public void setShowImgContentType(String showImgContentType) {
		this.showImgContentType = showImgContentType;
	}

}
