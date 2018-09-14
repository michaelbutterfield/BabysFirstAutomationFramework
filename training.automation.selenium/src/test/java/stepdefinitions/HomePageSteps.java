package stepdefinitions;

import org.testng.Assert;

import application.DesktopWebsite;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;

public class HomePageSteps
{	
	@Given("^I am on the Trello home page$")
	public static void iAmOnTheTrelloHomePage()
	{
		Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Trello");
	}
	
	@Given("^I click on the Log In button$")
	public static void iClickOnTheLogInButton()
	{
		DesktopWebsite.homePage.logIn.click();
	}
	
	@When("^I am navigated to the log in page$")
	public static void iWillBeNavigatedToTheLogInPage()
	{
		DesktopWebsite.logInPage.createAnAccount.assertElementIsDisplayed();
	}
	
	@Then("^I will be on the log in page$")
	public static void iWillBeOnTheLogInPage()
	{
		DesktopWebsite.logInPage.createAnAccount.assertElementTextContains("create an account");	
	}
}