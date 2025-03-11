package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestLogger {

	private static final Logger logger = LogManager.getLogger(RestLogger.class);
    
	
	public static void info(String message) {
		logger.info(message);
    }

    public static void debug(String message) {
    	logger.debug(message);
    }

    public static void warn(String message) {
    	logger.warn(message);
    }

    public static void error(String message) {
    	logger.error(message);
    }

    public static void error(String message, Throwable throwable) {
    	logger.error(message, throwable);
    }

    public static void fatal(String message) {
    	logger.fatal(message);
    }

	
	/*
	 * public static Logger getLogger(Class<?> clazz) { return
	 * LogManager.getLogger(clazz); }
	 * 
	 * public static void info(Class<?> clazz, String message) {
	 * getLogger(clazz).info(message); }
	 * 
	 * public static void debug(Class<?> clazz, String message) {
	 * getLogger(clazz).debug(message); }
	 * 
	 * public static void warn(Class<?> clazz, String message) {
	 * getLogger(clazz).warn(message); }
	 * 
	 * public static void error(Class<?> clazz, String message) {
	 * getLogger(clazz).error(message); }
	 * 
	 * public static void error(Class<?> clazz, String message, Throwable throwable)
	 * { getLogger(clazz).error(message, throwable); }
	 * 
	 * public static void fatal(Class<?> clazz, String message) {
	 * getLogger(clazz).fatal(message); }
	 */
}
