package kami.test.log4j;

import org.apache.log4j.Logger;

public class TestLog4j {
	private static Logger logger = Logger.getLogger(TestLog4j.class);
	
	public static void main(String[] args) {
		logger.debug("调试debug信息");
        logger.info("普通Info信息");
        logger.warn("警告warn信息");
        logger.error("error信息");       
        logger.fatal("严重错误fatal信息",new IllegalArgumentException("非法参数异常"));
        
        Logs.error("改善日志系统：改变了日志输出工具，只要修改 Logs类即可，其他业务类不必修改");

	}
}
