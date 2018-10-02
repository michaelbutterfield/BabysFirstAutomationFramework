package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.WiniumDriverHelper;

@CucumberOptions(
		features =	{ "src/test/resources/Features" },
		glue =		{ "stepdefinitions", "utilities", "runner" },
		tags =		{ "@Calculator" }
				)

public class TestRunner extends AbstractTestNGCucumberTests
{
	@BeforeTest
	@Parameters( { "applicationPath", "winiumPath", "winiumPort" } )
	public void testSetup(String applicationPath, String winiumPath, Integer winiumPort)
	{
		WiniumDriverHelper.initialise(applicationPath, winiumPath, winiumPort);
	}
	
	@AfterTest (alwaysRun = true)
	public void testTearDown()
	{
		WiniumDriverHelper.destroyDriver();
	}
}