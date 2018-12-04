package utilities;

import static org.hamcrest.Matchers.is;

import application.DesktopWebsite;
import trello.TrelloWebData;

public class Helper
{
	public static void LogInCreateBoard()
	{
		DesktopWebsite.splashPage.logIn.click();
		DesktopWebsite.logInPage.createAnAccount.waitForElementToVisible();
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
		
	public static void DeleteBoard()
	{
		DesktopWebsite.header.backToHome.jsClick();
		
		try
		{
			Thread.sleep(2000);
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
