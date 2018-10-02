package stepdefinitions;

import org.testng.Assert;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;

public class LogInPageSteps
{
	@Given("^I am on the Trello Log In page$")
	public static void iAmOnTheTrelloLogInPage()
	{
			Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Log In | Trello");
	}
	
	@Given ("^I set up the environment with \"(.*?)\" and \"(.*?)\"$")
	public static void iSetUpTheEnvironmentWithEmailAndPassword(String email, String password)
	{
		DesktopWebsite.logInPage.createAnAccount.assertElementIsDisplayed();
		
		DesktopWebsite.logInPage.emailAddress.inputText(email);
		
		DesktopWebsite.logInPage.password.inputText(password);
		
		DesktopWebsite.logInPage.logInButton.click();
		
		DesktopWebsite.boardsPage.addButton.waitForElementToBeClickable();
		
		Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Boards | Trello");
	}
	
	@When("^I enter \"(.*?)\" in the email field$")
	public static void iEnterEmailInTheEmailField(String email)
	{
		DesktopWebsite.logInPage.emailAddress.inputText(email);
	}
	
	@And("^I enter \"(.*?)\" in the password field")
	public static void iEnterPasswordInThePasswordField(String password)
	{
		DesktopWebsite.logInPage.password.inputText(password);
	}
	
	@And("^I click the log in button$")
	public static void iClickTheLogInButton()
	{
		DesktopWebsite.logInPage.logInButton.click();
	}
}
