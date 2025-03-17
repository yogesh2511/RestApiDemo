package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RestLogger {

    // Retrieve a logger for a specific class
    private static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }

    // Logging methods with class name passed as an argument
    public static void info(Class<?> clazz, String message) {
        getLogger(clazz).info(message);
    }

    public static void debug(Class<?> clazz, String message) {
        getLogger(clazz).debug(message);
    }

    public static void warn(Class<?> clazz, String message) {
        getLogger(clazz).warn(message);
    }

    public static void error(Class<?> clazz, String message) {
        getLogger(clazz).error(message);
    }

    public static void error(Class<?> clazz, String message, Throwable throwable) {
        getLogger(clazz).error(message, throwable);
    }

    public static void fatal(Class<?> clazz, String message) {
        getLogger(clazz).fatal(message);
    }
}
