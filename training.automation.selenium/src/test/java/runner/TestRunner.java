package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import tests.ScenarioHooks;
import tests.TestLogger;
import utilities.Helper;
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
	@Parameters( { "browser", "applicationWebsite", "boardName" } )
	public void testSuiteSetup(String browser, String applicationWebsite, String boardName)
	{
		TestLogger.logSuiteSetupStart();
		
		SeleniumDriverHelper.initialise(browser, applicationWebsite);
		
		Helper.LogInCreateBoard();
		
		TestLogger.logSuiteSetupEnd();
	}
	
	@AfterTest (alwaysRun = true)
	public void testSuiteTearDown()
	{
		TestLogger.logSuiteTeardownStart();
		
		Helper.DeleteBoard();		
		
		SeleniumDriverHelper.getWebDriver().quit();
		
		TestLogger.logSuiteTeardownEnd();
		
		TestLogger.close();
	}
	
	@Before
	public void before(Scenario scenario)
	{
		ScenarioHooks.scenarioSetup(scenario);
		
		TestLogger.logScenarioStart();
	}
	
	@After
	public void after()
	{
		TestLogger.logScenarioEnd();
		
		TestLogger.logTestResult();
	}
}
