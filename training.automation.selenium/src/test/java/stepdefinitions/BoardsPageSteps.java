package stepdefinitions;

import static org.hamcrest.Matchers.is;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.By;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.SeleniumDriverHelper;
import utilities.TestHelper;
import utilities.TrelloWebData;

public class BoardsPageSteps
{
	@Given ("^I am on the splash page$")
	public static void iWasOnTheSplashPage()
	{
		DesktopWebsite.splashPage.logIn.assertElementIsDisplayed();
	}
	
	@Given ("^I am on the boards page$")
	public static void iWasOnTheBoardsPage()
	{
		DesktopWebsite.header.add.waitForElementToBeClickable();
		TestHelper.assertThat(SeleniumDriverHelper.getWebDriver().getTitle(), is("Boards | Trello"), "Assert that the framework is on the boards page.");
	}
	
	@Given ("^I clicked on the user created board$")
	public static void iClickedOnTheUserCreatedBoard()
	{
		DesktopWebsite.boardsPage.userBoard.click();
	}
	
	@Given ("^I click the add button in the top right")
	public static void iClickTheAddButtonInTheTopRight()
	{
		DesktopWebsite.header.add.click();
	}
	
	@When ("^I click the Create Board... option$")
	public static void iClickTheCreateBoardOption()
	{
		DesktopWebsite.boardsPage.createNewBoard.click();
	}
	
	@When ("^I click the favourite board star$")
	public static void iClickTheFavouriteBoardStar()
	{
		SeleniumDriverHelper.hoverOverElement("TestBoard");
		
		DesktopWebsite.boardsPage.favourite.click();
	}
	
	@When ("^I create the user board$")
	public static void iCreateTheUserBoard()
	{
		DesktopWebsite.header.add.click();
		DesktopWebsite.boardsPage.createNewBoard.click();
		DesktopWebsite.createBoardPage.nameInput.inputText("TestBoard");
		//DesktopWebsite.createBoardPage.backgroundSelection.click();
		DesktopWebsite.createBoardPage.createBoard.click();
	}

	@When ("^I log in$")
	public static void iLogIn()
	{
		DesktopWebsite.splashPage.logIn.click();
		DesktopWebsite.logInPage.createAnAccount.waitForElementToVisible();
		DesktopWebsite.logInPage.emailAddress.inputText(TrelloWebData.getUsername());
		DesktopWebsite.logInPage.password.inputText(TrelloWebData.getPassword());
		DesktopWebsite.logInPage.logIn.click();
	}
	
	@And ("^I confirm the board is no longer there$")
	public static void iConfirmTheBoardIsNoLongerThere()
	{
		DesktopWebsite.boardsPage.boardNotFound.assertElementTextContains("Board not found.");
	}
	
	@And ("^I create a new board with \"(.*?)\" and a background$")
	public static void iCreateANewBoardWithNameAndABackground(String boardName)
	{
		DesktopWebsite.createBoardPage.nameInput.inputText(boardName);
		DesktopWebsite.createBoardPage.backgroundSelection.click();
		DesktopWebsite.createBoardPage.createBoard.click();
	}
	
	@Then ("^I will be on the Trello user boards page$")
	public static void iWillBeOnTheTrelloUserBoardsPage()
	{
		String stepDescription = "Assert that the title of the web page '" + SeleniumDriverHelper.getWebDriver().getTitle() + "'" + " is equal to what is expected: 'Boards | Trello'";
		TestHelper.assertThat(SeleniumDriverHelper.getWebDriver().getTitle(), is("Boards | Trello"), stepDescription);
	}
	
	@Then ("^The board will be favourited$")
	public static void theBoardWillBeFavourited()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			
		}
		
		String boardIsStarred = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/div/div/div[2]/div/div/div[1]/div/ul/li/a/div/div[2]/span/span")).getAttribute("class");
		TestHelper.assertThat(boardIsStarred, is("icon-sm icon-star is-starred board-tile-options-star-icon"), "Assert that the board has been hovered over and the star clicked - making it a favourite board");
	}
	
	@Then ("^the environment will be set up$")
	public static void theEnvironmentWillBeSetUp()
	{
		TestHelper.sleepInSeconds(4);
		
		DesktopWebsite.header.backToHome.jsClick();
		DesktopWebsite.boardsPage.userBoard.waitForElementToBeClickable();
		DesktopWebsite.boardsPage.userBoard.assertElementIsClickable();
	}
	
	@Then ("^I confirm the board is created$")
	public static void iConfirmTheBoardIsCreated()
	{
		DesktopWebsite.boardsPage.userBoard.assertElementIsDisplayed();
	}
}