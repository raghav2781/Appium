package ProjectUtility;

import org.apache.log4j.Logger;

import stepDefination.Definations;

public class Log4J {
	public static Logger logger = Logger.getLogger(Definations.class);
	
	public  void logInfo(String info){
		logger.info(info);
	}
	public void logError(String errorInfo){
		logger.error(errorInfo);
	}
	public void logFatal(String fatalInfo){
		logger.fatal(fatalInfo);
	}
	
	

}
