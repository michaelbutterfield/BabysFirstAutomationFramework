package utilities;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import cucumber.api.Scenario;


public final class TestHelper
{
	private static Scenario currentScenario;
	
	public static <T> void assertThat(T actual, Matcher<? super T> matcher, String stepDescription)
	{
		assertThat(actual, matcher, stepDescription, true);
	}
	
	public static <T> void assertThat(T actual, Matcher<? super T> matcher, String stepDescription, Boolean takeScreenshot)
	{		
		try
		{		
			MatcherAssert.assertThat(stepDescription, actual, matcher);
		}
		catch (Throwable e)
		{
			String errorMessage = stepDescription + " failed." + System.lineSeparator() + e.getMessage();
			handleException(errorMessage, e, takeScreenshot);
		}
	}
	
	public static Scenario getScenario()
	{
		return currentScenario;
	}
	
    public static String getTodaysDateTime(String format)
	{
		DateFormat dateTimeFormat = new SimpleDateFormat(format);
				
		Date date = new Date();
		
		return dateTimeFormat.format(date);
	}
    
	public static void handleException(String errorMessage, Throwable e, Boolean takeScreenshot)
	{
		String exception = String.format("%1$s : %2$s : ", errorMessage, e);
		System.out.println(exception);
		
		throw new RuntimeException(e.getMessage(), e.getCause());
	}

	public static String removeNonAlphaNumericCharacters(String text)
	{
		return text.replaceAll("[^A-Za-z0-9]", "");
	}
	
	public static String removeNonNumericOrPointCharacters(String text)
	{
		return text.replaceAll("[^\\d.]", "").trim();
	}
	
	public static String removeNonNumericCharacters(String text)
	{
		return text.replaceAll("[^\\d]", "").trim();
	}
	
	public static Double roundDoubleDownToTwoDecimalPlaces(double value)
	{
		return Double.parseDouble(roundDoubleDownToTwoDecimalPlacesAsText(value));
	}
	
	public static Double roundDoubleDownToTwoDecimalPlaces(String value)
	{
		return Double.parseDouble(roundDoubleDownToTwoDecimalPlacesAsText(Double.parseDouble(value)));
	}
	
	public static String roundDoubleDownToTwoDecimalPlacesAsText(double value)
	{
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		decimalFormat.setRoundingMode(RoundingMode.DOWN); 
		
		return decimalFormat.format(value);	
	}
	
	public static double roundDoubleHalfUpToTwoDecimalPlaces(double value)
	{
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP); 		
		
		return Double.parseDouble(decimalFormat.format(value));	
	}
	
	public static Double roundDoubleToTwoDecimalPlaces(double value)
	{
		return Double.parseDouble(roundDoubleToTwoDecimalPlacesAsText(value));
	}
	
	public static String roundDoubleToTwoDecimalPlacesAsText(double value)
	{
		DecimalFormat decimalFormat = new DecimalFormat(".00"); 
		return decimalFormat.format(value);	
	}
	
	public static Double roundDoubleUpToTwoDecimalPlaces(double value)
	{
		return Double.parseDouble(roundDoubleUpToTwoDecimalPlacesAsText(value));
	}
	
	public static Double roundDoubleUpToTwoDecimalPlaces(String value)
	{
		return Double.parseDouble(roundDoubleDownToTwoDecimalPlacesAsText(Double.parseDouble(value)));
	}
	
	public static String roundDoubleUpToTwoDecimalPlacesAsText(double value)
	{
		DecimalFormat decimalFormat = new DecimalFormat(".00");
		decimalFormat.setRoundingMode(RoundingMode.UP); 
		
		return decimalFormat.format(value);	
	}

	public static Boolean scenarioHasTag(String tagName)
	{
		return getScenario().getSourceTagNames().contains(tagName);
	}
	
	public static void setScenario(Scenario scenario)
	{
		currentScenario = scenario;
	}
	
	public static void sleepInSeconds(int seconds)
	{
		try
		{
			Thread.sleep(seconds * 1000);
		}
		catch (InterruptedException e)
		{
			String errorMessage = String.format("Unable to perform the requested '%1$s' second sleep", seconds);
			TestHelper.handleException(errorMessage, e, false);
		}
	}
}