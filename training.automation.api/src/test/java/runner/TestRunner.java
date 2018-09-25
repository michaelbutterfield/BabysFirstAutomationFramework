package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features =	{ "src/test/resources/Features" },
		glue =		{ "stepdefinitions", "utilities", "runner" },
		tags =		{ "@TrelloApi" },
		plugin =	{ "pretty:target/resources/cucumber-pretty.txt", "usage:TestReports/cucumber-usage.json",
					  "json:TestReports/cucumber.json", "html:target/resources/cucumber" })

public class TestRunner extends AbstractTestNGCucumberTests
{
	
	@BeforeTest
	@Parameters( { "baseUri" } )
	public void testSetup(String baseUri)
	{

	}
	
	@AfterTest (alwaysRun = true)
	public void testTearDown()
	{

	}
}
