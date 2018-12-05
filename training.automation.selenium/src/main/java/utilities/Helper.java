package utilities;

import application.DesktopWebsite;

public class Helper
{
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
