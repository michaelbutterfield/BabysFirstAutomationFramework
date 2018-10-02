package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
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
	@Parameters( { "browser", "applicationWebsite", "email", "password", "boardName" } )
	public void testSetup(String browser, String applicationWebsite, String email, String password, String boardName)
	{
		SeleniumDriverHelper.initialise(browser, applicationWebsite);
		
		Helper.LogIn(email, password);
		
		Helper.CreateBoard(boardName);
	}
	
	@AfterTest (alwaysRun = true)
	public void testTearDown()
	{
		Helper.DeleteBoard();
		
		SeleniumDriverHelper.getWebDriver().quit();
	}
}
