package basic.testcase;

import org.testng.annotations.Test;

import utility.RestLogger;

public class SampleLogGenerator {

	@Test
	public void Test1() 
		{

		 // Logging informational messages
        RestLogger.info( "This is an INFO level log message.");

        // Logging warning messages
        RestLogger.warn("This is a WARN level log message.");

        // Logging error messages
        RestLogger.error("This is an ERROR level log message.");

        // Logging fatal messages
        RestLogger.fatal("This is a FATAL level log message.");
		
	}
	
}
