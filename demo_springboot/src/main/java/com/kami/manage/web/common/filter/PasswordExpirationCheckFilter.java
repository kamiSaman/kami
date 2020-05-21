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
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nextserve.web.spring.security.auth.LoginAuthUser;
import com.nextserve.web.util.HttpRequestUtils;


public class PasswordExpirationCheckFilter implements Filter {

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LoginAuthUser loginAuthUser = (LoginAuthUser) WebApplicationContextUtils
				.getWebApplicationContext(context).getBean("loginAuthUser");

		UserDetails user = loginAuthUser.getUserDetails();

		if (user != null) {
			if (!user.isCredentialsNonExpired()) {
				if (!HttpRequestUtils.isAjaxRequest((HttpServletRequest) request)) {
					((HttpServletResponse) response).sendRedirect(context.getContextPath() + "/password_change");
				}
			}
		}

		chain.doFilter(request, response);
	}

}
