package stepdefinitions;

import org.testng.Assert;

import application.DesktopWebsite;
import cucumber.api.java.en.Given;
import utilities.SeleniumDriverHelper;

public class SplashPageSteps
{	
	@Given("^I am on the Trello splash page$")
	public static void iAmOnTheTrelloSplashPage()
	{
		try
		{
			Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Trello");
		}
		catch (AssertionError a)
		{
			DesktopWebsite.header.trelloLogoHome.click();
			
			try
			{
				Thread.sleep(2000);
			}
			catch (Exception e)
			{
				
			}
			
			DesktopWebsite.header.accountAvatar.jsClick();
			
			DesktopWebsite.boardsPage.logOutButton.click();
			
			SeleniumDriverHelper.getWebDriver().manage().deleteAllCookies();	
			System.out.println("deleting cookies");
		
			DesktopWebsite.logInPage.giantTrelloImage.click();
			
			try
			{
				Thread.sleep(2000);
			}
			catch (Exception e)
			{
				
			}
		}
	}
	
	@Given("^I click the log in button on the splash page$")
	public static void iClickOnTheLogInButtonOnTheSplashPage()
	{
		DesktopWebsite.splashPage.logIn.click();
	}
}