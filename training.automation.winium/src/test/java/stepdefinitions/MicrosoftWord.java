package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.TestHelper;
import utilities.WiniumDriverHelper;

public class MicrosoftWord
{
	@Given("^I open word$")
	public void iOpenWord()
	{
		try
		{
			WiniumDriverHelper.getWiniumDriver().findElementByName("Blank document");
		}
		catch(Exception e)
		{
			String errorMessage = "Yeah nah you're not on the word page";
			TestHelper.handleException(errorMessage, e, false);
		}
	}

	@When("^I open a new document$")
	public void iOpenANewDocument()
	{
		WiniumDriverHelper.getWiniumDriver().findElementByName("Blank document").click();
	}

	@When("^I type a message$")
	public void iTypeAMessage()
	{
		WiniumDriverHelper.getWiniumDriver().findElementByName("Page 1 content").sendKeys("");
	}

	@Then("^the message will be displayed$")
	public void theMessageWillBeDisplayed()
	{
	    
	}
}