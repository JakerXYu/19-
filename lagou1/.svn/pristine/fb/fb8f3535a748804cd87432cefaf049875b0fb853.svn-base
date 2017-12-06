package com.lagou.filter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.lagou.utils.JakerDecideUtil;
import com.lagou.utils.JakerTransJsonFormUtil;

/**
 * Servlet Filter implementation class JakerJsonFilter
 */
@WebFilter("/JakerJsonFilter")
public class JakerJsonFilter implements Filter {
	private HttpServletRequest request;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		this.request = (HttpServletRequest) request;
		String uri = this.request.getRequestURI().toString().substring(10);// /lagou1/h/resume/basic.json
		System.out.println(uri);
		Map<String, String[]> sMap = request.getParameterMap();
		Map<String, String> paraMap = JakerTransJsonFormUtil.transformMap(sMap);
		System.out.println(sMap);
		System.out.println(paraMap);
		try {
			paraMap = new JakerDecideUtil().judge(paraMap, uri);
			System.out.println(paraMap);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.request.setAttribute("parametersMap", paraMap);
		this.request.getRequestDispatcher(
				this.request.getContextPath() + "/resumeinfo/"
						+ paraMap.get("mark")).forward(this.request, response);
		chain.doFilter(this.request, response);
	}

	public void destroy() {

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
