package utilities;

import application.DesktopWebsite;

public class Helper
{
	public static void DeleteBoard()
	{
		TestHelper.sleepInSeconds(2);
		
		DesktopWebsite.header.backToHome.jsClick();
		
		TestHelper.sleepInSeconds(2);
		
		DesktopWebsite.boardsPage.userBoard.click();
		DesktopWebsite.specificBoardsPage.moreSideMenu.click();
		DesktopWebsite.specificBoardsPage.closeBoard.click();
		DesktopWebsite.specificBoardsPage.closeBoardConfirmation.click();
		DesktopWebsite.specificBoardsPage.permDeleteBoard.click();
		DesktopWebsite.specificBoardsPage.permDeleteBoardConfirm.click();
		DesktopWebsite.boardsPage.boardNotFound.assertElementTextContains("Board not found.");
		DesktopWebsite.header.trelloLogoHome.click();
	}
}
