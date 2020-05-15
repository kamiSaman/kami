package kami.test.log4j;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

/**
 * @author 860119012
 *  实现根据不同日志等级进行日志输出功能
 */
public class LogAppender extends DailyRollingFileAppender{
	
	@Override
	public boolean isAsSevereAsThreshold(Priority priority){
		//只判断是否相等，而不判断优先级
		return this.getThreshold().equals(priority);
	}
}
