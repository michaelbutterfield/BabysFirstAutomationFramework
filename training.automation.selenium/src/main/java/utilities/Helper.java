package utilities;

import org.junit.Assert;

import application.DesktopWebsite;
import data.TrelloWebData;

public class Helper
{
	public static void LogIn(String email, String password)
	{
		SeleniumDriverHelper.getWebDriver().get("http://www.trello.com/login");
		
		DesktopWebsite.logInPage.createAnAccount.assertElementIsDisplayed();
		
		DesktopWebsite.logInPage.emailAddress.inputText(TrelloWebData.getUsername());
		
		DesktopWebsite.logInPage.password.inputText(TrelloWebData.getPassword());
		
		DesktopWebsite.logInPage.logInButton.click();
		
		DesktopWebsite.boardsPage.addButton.waitForElementToBeClickable();
		
		Assert.assertEquals(SeleniumDriverHelper.getWebDriver().getTitle(), "Boards | Trello");
	}
	
	public static void CreateBoard(String boardName)
	{
		DesktopWebsite.boardsPage.addButton.click();
		
		DesktopWebsite.boardsPage.createNewBoardButton.click();
		
		DesktopWebsite.boardsPage.nameInput.inputText(boardName);
		
		DesktopWebsite.boardsPage.backgroundSelectionButton.click();
		
		DesktopWebsite.boardsPage.createBoardButton.click();
		
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
	
	public static void DeleteBoard()
	{
		DesktopWebsite.header.backToHome.jsClick();
		
		//Allow home page to load before trying to click on anything		
		try
		{
			Thread.sleep(3000);
		}
		catch (Exception e)
		{
		
		}
		
		DesktopWebsite.boardsPage.userBoardButton.click();
		
		DesktopWebsite.specificBoardsPage.moreSideMenuButton.click();
		
		DesktopWebsite.specificBoardsPage.closeBoard.click();
		
		DesktopWebsite.specificBoardsPage.closeBoardConfirmation.click();
		
		DesktopWebsite.specificBoardsPage.permDeleteBoard.click();
		
		DesktopWebsite.specificBoardsPage.permDeleteBoardConfirm.click();
		
		DesktopWebsite.boardsPage.boardNotFound.assertElementTextContains("Board not found.");
		
		DesktopWebsite.header.trelloLogoHome.click();
	}
}
