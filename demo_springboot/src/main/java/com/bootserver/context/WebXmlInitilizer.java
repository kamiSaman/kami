package com.bootserver.context;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContextListener;

import org.apache.velocity.tools.view.VelocityViewServlet;
import org.jboss.resteasy.plugins.server.servlet.FilterDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;

import com.kami.manage.web.common.filter.MDCLoggingFilter;
import com.kami.manage.web.common.filter.PasswordExpirationCheckFilter;
import com.paypal.springboot.resteasy.ResteasyAutoConfiguration;

/**
 * web.xml
 * @author FSI
 */
@Configuration
public class WebXmlInitilizer {

	/**
	 * Spring Framework: RequestContextListener
	 * @return RequestContextListener
	 */
	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}

	/**
	 * MDC Logging Filter
	 * @return MDCLoggingFilter
	 */
	@Bean
	public FilterRegistrationBean<MDCLoggingFilter> mdcLoggingFilter() {
		FilterRegistrationBean<MDCLoggingFilter> factory = new FilterRegistrationBean<>(new MDCLoggingFilter());
		factory.addUrlPatterns("/*");
		return factory;
	}

	/**
	 * Password Expiration Check Filter
	 * @return PasswordExpirationCheckFilter
	 */
	@Bean
	public FilterRegistrationBean<PasswordExpirationCheckFilter> passwordExpirationCheckFilter() {
		FilterRegistrationBean<PasswordExpirationCheckFilter> factory = new FilterRegistrationBean<>(new PasswordExpirationCheckFilter());
		factory.addUrlPatterns("/purchase-info-list/*");
		factory.addUrlPatterns("/account-list/*");
		factory.addUrlPatterns("/account-regist/*");
		factory.addUrlPatterns("/account-change/*");
		return factory;
	}

	/**
	 * Spring Security Filter
	 * @return DelegatingFilterProxyRegistrationBean
	 */
	@Bean
	public DelegatingFilterProxyRegistrationBean delegatingFilterProxy() {
		DelegatingFilterProxyRegistrationBean factory = new DelegatingFilterProxyRegistrationBean(AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME);
		factory.addUrlPatterns("/*");
		return factory;
	}

	@Bean
	@Qualifier("ResteasyProviderFactory")
	public static BeanFactoryPostProcessor springBeanProcessor() {
		return ResteasyAutoConfiguration.springBeanProcessor();
	}

	/**
	 * This is a modified version of {@link ResteasyBootstrap}
	 *
	 * @return a ServletContextListener object that configures and start a
	 *         ResteasyDeployment
	 */
	@Bean
	public ServletContextListener resteasyBootstrapListener(@Qualifier("ResteasyProviderFactory") final BeanFactoryPostProcessor beanFactoryPostProcessor) {
		return new ResteasyAutoConfiguration().resteasyBootstrapListener(beanFactoryPostProcessor);
	}

	@Bean
	public FilterRegistrationBean<FilterDispatcher> filterDispatcher() {
		Map<String, String> initParams = new ConcurrentHashMap<>();
		initParams.put("javax.ws.rs.Application", JaxrsApplication.class.getCanonicalName());

		FilterRegistrationBean<FilterDispatcher> factory = new FilterRegistrationBean<>(new FilterDispatcher());
		factory.setInitParameters(initParams);
		factory.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return factory;
	}
	/**
	 * Velocity View Servlet
	 * @return VelocityViewServlet
	 */
	@Bean
	public ServletRegistrationBean<VelocityViewServlet> velocityViewServlet() {
		ServletRegistrationBean<VelocityViewServlet> factory = new ServletRegistrationBean<>(new VelocityViewServlet());
		factory.addInitParameter("org.apache.velocity.tools", "/conf/velocity/velocity-toolbox.xml");
		factory.addInitParameter("org.apache.velocity.properties", "/conf/velocity/velocity.properties");
		factory.setLoadOnStartup(500);
		factory.addUrlMappings("*.vm");
		return factory;
	}
}
