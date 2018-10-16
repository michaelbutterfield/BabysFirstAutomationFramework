package stepdefinitions;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import data.TrelloWebData;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumDriverHelper;
import utilities.TestHelper;

public class BoardsPageSteps
{
	@Given ("^I am on the boards page$")
	public static void iAmOnTheBoardsPage()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			
		}
		
		Assert.assertEquals("Boards | Trello", SeleniumDriverHelper.getWebDriver().getTitle());
		System.out.println("Assert browser is currently on the Boards page");
	}
	
	@Given ("^I click on the user created board$")
	public static void iClickOnTheUserCreatedBoard()
	{
		DesktopWebsite.boardsPage.userBoardButton.click();
	}
	
	@Given ("^I click the add button in the top right")
	public static void iClickTheAddButtonInTheTopRight()
	{
		DesktopWebsite.header.addButton.click();
	}
	
	@Given ("^I set up the environment with email and password and create the board")
	public static void iSetUpTheEnvironmentWithEmailAndPasswordAndCreateTheBoard()
	{
		SeleniumDriverHelper.getWebDriver().get("http://www.trello.com/login");
		DesktopWebsite.logInPage.createAnAccount.assertElementIsDisplayed();
		DesktopWebsite.logInPage.emailAddress.inputText(TrelloWebData.getUsername());
		DesktopWebsite.logInPage.password.inputText(TrelloWebData.getPassword());
		DesktopWebsite.logInPage.logInButton.click();
		DesktopWebsite.header.addButton.waitForElementToBeClickable();
		TestHelper.assertThat(SeleniumDriverHelper.getWebDriver().getTitle(), is("Boards | Trello"), "Assert that the title of the web page '" + SeleniumDriverHelper.getWebDriver().getTitle() + "'" + " is equal to what is expected: 'Boards | Trello'");
		DesktopWebsite.header.addButton.click();
		DesktopWebsite.boardsPage.createNewBoardButton.click();
		DesktopWebsite.createBoardPage.nameInput.inputText("TestBoard");
		DesktopWebsite.createBoardPage.backgroundSelectionButton.click();
		DesktopWebsite.createBoardPage.createBoardButton.click();
		
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{

		}
		
		DesktopWebsite.header.backToHome.jsClick();
		DesktopWebsite.boardsPage.userBoardButton.assertElementIsDisplayed();
	}
	
	@When ("^I click the Create Board... option$")
	public static void iClickTheCreateBoardOption()
	{
		DesktopWebsite.boardsPage.createNewBoardButton.click();
	}
	
	@When ("^I click the favourite board star$")
	public static void iClickTheFavouriteBoardStar()
	{
		WebElement userBoard = SeleniumDriverHelper.getWebDriver().findElement(By.xpath("//div[contains(text(),'TestBoard')]"));
		Actions action = new Actions(SeleniumDriverHelper.getWebDriver());
		action.moveToElement(userBoard).perform();
		DesktopWebsite.boardsPage.favouriteButton.click();
		System.out.println("Successfully hovered over the user board and clicked favourite");
		
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			//eat exception
		}
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
		DesktopWebsite.createBoardPage.backgroundSelectionButton.click();
		DesktopWebsite.createBoardPage.createBoardButton.click();
	}
	
	@Then ("^I will be on the Trello user boards page$")
	public static void iWillBeOnTheTrelloUserBoardsPage()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
			
		}
		
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
	
	@Then ("^I confirm the board is created$")
	public static void iConfirmTheBoardIsCreated()
	{
		DesktopWebsite.boardsPage.userBoardButton.assertElementIsDisplayed();
	}
}