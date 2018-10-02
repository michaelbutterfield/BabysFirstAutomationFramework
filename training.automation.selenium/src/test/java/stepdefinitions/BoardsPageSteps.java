package stepdefinitions;

import application.DesktopWebsite;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.SeleniumDriverHelper;

public class BoardsPageSteps
{
	@Given ("^I set up the environment with \"(.*?)\" and \"(.*?)\"$")
	public static void iSetUpTheEnvironmentWithEmailAndPassword(String email, String password)
	{
		SeleniumDriverHelper.getWebDriver().get("http://www.trello.com/login");
		
		DesktopWebsite.logInPage.createAnAccount.assertElementIsDisplayed();
		
		DesktopWebsite.logInPage.emailAddress.inputText(email);
		
		DesktopWebsite.logInPage.password.inputText(password);
		
		DesktopWebsite.logInPage.logInButton.click();
		
		DesktopWebsite.boardsPage.addButton.waitForElementToBeClickable();
		
		Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Boards | Trello");
	}
	
	@Given ("^I click the add button in the top right")
	public static void iClickTheAddButtonInTheTopRight()
	{
		DesktopWebsite.boardsPage.addButton.click();
	}
	
	@Given ("^I am on the boards page$")
	public static void iAmOnTheBoardsPage()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			
		}
		
		Assert.assertEquals("Boards | Trello", SeleniumDriverHelper.getWebDriver().getTitle());
		
		System.out.println("Assert browser is currently on the Boards page");
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
	
	@When ("^I click the Create Board... option$")
	public static void iClickTheCreateBoardOption()
	{
		DesktopWebsite.boardsPage.createNewBoardButton.click();
	}
	
	@And ("^I create a new board with \"(.*?)\" and a background$")
	public static void iCreateANewBoardWithNameAndABackground(String boardName)
	{
		DesktopWebsite.boardsPage.nameInput.inputText(boardName);
		
		DesktopWebsite.boardsPage.backgroundSelectionButton.click();
		
		DesktopWebsite.boardsPage.createBoardButton.click();
	}
	
	//delete board
	@Given ("^I click on the user created board$")
	public static void iClickOnTheUserCreatedBoard() throws InterruptedException
	{
		DesktopWebsite.boardsPage.userBoardButton.click();
	}
	
	@When ("^I click More in the side menu$")
	public static void iClickMoreInTheSideMenu()
	{
		DesktopWebsite.specificBoardsPage.moreSideMenuButton.click();
	}
	
	@And ("^I click close board$")
	public static void iClickCloseBoard()
	{
		DesktopWebsite.specificBoardsPage.closeBoard.click();
	}
	
	@And ("^I click the close board confirmation$")
	public static void iClickTheCloseBoardConfirmation()
	{
		DesktopWebsite.specificBoardsPage.closeBoardConfirmation.click();
	}
	
	@And ("^I confirm the permanent deletion of the board$")
	public static void iConfirmThePermanentDeletionOfTheBoard()
	{
		DesktopWebsite.specificBoardsPage.permDeleteBoard.click();
	
		DesktopWebsite.specificBoardsPage.permDeleteBoardConfirm.click();
	}
	
	@And ("^I confirm the board is no longer there$")
	public static void iConfirmTheBoardIsNoLongerThere()
	{
		DesktopWebsite.boardsPage.boardNotFound.assertElementTextContains("Board not found.");
	}
	
	@Then ("^The board will be favourited$")
	public static void theBoardWillBeFavourited()
	{
		
	}
	
	@Then ("^I click the Trello Logo Home button$")
	public static void iClickTheTrelloLogoHomeButton()
	{
		DesktopWebsite.header.trelloLogoHome.click();
	}
	
	@Then ("^I click the Back to Home button$")
	public static void iClickTheTrelloHomeButton()
	{
		DesktopWebsite.header.backToHome.jsClick();
	}
	
	@Then ("^I confirm the board is created$")
	public static void iConfirmTheBoardIsCreated()
	{
		DesktopWebsite.boardsPage.userBoardButton.assertElementIsDisplayed();
	}
}