package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import appium.AppiumServerManager;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import data.DeviceDetails;
import utilities.AppiumDriverHelper;

@CucumberOptions(
		features =	{ "src/test/resources/Features" },
		glue =		{ "stepdefinitions", "utilities", "runner" },
		tags =		{ "@Contacts" }
				)

public class TestRunner extends AbstractTestNGCucumberTests
{
	
	@Before
	public void testSetup()
	{
		
	}
	
	@BeforeTest
	@Parameters(
	{ "iPadName", "appiumServerIP", "appiumServerPort", "appiumPort", "bundleId" })
	public void testSuiteSetup(String iPadName, String appiumServerIP, String appiumServerPort, String appiumPort, String bundleId)
	{
		AppiumServerManager.setAppiumServerDetails(appiumServerIP, appiumServerPort);
		AppiumServerManager.setAppiumPort(appiumPort);
		AppiumServerManager.start();
		AppiumDriverHelper.launchApplication(appiumServerIP, appiumPort, DeviceDetails.getCapabilities(iPadName, bundleId));
	}
	
	@AfterTest (alwaysRun = true)
	public void testTearDown()
	{
		AppiumDriverHelper.closeApplication();
	}
}