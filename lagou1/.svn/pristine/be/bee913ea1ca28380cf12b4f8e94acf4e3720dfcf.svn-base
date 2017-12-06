package com.lagou.bizImp;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.lagou.biz.AuditionEmailBIZ;
import com.lagou.domain.Auditioninfo;
import com.lagou.domain.Companyinfo;
import com.lagou.domain.Jobdeliver;
import com.lagou.utils.EMailUtils;

public class AuditionEmailBIZImp implements AuditionEmailBIZ {
	private EMailUtils em = new EMailUtils();

	@Override
	public boolean SendEMail(Jobdeliver dels, Auditioninfo au, Companyinfo c) {
		String cEmail=c.getCompanyLogname();
		String comName=c.getCompanyName();
		try {
		this.em.setFrom(cEmail);
		this.em.setNick(comName);
		StringBuffer inner = new StringBuffer("亲爱的");
		inner.append(dels.getResumeinfo().getUserinfo().getUserinfoUsername());
		inner.append("您好,请您于");
		new SimpleDateFormat("yyyy年MM月dd日 HH时mm分").format(au.getAuditionTime());
		inner.append("到"+au.getAuditionAddress());
		inner.append("参加"+comName+"公司"+dels.getJobinfo().getJobName());
		inner.append("职位的面试。");
		inner.append(au.getAuditionDescribe());
		inner.append("。谢谢。");
		this.em.sendMail(dels.getResumeinfo().getUserinfo().getUserinfoEmail(), comName+"公司面试通知",
					inner.toString(), null);
			return true;
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

}
