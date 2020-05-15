package aaa;

import org.apache.log4j.Logger;
import org.apache.log4j.Level;


public class logMain {
//	private static final Logger LOGGER = LogManager.getLogger(logMain.class);
	
//	private static final Logger LOGGER1 = LogManager.getLogger("com.example.my.app");
	
	private static final Logger LOGGER = Logger.getLogger(logMain.class);
	
	private static final Logger LOGGER1 = Logger.getLogger("com.example.my.app");
	public static void main(String[] args) {
		LOGGER.log(Level.ALL, "log ALL : HelloWorld");//制定Level类型的调用
		LOGGER.debug("debug:HelloWorld");
		LOGGER.info("info:HelloWorld");
		LOGGER.warn("warn:HelloWorld");
		LOGGER.error("error:HelloWorld");
		LOGGER.fatal("fatal:HelloWorld");
		LOGGER.log(Level.OFF, "log OFF : HelloWorld");//制定Level类型的调用
		
		
		
		LOGGER1.debug("debug2222:HelloWorld");
		LOGGER1.error("error2222:HelloWorld");

	}
}
