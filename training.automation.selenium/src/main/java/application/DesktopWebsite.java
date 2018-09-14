package application;

import application.pages.*;
import application.sections.*;

public final class DesktopWebsite
{	
	public static HomePage homePage;
	public static LogInPage logInPage;
	public static BoardsPage boardsPage;
	public static SpecificBoardsPage specificBoardsPage;
	public static Header header;
	
	static
	{
		buildPages();
		buildSections();
	}
	
	private static void buildPages()
	{
		homePage = new HomePage();
		logInPage = new LogInPage();
		boardsPage = new BoardsPage();
		specificBoardsPage = new SpecificBoardsPage();
	}
	
	private static void buildSections()
	{
		header = new Header();
	}
}
