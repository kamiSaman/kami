package com.bootserver.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.nextserve.web.jaxrs.MessageBodyJsonProvider;
import com.nextserve.web.jaxrs.ThymeleafRenderer;
import com.nextserve.web.jaxrs.ThymeleafTemplateContext;
import com.nextserve.web.spring.security.auth.LoginAuthUser;
import com.nextserve.web.util.SessionManager;

/**
 * 追加の application-base.context.xml 定義
 * @author FSI
 */
@Configuration
public class ApplicationContext {
	/**
	 * Spring Security: 認証ユーザー（セッション保持用）
	 * @return LoginAuthUser
	 */
	@Bean
	@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public LoginAuthUser loginAuthUser() {
		return new LoginAuthUser();
	}

	/**
	 * セッションマネージャ
	 * @return SessionManager
	 */
	@Bean
	@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionManager sessionManager() {
		return new SessionManager();
	}

	/**
	 * Thymeleaf プロセッサー
	 * @return ThymeleafRenderer
	 */
	@Bean
	public ThymeleafRenderer thymeleafRenderer() {
		return new ThymeleafRenderer();
	}

	/**
	 * Thymeleaf テンプレートコンテキスト
	 * @return ThymeleafTemplateContext
	 */
	@Bean
	@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ThymeleafTemplateContext thymeleafTemplateContext(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		ThymeleafTemplateContext thymeleafTemplateContext = new ThymeleafTemplateContext();
		thymeleafTemplateContext.init(request, response);
		return thymeleafTemplateContext;
	}

	/**
	 * 拡張 JSON プロバイダ
	 * @return MessageBodyJsonProvider
	 */
	@Bean
	public MessageBodyJsonProvider messageBodyJsonProvider() {
		return new MessageBodyJsonProvider();
	}
}