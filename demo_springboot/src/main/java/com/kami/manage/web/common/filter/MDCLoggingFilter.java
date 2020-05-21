package com.kami.manage.web.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.MDC;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nextserve.web.spring.security.auth.LoginAuthUser;

/**
 * Logback: MDC に情報をつめるフィルター
 * @author FSI
 */
public class MDCLoggingFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.context = config.getServletContext();
	}

	/**
	 * フィルター処理
	 * @param  request   ServletRequest
	 * @param  response  ServletResponse
	 * @param  chain     FilterChain
	 * @throw IOException      何らかのエラー
	 * @throw ServletException 何らかのエラー
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LoginAuthUser loginAuthUser = (LoginAuthUser) WebApplicationContextUtils
				.getWebApplicationContext(context).getBean("loginAuthUser");

		UserDetails user = loginAuthUser.getUserDetails();
		MDC.put("loginId", (user != null) ? user.getUsername() : null);

		HttpServletRequest httpreq = (HttpServletRequest)request;
		HttpSession session = httpreq.getSession(false);
		MDC.put("sid", (session != null) ? session.getId() : null);
		chain.doFilter(request, response);
		MDC.remove("sid");
	}
}
