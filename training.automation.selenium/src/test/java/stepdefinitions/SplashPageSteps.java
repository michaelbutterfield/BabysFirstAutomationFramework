package stepdefinitions;

import org.testng.Assert;

import application.DesktopWebsite;
import cucumber.api.java.en.Given;
import utilities.SeleniumDriverHelper;

public class SplashPageSteps
{	
	@Given("^I was on the Trello splash page$")
	public static void iWasOnTheTrelloSplashPage()
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
			DesktopWebsite.header.logOut.click();
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
	
	@Given("^I clicked the log in button on the splash page$")
	public static void iClickedOnTheLogInButtonOnTheSplashPage()
	{
		DesktopWebsite.splashPage.logIn.click();
	}
}