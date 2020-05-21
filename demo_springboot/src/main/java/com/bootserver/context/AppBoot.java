package com.bootserver.context;

import java.util.Properties;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.SpringProperties;
import org.springframework.core.env.Environment;

import com.nextserve.core.util.SpringFrameworkHelper;

/**
 * Spring Boot 启动项
 * @author kami
 */
@SpringBootApplication
@PropertySource("classpath:spring/spring-boot.properties")
@ComponentScan({ "com.bootserver", "com.kami" })
@ImportResource({ "classpath:/**/*.context.xml" })
@ServletComponentScan({ "com.kami" })
public class AppBoot extends SpringBootServletInitializer{
	@Autowired
	private Environment env;

	@Autowired
	private TomcatServer tomcatServer;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppBoot.class);
		app.setWebApplicationType(WebApplicationType.SERVLET);
		app.run(args);
	}
	
	/**
	 * Tomcat Embedded Server Factory （只启动应用程序）
	 * @return TomcatServletWebServerFactory
	 */
	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
		if (StringUtils.equals(env.getProperty("spring.boot.on-tomcat", "false"), "true")) {
			return null;
		}
		return tomcatServer.setup(new TomcatServletWebServerFactory());
	}
	
	/**
	 * WAR デプロイ時の Spring Boot アプリ起動部
	 * @param  application  アプリケーション
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Properties p = SpringFrameworkHelper.loadFromPropertySource(this.getClass());
		p.setProperty("spring.boot.on-tomcat", "true");

		p.entrySet().forEach(e -> {
			SpringProperties.setProperty(ObjectUtils.toString(e.getKey()), ObjectUtils.toString(e.getValue()));
		});

		return application.sources(AppBoot.class)
				.properties(p);
	}
}
