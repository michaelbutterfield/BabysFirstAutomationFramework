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
import utilities.Helper;
import utilities.SeleniumDriverHelper;
import utilities.TestHelper;

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
		SeleniumDriverHelper.initialise(browser, applicationWebsite);
	}
	
	@AfterTest (alwaysRun = true)
	public void testSuiteTearDown()
	{
		if(TestHelper.scenarioHasTag("@BoardsPage"))
		{
			Helper.DeleteBoard();	
		}
		
		SeleniumDriverHelper.getWebDriver().quit();
	}
	
	@Before
	public void before(Scenario scenario)
	{
		ScenarioHooks.scenarioSetup(scenario);
	}
	
	@After
	public void after()
	{
		
	}
}
