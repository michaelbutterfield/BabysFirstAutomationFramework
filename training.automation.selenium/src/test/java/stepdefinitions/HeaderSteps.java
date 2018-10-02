package stepdefinitions;

import application.DesktopWebsite;
import cucumber.api.java.en.Then;

public class HeaderSteps
{
	@Then ("^I click the Back to Home button$")
	public static void iClickTheTrelloHomeButton()
	{
		DesktopWebsite.header.backToHome.jsClick();
	}
	
	@Then ("^I click the Trello Logo Home button$")
	public static void iClickTheTrelloLogoHomeButton()
	{
		DesktopWebsite.header.trelloLogoHome.click();
	}
}
