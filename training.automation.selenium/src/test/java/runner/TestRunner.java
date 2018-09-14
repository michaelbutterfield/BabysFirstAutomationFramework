package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.SeleniumDriverHelper;

@CucumberOptions(
		features =	{ "src/test/resources/Features" },
		glue =		{ "stepdefinitions", "utilities", "runner" },
		tags =		{ "@BoardsPage" },
		plugin =	{ "pretty:target/resources/cucumber-pretty.txt", "usage:TestReports/cucumber-usage.json",
					  "json:TestReports/cucumber.json", "html:target/resources/cucumber" })

public class TestRunner extends AbstractTestNGCucumberTests
{
	
	@BeforeTest
	@Parameters( { "browser", "applicationWebsite" } )
	public void testSetup(String browser, String applicationWebsite)
	{
		SeleniumDriverHelper.initialise(browser);
	}
	
	@AfterTest (alwaysRun = true)
	public void testTearDown()
	{
		SeleniumDriverHelper.getWebDriver().quit();
	}
}
