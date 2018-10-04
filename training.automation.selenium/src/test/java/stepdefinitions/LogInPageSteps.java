package stepdefinitions;

import org.testng.Assert;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.TrelloWebData;
import utilities.SeleniumDriverHelper;
import utilities.TestHelper;

import static org.hamcrest.Matchers.is;

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
	
	@When ("^I enter valid credentials$")
	public static void iEnterValidCredentials()
	{
		DesktopWebsite.logInPage.emailAddress.inputText(TrelloWebData.getUsername());
		
		DesktopWebsite.logInPage.password.inputText(TrelloWebData.getPassword());
		
		DesktopWebsite.logInPage.logInButton.click();
	}
	
	@When ("^I enter invalid credentials$")
	public static void iEnterInvalidCredentials()
	{
		DesktopWebsite.logInPage.emailAddress.inputText("wrongemail@email.com");
		
		DesktopWebsite.logInPage.password.inputText("password123");
		
		DesktopWebsite.logInPage.logInButton.click();
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
	
	@Then ("^I will still be on the log in page$")
	public static void iWillStillBeOnTheLogInPage()
	{
		String stepDescription = ("Assert browser is currently on the log in page");
		
		TestHelper.assertThat(SeleniumDriverHelper.getWebDriver().getTitle(), is("Log in to Trello"), stepDescription);
	}
}
