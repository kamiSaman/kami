package com.bootserver.context;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.stereotype.Component;

/**
 * This is the main class that configures this Resteasy Sring Boot starter
 *
 * @author Fabio Carvalho (facarvalho@paypal.com or fabiocarvalho777@gmail.com)
 */
@Component
@ApplicationPath("/")
public class JaxrsApplication extends Application {
}
