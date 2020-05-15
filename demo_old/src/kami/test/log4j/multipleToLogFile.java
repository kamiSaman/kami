package kami.test.log4j;

import org.apache.log4j.Logger;

public class multipleToLogFile {
	
	private static Logger logger = Logger.getLogger(multipleToLogFile.class);
	
	public static void main(String[] args) {
		logger.debug("多个文件：first**********************************************");
		logger.info("多个文件：first**********************************************");
		logger.error("多个文件：first**********************************************");
		logger.fatal("多个文件：first**********************************************");
		logger.debug("多个文件：first**********************************************");

	}
}
