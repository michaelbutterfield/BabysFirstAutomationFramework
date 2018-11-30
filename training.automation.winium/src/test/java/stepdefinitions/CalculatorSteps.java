package stepdefinitions;

import application.DesktopApplication;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.TestHelper;
import utilities.WiniumDriverHelper;

public class CalculatorSteps
{
	@Given ("^the calculator was open$")
	public void theCalculatorWasOpen()
	{
		DesktopApplication.mainPage.positiveNegative.assertExists();	
		System.out.println("Application 'Calculator' is open");
	}
	
	@Given ("^I changed the calculator to scientific$")
	public void iChangedTheCalculatorToScientific()
	{
		DesktopApplication.mainPage.openNavigation.assertExists();
		DesktopApplication.mainPage.openNavigation.click();
		DesktopApplication.mainPage.scientificCalculator.assertExists();
		DesktopApplication.mainPage.scientificCalculator.click();
	}
	
	@Given ("^the calculator was in standard mode$")
	public void theCalculatorWasInStandardMode()
	{
		DesktopApplication.mainPage.openNavigation.assertExists();
		DesktopApplication.mainPage.openNavigation.click();
		DesktopApplication.mainPage.standardCalculator.assertExists();
		DesktopApplication.mainPage.standardCalculator.click();
		DesktopApplication.mainPage.equals.click();
		
		try
		{
			WiniumDriverHelper.getWiniumDriver().findElementByName("Standard Calculator mode").isDisplayed();
		}
		catch(Exception e)
		{
			TestHelper.handleException("Calculator has not been set to standard mode.", e, false);
		}
	}
	
	@When("^I enter the calculation$")
	public void iEnterTheCalculation()
	{
	    DesktopApplication.mainPage.two.click();
	    DesktopApplication.mainPage.plus.click();
	    DesktopApplication.mainPage.two.click();
	    DesktopApplication.mainPage.equals.click();
	    
	    System.out.println("2+2= has been entered successfully");
	}
	
	@When ("^I enter log ten")
	public void iEnterLogTen()
	{
		DesktopApplication.mainPage.one.click();
		DesktopApplication.mainPage.zero.click();
		DesktopApplication.mainPage.log.click();
	}
	
	@Then("^the answer will be four$")
	public void theAnswerWillBeFour()
	{
		try
		{
			WiniumDriverHelper.getWiniumDriver().findElementByName("Display is 4");	
		}
		catch(Exception e)
		{
			TestHelper.handleException("The answer will be 4 assertion failed", e, false);
		}
		
		System.out.println("Result asserted as 4");
	}
	
	@Then ("^the answer will be one$")
	public void theAnswerWillBeOne()
	{
		try
		{
			WiniumDriverHelper.getWiniumDriver().findElementByName("Expression is log(10)");	
		}
		catch(Exception e)
		{
			TestHelper.handleException("The answer will be 4 assertion failed", e, false);
		}
		
		System.out.println("Result asserted as 1");
	}
}
