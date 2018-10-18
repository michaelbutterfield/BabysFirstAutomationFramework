package tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

import utilities.TestHelper;

public class TestLogger
{
	private static Writer writer = null;
	private static String testRunDirectory = null;
	private static String logDateTimeFormat = "dd/MM/yy HH:mm:ss";
	private static DateTime suiteRunStart;
	
	private TestLogger()
	{
		
	}
	
	static
	{
		initialise();
	}
	
    public static void close()
    {
    	try 
    	{
			writer.close();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
    	}
    }
	
	private static void createTestRunDirectory()
	{
		testRunDirectory = "C:\\Users\\michael.butterfield\\Desktop" + "\\TestRuns\\TestRun_" + TestHelper.getTodaysDateTime("dd-MM-yy HH.mm");
		
		File directory = new File(testRunDirectory);
		
		if (!directory.exists())
		{
			directory.mkdirs();
		}
	}
	
    public static void createTestStep(String description)
    {
        logEntry(description);
    }

    public static void createTestStep(String action, String element, String page)
    {    	
        String stepDescription = "'%1$s' '%2$s' on page '%3$s'";
        stepDescription = String.format(stepDescription, action, element, page);

        createTestStep(stepDescription);
    }
	
	private static String getTestRunDirectory()
	{
		if (testRunDirectory == null)
		{
			createTestRunDirectory();
		}
		
		return testRunDirectory;
	}
	
    private static String getThrowableStackTrace(Throwable e)
    {
       	StringWriter stringWriter = new StringWriter();
    	e.printStackTrace(new PrintWriter(stringWriter));    
    	
    	return stringWriter.toString();
    }
	
	public static void initialise()
	{
		String fileLocation = String.format("%1$s\\Log.txt", getTestRunDirectory());
		
		try
		{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileLocation), "utf-8"));
		}
		catch (Exception e)
		{
			TestHelper.handleException("Failed to start writer", e, false);
		}
	}
	
    public static void logActionFailure(String failureMessage, Throwable e)
    {
    	logEntry(failureMessage);
    	logExceptionOrError(e);
    }

    public static void logExceptionOrError(Throwable e)
    {
    	logEntry("EXCEPTION/ERROR MESSAGE: " + e.getMessage()); 	
        logEntry("STACK-TRACE: " + getThrowableStackTrace(e));
    }
    
    public static void logScenarioEnd()
    {
        String entryText = "*** SCENARIO ENDED *** : " + TestHelper.getScenario().getName();
        logEntry(entryText);
    }
    
    public static void logScenarioStart()
    {
        String entryText = "*** SCENARIO STARTED *** : " + TestHelper.getScenario().getName();
        logEntry(entryText);
    }
    
    public static void logSuiteDuration()
    {
    	Duration suiteDuration = calculateSuiteDuration();
    	
    	long hours = suiteDuration.getStandardHours();
    	long minutes = suiteDuration.getStandardMinutes();
    	long seconds = suiteDuration.getStandardSeconds();
    	
    	minutes = minutes - (hours * 60);
    	
    	logEntry("*** RUN DURATION INFORMATION ***");
    	logEntry("Hours: " + hours + "	Minutes: " + minutes + "	Seconds: " + seconds);
    	
    }
	
    public static void logSuiteSetupEnd()
    {
      	logEntry("*** SUITE SETUP ENDED *** \n" + System.lineSeparator());
    }
    
    public static void logSuiteSetupStart()
    {
    	startSuiteRunTimer();
    	logEntry("*** SUITE SETUP STARTED ***");
    }
    
    public static void logSuiteTeardownEnd()
    {
      	logEntry("*** SUITE TEARDOWN ENDED *** " + System.lineSeparator());
      	logSuiteDuration();
    }
    
    public static void logSuiteTeardownStart()
    {
    	logEntry("*** SUITE TEARDOWN STARTED ***");
    }
	
    public static void logTestResult()
    {
    	String result = TestHelper.getScenario().isFailed() ? "FAIL" : "PASS";
    	logEntry("Scenario: " + TestHelper.getScenario().getName() + " *** Finished with the Result: " + result + System.lineSeparator());
    }
    
    public static void startSuiteRunTimer()
    {
    	suiteRunStart = new DateTime();
    }
    
    private static Duration calculateSuiteDuration()
    {
    	DateTime suiteRunEnd = new DateTime();
    	Interval interval = new Interval(suiteRunStart, suiteRunEnd);
    	
    	return interval.toDuration();
    }
    
    private static void logEntry(String entryText)
    {    	
    	try 
    	{
    		String textToLog = TestHelper.getTodaysDateTime(logDateTimeFormat) + " " + entryText + System.lineSeparator();
			writer.append(textToLog);
			System.out.print(textToLog);
		} 
    	catch (IOException e)
    	{			
			e.printStackTrace();
		}
    }
}
