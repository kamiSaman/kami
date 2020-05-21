package com.bootserver.context;

import java.time.Duration;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Tomcat
 * 
 * @author FSI
 */
@Component
public class TomcatServer {

	@Autowired
	private Environment env;

	@Autowired
	private Logger logger;

	public TomcatServletWebServerFactory setup(TomcatServletWebServerFactory factory) {
		logger.info("Setup Tomcat server.");

		// Context path
		String contextPath = env.getProperty("tomcat.context_path", "/");
		factory.setContextPath(contextPath);

		// LISTEN端口
		Integer port = Integer.valueOf(env.getProperty("tomcat.port", "8089"));
		factory.setPort(port);

		// Session Timeout
		Integer sessionTimeout = Integer.valueOf(env.getProperty("tomcat.session_timeout", "1800"));
		Session session = factory.getSession();
		session.setTimeout(Duration.ofMinutes(sessionTimeout));
		factory.setSession(session);

		factory.getErrorPages().add(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/error401"));
		factory.getErrorPages().add(new ErrorPage(HttpStatus.FORBIDDEN, "/error/error403"));
		factory.getErrorPages().add(new ErrorPage(HttpStatus.NOT_FOUND, "/error/error404"));
		factory.getErrorPages().add(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/error500"));
		factory.getErrorPages().add(new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/error/error503"));
		factory.getErrorPages().add(new ErrorPage(java.lang.Throwable.class, "/error/errorShow"));

		return factory;
	}
}
