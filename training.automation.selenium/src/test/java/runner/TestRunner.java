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
		tags =		{ "@AddingListsAndCards" },
		plugin =	{ "pretty:target/resources/cucumber-pretty.txt", "usage:TestReports/cucumber-usage.json",
					  "json:TestReports/cucumber.json", "html:target/resources/cucumber" })

public class TestRunner extends AbstractTestNGCucumberTests
{		
	@BeforeTest
	@Parameters( { "browser", "applicationWebsite", "boardName" } )
	public void testSuiteSetup(String browser, String applicationWebsite, String boardName)
	{
		TestLogger.logSuiteSetupStart();
		
		TestLogger.logSuiteSetupEnd();
	}
	
	@AfterTest (alwaysRun = true)
	public void testSuiteTearDown()
	{
		TestLogger.logSuiteTeardownStart();
		
		TestLogger.logSuiteTeardownEnd();
		
		TestLogger.close();
	}
	
	@Before
	public void before(Scenario scenario)
	{
		TestLogger.logScenarioSetupStart();
		
		ScenarioHooks.scenarioSetup(scenario);
		
		SeleniumDriverHelper.initialise("chrome", "http://www.trello.com/");
		
		TestLogger.logScenarioSetupEnd();
		
		TestLogger.logScenarioStart();
	}
	
	@After
	public void after()
	{
		TestLogger.logScenarioEnd();
		
		TestLogger.logScenarioTeardownStart();
		
		Helper.DeleteBoard();		
		
		SeleniumDriverHelper.getWebDriver().close();
		
		TestLogger.logScenarioTeardownEnd();
		
		TestLogger.logTestResult();
	}
}
