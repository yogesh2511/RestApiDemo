package basic.testcase;

import org.testng.annotations.Test;

import utility.RestLogger;

public class SampleLogGenerator {

	@Test
	public void Test1() 
		{

		 // Logging informational messages
        RestLogger.info(SampleLogGenerator.class,"This is an INFO level log message.");

        // Logging warning messages
        RestLogger.warn(SampleLogGenerator.class,"This is a WARN level log message.");

        // Logging error messages
        RestLogger.error(SampleLogGenerator.class,"This is an ERROR level log message.");

        // Logging fatal messages
        RestLogger.fatal(SampleLogGenerator.class,"This is a FATAL level log message.");
		
	}
	
}
